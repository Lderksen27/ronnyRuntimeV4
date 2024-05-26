package ronnyRuntime.game.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.EntitySpawner;
import ronnyRuntime.game.entities.bullet.Munition;
import ronnyRuntime.game.entities.map.platforms.RegularPlatform;

/**
 * Spawner voor kogels die Ronny af kan schieten.
 */
public class PlatformSpawner extends EntitySpawner {

    private final Coordinate2D LOCATION;
    private Size size;
    public PlatformSpawner(Coordinate2D location, Size size) {
        super(1);
        this.LOCATION = location;
        this.size = size;
    }

    @Override
    protected void spawnEntities() {
        spawn(new RegularPlatform(this.LOCATION,size, "Objects/Tiles/elevator.png"));
        this.remove();
    }
}