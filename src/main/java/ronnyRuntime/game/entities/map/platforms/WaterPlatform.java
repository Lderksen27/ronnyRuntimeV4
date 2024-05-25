package ronnyRuntime.game.entities.map.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

/**
 * Waterplatform, waar je in kunt verdrinken.
 */
public class WaterPlatform extends SpriteEntity {

    // Deze class is qua verwerking zodanig anders dan de andere soorten platform, dat deze ook niet de class platform implementeert.

    public WaterPlatform(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }
}