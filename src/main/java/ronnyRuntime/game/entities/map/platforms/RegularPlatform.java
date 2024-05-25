package ronnyRuntime.game.entities.map.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

/**
 * Standaard platform
 */
public class RegularPlatform extends Platform {
    public RegularPlatform(Coordinate2D initialLocation, Size size, String resource) {
        super(initialLocation, size, resource);
    }
}