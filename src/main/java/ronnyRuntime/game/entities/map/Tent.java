package ronnyRuntime.game.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import ronnyRuntime.game.entities.highscore.Highscore;
import ronnyRuntime.game.entities.ronnyRuntime.RonnyRuntime;
import ronnyRuntime.game.entities.ronnyRuntime.HitBox;
import ronnyRuntime.game.ronnyRuntimeApp;
import java.util.List;

/**
 * Een tent is het eindpunt van een level.
 */
public class Tent extends DynamicSpriteEntity implements Collided {

    private final ronnyRuntimeApp APP;
    private final RonnyRuntime RONNY;

    private final int LEVEL;

    public Tent(Coordinate2D initialLocation, ronnyRuntimeApp ronnyRuntimeApp, int level, RonnyRuntime ronnyRuntime) {
        super("Objects/Items/tent.png", initialLocation, new Size(100, 100));
        this.APP = ronnyRuntimeApp;
        this.RONNY = ronnyRuntime;
        this.LEVEL = level;
    }

    @Override
    public void onCollision(List<Collider> list) {
        for (Collider collider : list) {
            if (collider instanceof HitBox) {
                final SoundClip LEVEL_DONE = new SoundClip("audio/levelDone.mp3");
                LEVEL_DONE.play();
                this.remove();
                RONNY.setAnchorLocation(new Coordinate2D(50, 50));
                if (LEVEL < 3) {
                    APP.setupScenes();
                    APP.setActiveScene(LEVEL + 1);
                } else {
                    boolean nieuweHighscore = isNieuweHighscore(RonnyRuntime.getPoints());
                    if (nieuweHighscore) {
                        APP.setActiveScene(6);
                    } else {
                        APP.setActiveScene(4);
                    }
                }
            }
        }
    }

    /**
     * Bepaalt of het aantal behaalde punten in een spel leidt tot een nieuwe highscore.
     * @param points behaalde aantal punten
     * @return boolean waarde die aangeeft of het wel of niet een nieuwe highscore betreft.
     */
    public boolean isNieuweHighscore (int points) {
        Highscore current = new Highscore();
        return points > current.getHighscorePoints();
    }
}