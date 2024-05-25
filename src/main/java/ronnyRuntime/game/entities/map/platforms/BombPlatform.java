package ronnyRuntime.game.entities.map.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

/**
 * Platform die ontploft wanneer je erop komt.
 */
public class BombPlatform extends Platform {
    public BombPlatform(Coordinate2D initialLocation, Size size, String resource) {
        super(initialLocation, size, resource);
    }
}