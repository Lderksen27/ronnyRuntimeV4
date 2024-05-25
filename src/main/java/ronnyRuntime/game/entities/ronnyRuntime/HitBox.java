package ronnyRuntime.game.entities.ronnyRuntime;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.Collided;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import ronnyRuntime.game.entities.Orientation;
import ronnyRuntime.game.entities.map.platforms.Platform;
import ronnyRuntime.game.entities.monsters.Monster;

import java.util.List;
import javafx.scene.paint.Color;
import ronnyRuntime.game.entities.powerUps.PowerUp;

/**
 * Een hitbox voor Ronny, te specificeren per kant.
 */
public class HitBox extends RectangleEntity implements Collided, Collider {

    private final RonnyRuntime RONNY;
    private final Orientation ORIENTATION;

    public HitBox(Coordinate2D location, RonnyRuntime ronny, Orientation orientation, int width, int height) {
        super(location);
        setWidth(width);
        setHeight(height);
        setFill(Color.TRANSPARENT);
        this.ORIENTATION = orientation;
        this.RONNY = ronny;
    }
    public Orientation getOrientation() {
        return this.ORIENTATION;
    }

    public RonnyRuntime getRonny () {
        return this.RONNY;
    }
    @Override
    public void onCollision(List<Collider> list) {
        for (Collider collider : list) {
             if (collider instanceof Monster) {
                monsterCollision((Monster) collider);
            } else if (collider instanceof Platform) {
                 ((Platform) collider).platformCollision(this);
             } else if (collider instanceof PowerUp){
                ((PowerUp) collider).geefEffect(this.RONNY);
            }
        }
    }
    /**
     * Verwerking collision tussen Ronny en monster
     * @param collider monster
     */
    private void monsterCollision(Monster collider) {
        if (!RONNY.getInvincible()) {
            if (collider.isActive()) {
                RONNY.getHurt();
                collider.flash();
            }
        }
    }
}