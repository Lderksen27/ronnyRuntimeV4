package ronnyRuntime.game.entities.ronnyRuntime;

import java.util.TimerTask;

/**
 * Een timer die ervoor zorgt dat Ronny tijdelijk kan knipperen tussen zijn sprite en een ster.
 */
public class StarTask extends TimerTask {

    private final RonnyRuntime RONNY;

    boolean toggle = true;
    int count = 0;

    public StarTask(RonnyRuntime ronny) {
        this.RONNY = ronny;
    }

    @Override
    public void run() {
        toggle = !toggle;
        count++;
        Sprite sprite = RONNY.getSprite();
        if (toggle) {
            sprite.setCurrentFrameIndex(2);
        } else {
            if (sprite.getPointsRight()) {
                sprite.setCurrentFrameIndex(1);
            } else {
                sprite.setCurrentFrameIndex(0);
            }
        }
        if (count >= 40) {
            this.cancel();
            if (sprite.getPointsRight()) {
                sprite.setCurrentFrameIndex(1);
            } else {
                sprite.setCurrentFrameIndex(0);
            }
        }
    }
}