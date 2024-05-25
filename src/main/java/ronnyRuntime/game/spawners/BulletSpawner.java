package ronnyRuntime.game.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.EntitySpawner;
import ronnyRuntime.game.entities.bullet.Bullet;
import ronnyRuntime.game.entities.ronnyRuntime.RonnyRuntime;

/**
 * Spawner voor kogels die Ronny af kan schieten.
 */
public class BulletSpawner extends EntitySpawner {

    private final Coordinate2D LOCATION;
    private final Direction DIRECTION;
    private final RonnyRuntime RONNY;

    private final double DELTA;

    public BulletSpawner(Coordinate2D location, Direction direction, double delta, RonnyRuntime ronny) {
        super(1);
        this.LOCATION = location;
        this.DIRECTION = direction;
        this.DELTA = delta;
        this.RONNY = ronny;
    }

    @Override
    protected void spawnEntities() {
        Coordinate2D bulletLocation = new Coordinate2D(LOCATION.getX(), LOCATION.getY() + DELTA);
        spawn(new Bullet(bulletLocation, DIRECTION, RONNY));
        this.remove();
    }
}