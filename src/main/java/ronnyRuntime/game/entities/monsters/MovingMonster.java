package ronnyRuntime.game.entities.monsters;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.Direction;
import com.github.hanyaeger.api.entities.impl.DynamicSpriteEntity;
import ronnyRuntime.game.scenes.GameLevel;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Monster beweegt heen en weer.
 */
public class MovingMonster extends Monster {

    public MovingMonster(Coordinate2D initialLocation, Size size, GameLevel gameLevel) {
        super("sprites/Monster2/monster2.png", new Coordinate2D(initialLocation.getX() -22, initialLocation.getY() + 14), gameLevel);
        setCurrentFrameIndex(0);
        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new MonsterMoveTask(), 500, 750);
    }

    public class MonsterMoveTask extends TimerTask {
        boolean moveRight = true;
        @Override
        public void run() {
            moveRight = !moveRight;
            if (moveRight) {
                setMotion(2, Direction.RIGHT);
                setCurrentFrameIndex(1);
            } else {
                setMotion(2, Direction.LEFT);
                setCurrentFrameIndex(0);
            }
        }
    }
}