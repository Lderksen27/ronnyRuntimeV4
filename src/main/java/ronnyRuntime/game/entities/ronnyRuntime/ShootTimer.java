package ronnyRuntime.game.entities.ronnyRuntime;

import java.util.TimerTask;

/**
 * Een timer die ervoor zorgt dat er tijd zit tussen schoten van Ronny.
 */
public class ShootTimer extends TimerTask {

    private final RonnyRuntime RONNY;

    public ShootTimer (RonnyRuntime ronny) {
        this.RONNY = ronny;
    }

    @Override
    public void run() {
        RONNY.setCanShoot(true);
    }
}