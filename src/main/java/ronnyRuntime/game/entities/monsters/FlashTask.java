package ronnyRuntime.game.entities.monsters;

import java.util.TimerTask;

/**
 * Timer die ervoor zorgt dat een monster tijdelijk gaat knipperen nadat Ronny hem geraakt heeft.
 */
public class FlashTask extends TimerTask {

    private final Monster MONSTER;

    boolean toggle = true;
    int count = 0;

    public FlashTask (Monster monster) {
        this.MONSTER = monster;
    }

    @Override
    public void run() {
        toggle = !toggle;
        count++;
        MONSTER.changeBrightness(toggle);
        if (count >= 8) {
            this.cancel();
            MONSTER.changeBrightness(false);
            MONSTER.setActive(true);
        }
    }
}