package ronnyRuntime.game.entities.ronnyRuntime;

import java.util.TimerTask;


public class ShootFastTask extends TimerTask {

    private final RonnyRuntime RONNY;

    public ShootFastTask(RonnyRuntime ronny) {
        this.RONNY = ronny;
    }

    @Override
    public void run() {
        RONNY.setShootFast(false);
    }
}