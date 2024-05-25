package ronnyRuntime.game.entities.monsters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import ronnyRuntime.game.scenes.GameLevel;

import java.util.Timer;

/**
 * Monster staat stil op een plek
 */
public class StationaryMonster extends Monster {

    public StationaryMonster(Coordinate2D initialLocation, Size size, GameLevel gameLevel) {
        super("sprites/Monster1/monster1.png", initialLocation, gameLevel);
        setCurrentFrameIndex(1);
    }
}