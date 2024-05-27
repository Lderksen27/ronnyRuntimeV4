package ronnyRuntime.game.entities.bullet;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.SceneBorderCrossingWatcher;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.scenes.SceneBorder;
import ronnyRuntime.game.entities.map.platforms.Platform;
import ronnyRuntime.game.entities.monsters.Monster;
import ronnyRuntime.game.entities.ronnyRuntime.RonnyRuntime;
import javafx.scene.paint.Color;
import java.util.List;

/**
 * Wanneer Ronny schiet, verschijnt er een kogel waarmee hij monsters kan doden.
 */
public class Bullet extends DynamicRectangleEntity implements SceneBorderCrossingWatcher, Collided {

    private final RonnyRuntime RONNY;

    public Bullet(Coordinate2D initialLocation, Direction direction, RonnyRuntime ronny) {
        super(initialLocation);
        this.RONNY = ronny;
        setWidth(10);
        setHeight(2);
        setFill(Color.ORANGE);
        setMotion(4, direction);
    }

    @Override
    public void notifyBoundaryCrossing(SceneBorder sceneBorder) {
        this.remove();
    }

    @Override
    public void onCollision(List<Collider> list) {
        for (Collider collider : list) {
            if (collider instanceof Platform) {
                this.remove();
            } else if (collider instanceof Monster) {
                ((Monster) collider).die();
                RONNY.killMonster();
                this.remove();
            }
        }
    }
}