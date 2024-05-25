package ronnyRuntime.game.entities.monsters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import ronnyRuntime.game.entities.bullet.Munition;
import ronnyRuntime.game.scenes.GameLevel;
import ronnyRuntime.game.spawners.MunitionSpawner;

import java.util.Timer;

public abstract class Monster extends DynamicSpriteEntity implements Collider {

    private boolean isActive = true;
    private final GameLevel GAME_LEVEL;

    protected Monster(String resource, Coordinate2D initialLocation, GameLevel gameLevel) {
        super(resource, initialLocation, 1,2);
        this.GAME_LEVEL = gameLevel;
    }

    public void flash() {
        this.isActive = false;
        Timer flashTimer = new Timer();
        flashTimer.schedule(new FlashTask(this), 0, 250);
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void die() {
        Coordinate2D monsterLocation = this.getAnchorLocation();
        MunitionSpawner munitionSpawner = new MunitionSpawner(monsterLocation);
        this.GAME_LEVEL.addEntitySpawner(munitionSpawner);
        this.remove();
    }

    public void changeBrightness(boolean toggle) {
        this.setBrightness(toggle ? 0.8d : 0d);
    }
}
