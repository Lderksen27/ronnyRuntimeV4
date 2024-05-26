package ronnyRuntime.game.entities.ronnyRuntime;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.DynamicCompositeEntity;
import com.github.hanyaeger.api.entities.Newtonian;
import com.github.hanyaeger.api.entities.SceneBorderTouchingWatcher;
import com.github.hanyaeger.api.media.SoundClip;
import com.github.hanyaeger.api.scenes.SceneBorder;
import com.github.hanyaeger.api.userinput.KeyListener;
import ronnyRuntime.game.entities.Orientation;
import ronnyRuntime.game.entities.buttons.DifficultyLevel;
import ronnyRuntime.game.entities.text.BulletText;
import ronnyRuntime.game.entities.text.LivesText;
import ronnyRuntime.game.entities.text.PointText;
import ronnyRuntime.game.ronnyRuntimeApp;
import ronnyRuntime.game.scenes.GameLevel;
import ronnyRuntime.game.spawners.BulletSpawner;
import javafx.scene.input.KeyCode;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;

/**
 * Basisklasse voor de speler
 */
public class RonnyRuntime extends DynamicCompositeEntity implements SceneBorderTouchingWatcher, Newtonian, KeyListener {

    private static int points = 0;
    private static int lives = 3;
    private static DifficultyLevel difficulty = DifficultyLevel.EASY;
    private int bullets = 10;

    private boolean touchdown = true;
    private boolean canShoot = true;
    private boolean invincible = false;
    private boolean isJumping = false;
    private boolean shootFast = false;
    private boolean movingOnElevator = false;

    private final HitBox HB_LEFT;
    private final HitBox HB_RIGHT;
    private final HitBox HB_TOP;
    private final HitBox HB_BOTTOM;
    private final Sprite SPRITE;
    private final GameLevel LEVEL;
    private final PointText POINT_TEXT;
    private final LivesText LIVES_TEXT;
    private final BulletText BULLET_TEXT;

    public RonnyRuntime(Coordinate2D location, GameLevel gameLevel){
        super(location);
        setFrictionConstant(0.2);
        setGravityConstant(2);
        this.POINT_TEXT = new PointText(new Coordinate2D(50, 50));
        this.POINT_TEXT.setPointText(points);
        this.LIVES_TEXT = new LivesText(new Coordinate2D(50,30));
        this.LIVES_TEXT.setLivesText(lives);
        this.BULLET_TEXT = new BulletText(new Coordinate2D(50, 70));
        this.BULLET_TEXT.setBulletText(bullets);
        this.HB_LEFT = new HitBox(new Coordinate2D(2,15), this, Orientation.LEFT,3, 20);
        this.HB_RIGHT = new HitBox(new Coordinate2D(40,15), this, Orientation.RIGHT, 3, 20);
        this.HB_TOP = new HitBox(new Coordinate2D(10,5), this, Orientation.TOP, 15, 3);
        this.HB_BOTTOM = new HitBox(new Coordinate2D(10, 45 ), this, Orientation.BOTTOM, 20, 3);
        this.SPRITE = new Sprite(new Coordinate2D(0,0), this);
        this.LEVEL = gameLevel;
    }

    @Override
    protected void setupEntities() {
        addEntity(SPRITE);
        addEntity(HB_BOTTOM);
        addEntity(HB_TOP);
        addEntity(HB_LEFT);
        addEntity(HB_RIGHT);
    }

    @Override
    public void notifyBoundaryTouching(SceneBorder border) {
        keepInMap(border);
    }

    public void setMovingOnElevator(boolean movingOnElevator) {
        this.movingOnElevator = movingOnElevator;
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        if (getTouchdown()){
            for (KeyCode keyCode : set) {
                switch (keyCode) {
                    case KeyCode.UP:
                            if (!movingOnElevator) {
                                jump();
                                setTouchdown(false);
                                setJumping(true);
                            }
                        break;
                    case KeyCode.LEFT:
                        if (!movingOnElevator) {
                            addToMotion(3, Direction.LEFT);
                        }
                        break;
                    case KeyCode.RIGHT:
                        if (!movingOnElevator) {
                            addToMotion(3, Direction.RIGHT);
                        }
                        break;
                    case KeyCode.SPACE:
                        if (canShoot && bullets > 0) {
                            shoot();
                        }
                }
            }
        } else if(isJumping()){
            for (KeyCode keyCode : set) {
                switch (keyCode) {
                    case KeyCode.LEFT:
                        addToMotion(1, Direction.LEFT);
                        break;
                    case KeyCode.RIGHT:
                        addToMotion(1, Direction.RIGHT);
                        break;
                    case KeyCode.SPACE:
                        if (canShoot) {
                            shoot();
                        }
                }
            }
        }
    }

    public boolean isShootFast() {
        return shootFast;
    }

    public void setShootFast(boolean shootFast) {
        this.shootFast = shootFast;
    }

    public static void setDifficulty(DifficultyLevel difficulty) {
        RonnyRuntime.difficulty = difficulty;
    }

    public static DifficultyLevel getDifficulty() {
        return difficulty;
    }

    public boolean getInvincible(){
        return invincible;
    }

    public Sprite getSprite () {
        return this.SPRITE;
    }

    public boolean getTouchdown () {
        return touchdown;
    }

    public PointText getPointText() {
        return this.POINT_TEXT;
    }

    public LivesText getLivesText() {
        return this.LIVES_TEXT;
    }

    public BulletText getBulletText() {
        return this.BULLET_TEXT;
    }

    public static int getPoints() {
        return points;
    }

    public boolean isJumping() {
        return isJumping;
    }

    public void setJumping(boolean jumping) {
        isJumping = jumping;
    }

    public void setTouchdown(boolean touchdown) {
        this.touchdown = touchdown;
    }

    public void setCanShoot(boolean canShoot) {
        this.canShoot = canShoot;
    }

    public void setInvincible(boolean invincible){
        this.invincible = invincible;
    }

    /**
     * Ronny heeft een munt gepakt en hierdoor stijgt zijn puntenaantal.
     */
    public void collectCoin() {
        points += 10;
        POINT_TEXT.setPointText(points);
    }

    public void collectMunition() {
        bullets += 3;
        BULLET_TEXT.setBulletText(bullets);
    }

    /**
     * Ronny doodt een monster, waarbij een geluid wordt afgespeeld en Ronny punten krijgt.
     */
    public void killMonster() {
        final SoundClip MONSTER_DEAD = new SoundClip("audio/monsterDead.mp3");
        MONSTER_DEAD.setVolume(0.5);
        MONSTER_DEAD.play();
        points += 50;
        POINT_TEXT.setPointText(points);
    }

    /**
     * Ronny wordt geraakt door een monster waarbij een geluid afgespeeld wordt,
     * Ronny punten verliest en eventueel dood gaat.
     */
    public void getHurt() {
        final SoundClip RONNY_HURT = new SoundClip("audio/ronnyHurt.mp3");
        RONNY_HURT.play();
        if (points >= 50) {
            points -= 50;
            POINT_TEXT.setPointText(points);
        } else {
            points = 0;
            POINT_TEXT.setPointText(points);
        }
        if (lives > 1) {
            lives--;
            LIVES_TEXT.setLivesText(lives);
        } else {
            final SoundClip DEAD_SOUND = new SoundClip("audio/dead.mp3");
            DEAD_SOUND.setVolume(0.5);
            DEAD_SOUND.play();
            ronnyRuntimeApp ronnyRuntimeApp = this.LEVEL.getRonnyRuntimeApp();
            ronnyRuntimeApp.setActiveScene(5);
        }
    }

    /**
     * Ronny gaat in 1x dood wanneer hij verdrinkt.
     */
    public void killRonny(){
        lives = 1;
        getHurt();
    }

    /**
     * Ronny krijgt een extra leven.
     */
    public void gainExtraLife(){
        final SoundClip HEAL_UP = new SoundClip("audio/healUp.mp3");
        HEAL_UP.play();
        lives++;
        LIVES_TEXT.setLivesText(lives);
    }

    /**
     * De waarden van de levens en punten worden gereset op Ronny.
     */
    public static void resetRonny() {
        lives = 3;
        points = 0;
    }

    /**
     * Ronny wordt tijdelijk onschendbaar en krijgt geen negatieve effecten van de monsters meer.
      */
    public void becomeInvincible() {
        final SoundClip INVINCIBLE_SOUND = new SoundClip("audio/invincible.mp3");
        INVINCIBLE_SOUND.setVolume(1.5);
        INVINCIBLE_SOUND.play();
        setInvincible(true);
        StarTask starTask = new StarTask((this));
        Timer starTimer = new Timer();
        starTimer.scheduleAtFixedRate(starTask, 0, 250);
        new java.util.Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                setInvincible(false);
            }
        }, 10000);
    }

    public void getMachinegun() {
        final SoundClip INVINCIBLE_SOUND = new SoundClip("audio/invincible.mp3");
        INVINCIBLE_SOUND.setVolume(1.5);
        INVINCIBLE_SOUND.play();
        setShootFast(true);
        new java.util.Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                setShootFast(false);
            }
        }, 10000);
    }

    /**
     * Zorgt ervoor dat Ronny binnen het scherm blijft.
     * @param border Rand die Ronny dreigt te overschreiden.
     */
    void keepInMap(SceneBorder border){
        switch (border) {
            case TOP:
                //setAnchorLocationY(1);
                break;
            case BOTTOM:
                final SoundClip WATER_SPLASH = new SoundClip("audio/waterSplash.mp3");
                WATER_SPLASH.setVolume(1.5);
                WATER_SPLASH.play();
                killRonny();
                setAnchorLocationY(getSceneHeight() - getHeight() - 1);
                break;
            case LEFT:
                setAnchorLocationX(1);
                break;
            case RIGHT:
                setAnchorLocationX(getSceneWidth() - getWidth() - 1);
            default:
                break;
        }
    }

    /**
    *Laat Ronny springen met een achtergrond muziek.
     */
    public void jump(){
        final SoundClip JUMP = new SoundClip("audio/jump.wav");
        JUMP.setVolume(0.3);
        JUMP.play();
        addToMotion(30, Direction.UP);
        touchdown = false;
    }

    /**
     * Zorgt ervoor dat Ronny kan schieten in de richting waarin hij keek.
     */
    public void shoot(){
        canShoot = false;
        bullets--;
        BULLET_TEXT.setBulletText(bullets);
        BulletSpawner bulletSpawner = new BulletSpawner(
            this.getAnchorLocation(),
            SPRITE.getPointsRight() ? Direction.RIGHT : Direction.LEFT,
            this.getHeight() / 2,
            this);
        this.LEVEL.addEntitySpawner(bulletSpawner);
        Timer shootDelay = new Timer();
        shootDelay.schedule(new ShootTimer(this), (shootFast ? 100 : 250));
        SoundClip shoot = new SoundClip("audio/shoot.mp3");
        shoot.setVolume(1.5);
        shoot.play();
    }
}