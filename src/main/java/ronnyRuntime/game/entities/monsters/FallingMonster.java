package ronnyRuntime.game.entities.monsters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import ronnyRuntime.game.scenes.GameLevel;

import java.util.Timer;

/**
 * Monster valt vanuit de bovenkant van het scherm en verplaatst zich naar beneden.
 */
public class FallingMonster extends Monster implements SceneBorderCrossingWatcher {

    public FallingMonster(Coordinate2D initialLocation, GameLevel gameLevel) {
        super("sprites/Monster3/monster3.png", initialLocation, gameLevel);
        setCurrentFrameIndex(0);
        setMotion(2, 0d);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        remove();
    }
}