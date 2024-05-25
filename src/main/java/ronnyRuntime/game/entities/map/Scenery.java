package ronnyRuntime.game.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;

/**
 * Elementen in het speelveld die geen effect hebben op hun omgeving.
 */
public class Scenery extends SpriteEntity {

    public Scenery(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }
}