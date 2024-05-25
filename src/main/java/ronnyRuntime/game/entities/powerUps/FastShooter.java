package ronnyRuntime.game.entities.powerUps;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import ronnyRuntime.game.entities.ronnyRuntime.RonnyRuntime;

/**
 * Een PowerUp die lijdt tot danwel een extra leven, dan wel invincibility.
 */
public class FastShooter extends SpriteEntity implements Collider, PowerUp {

    public FastShooter(Coordinate2D location, Size size, String resource) {
        super(resource, location, size);
    }

    @Override
    public void geefEffect(RonnyRuntime ronny) {
        ronny.getMachinegun();
        remove();
    }
}