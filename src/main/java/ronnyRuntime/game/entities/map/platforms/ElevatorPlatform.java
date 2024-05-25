package ronnyRuntime.game.entities.map.platforms;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;

/**
 * Standaard platform
 */
public class ElevatorPlatform extends Platform {

    private boolean isMoving = false;
    private boolean hasMoved = false;
    public ElevatorPlatform(Coordinate2D initialLocation, Size size) {
        super(initialLocation, size, "Objects/Tiles/elevator.png");
    }

    public void moveElevator() {
        setMoving(true);
        System.out.println("Elevator started");
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
}