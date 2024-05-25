package ronnyRuntime.game.entities.bullet;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import ronnyRuntime.game.entities.powerUps.PowerUp;
import ronnyRuntime.game.entities.ronnyRuntime.RonnyRuntime;

public class Munition extends SpriteEntity implements PowerUp, Collider {
    public Munition(Coordinate2D initialLocation) {
        super("sprites/Bullet/bullets2.png", initialLocation, new Size(50, 50));
    }
    @Override
    public void geefEffect(RonnyRuntime ronny) {
        ronny.collectMunition();
        this.remove();
    }
}
