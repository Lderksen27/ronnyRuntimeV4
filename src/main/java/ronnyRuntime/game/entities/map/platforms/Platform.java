package ronnyRuntime.game.entities.map.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import ronnyRuntime.game.entities.Orientation;
import ronnyRuntime.game.entities.ronnyRuntime.HitBox;
import ronnyRuntime.game.entities.ronnyRuntime.RonnyRuntime;

public class Platform extends SpriteEntity implements Collider {

    public Platform(Coordinate2D initialLocation, Size size, String resource) {
        super(resource, initialLocation, size);
    }

    public void platformCollision(HitBox hitBox){
        RonnyRuntime ronny = hitBox.getRonny();
        Coordinate2D currentLocation;
        switch (hitBox.getOrientation()) {
            case Orientation.BOTTOM:
                if (!ronny.getTouchdown()) {
                    ronny.setMotion(0, Direction.UP);
                    currentLocation = ronny.getAnchorLocation();
                    ronny.setAnchorLocationY(currentLocation.getY() - 1);
                    ronny.setTouchdown(true);
                    ronny.setJumping(false);
                } else {
                    ronny.setSpeed(0);
                }
                break;
            case Orientation.TOP:
                ronny.setMotion(0, Direction.DOWN);
                currentLocation = ronny.getAnchorLocation();
                ronny.setAnchorLocationY(currentLocation.getY() + 1);

                break;
            case Orientation.LEFT:

                ronny.addToMotion(2, Direction.RIGHT);
                currentLocation = ronny.getAnchorLocation();
                ronny.setAnchorLocationX(currentLocation.getX() + 1);

                break;
            case Orientation.RIGHT:

                ronny.addToMotion(2, Direction.LEFT);
                currentLocation = ronny.getAnchorLocation();
                ronny.setAnchorLocationX(currentLocation.getX() - 1);

                break;
            default:
                ronny.setSpeed(0);
        }
        if (this instanceof BombPlatform) {
            destroyBombPlatform();
        }
    }

    private void destroyBombPlatform() {
        final SoundClip GROUND_BROKEN = new SoundClip("audio/groundBroken.mp3");
        GROUND_BROKEN.play();
        remove();
    }
}
