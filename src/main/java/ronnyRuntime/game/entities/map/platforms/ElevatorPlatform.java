package ronnyRuntime.game.entities.map.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Direction;
import ronnyRuntime.game.entities.ronnyRuntime.RonnyRuntime;
import ronnyRuntime.game.scenes.GameLevel;
import ronnyRuntime.game.spawners.PlatformSpawner;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Standaard platform
 */
public class ElevatorPlatform extends Platform {

    private boolean isMoving = false;
    private boolean hasMoved = false;
    private GameLevel LEVEL;
    private Coordinate2D location;
    public ElevatorPlatform(Coordinate2D initialLocation, Size size, GameLevel LEVEL) {
        super(initialLocation, size, "Objects/Tiles/elevator.png");
        this.location = initialLocation;
        this.LEVEL = LEVEL;
    }

    public void moveElevator(RonnyRuntime ronny) {
        setMoving(true);
        setMotion(2, Direction.UP);
        ronny.setMovingOnElevator(true);
        ronny.setVisible(false);
        ElevatorTask elevatorTask = new ElevatorTask(ronny, LEVEL, this);
        Timer elevatorTimer = new Timer();
        elevatorTimer.schedule(elevatorTask, 1000);
    }

    public boolean isMoving() {
        return isMoving;
    }

    public void setMoving(boolean moving) {
        isMoving = moving;
    }

    public boolean isHasMoved() {
        return hasMoved;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public class ElevatorTask extends TimerTask {

        private final RonnyRuntime ronnyRuntime;
        private final GameLevel gameLevel;
        private final ElevatorPlatform elevatorPlatform;

        public ElevatorTask(RonnyRuntime ronnyRuntime, GameLevel gameLevel, ElevatorPlatform elevatorPlatform) {
            this.ronnyRuntime = ronnyRuntime;
            this.gameLevel = gameLevel;
            this.elevatorPlatform = elevatorPlatform;
        }
        @Override
        public void run() {
            setMoving(false);
            setHasMoved(true);
            setMotion(0, Direction.UP);
            Coordinate2D platformLocation = getAnchorLocation();
            double x = platformLocation.getX();
            double y = platformLocation.getY();
            double height = getHeight();
            Coordinate2D newRonnyLocation = new Coordinate2D(x, y - height - 15);
            ronnyRuntime.setAnchorLocation(newRonnyLocation);
            ronnyRuntime.setVisible(true);
            ronnyRuntime.setMovingOnElevator(false);
            Coordinate2D elevatorLocation = elevatorPlatform.getAnchorLocation();
            Size elevatorSize = new Size(getWidth(), getHeight());
            PlatformSpawner platformSpawner = new PlatformSpawner(elevatorLocation, elevatorSize);
            this.elevatorPlatform.remove();
            this.gameLevel.addEntitySpawner(platformSpawner);
        }
    }
}