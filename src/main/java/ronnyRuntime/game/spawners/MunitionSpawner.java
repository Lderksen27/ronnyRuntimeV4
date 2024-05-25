package ronnyRuntime.game.spawners;

import com.github.hanyaeger.api.Coordinate2D;

import com.github.hanyaeger.api.entities.EntitySpawner;

import ronnyRuntime.game.entities.bullet.Munition;
import ronnyRuntime.game.entities.ronnyRuntime.RonnyRuntime;

/**
 * Spawner voor kogels die Ronny af kan schieten.
 */
public class MunitionSpawner extends EntitySpawner {

    private final Coordinate2D LOCATION;
    public MunitionSpawner(Coordinate2D location) {
        super(1);
        this.LOCATION = location;
    }

    @Override
    protected void spawnEntities() {
        spawn(new Munition(this.LOCATION));
        this.remove();
    }
}