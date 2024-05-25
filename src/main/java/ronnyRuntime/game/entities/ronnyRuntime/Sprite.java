package ronnyRuntime.game.entities.ronnyRuntime;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import java.util.Set;

/**
 * De sprite van Ronny
 */
public class Sprite extends SpriteEntity implements KeyListener {

    private boolean pointsRight = true;

    private final RonnyRuntime RONNY;

    public Sprite(Coordinate2D location, RonnyRuntime ronny){
        super("sprites/ronnyRuntime/ronnyRuntime.png", location, new Size(50,50), 1,3);
        this.RONNY = ronny;
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> pressedKeys) {
        boolean isInvincible = this.RONNY.getInvincible();
        if (pressedKeys.contains(KeyCode.LEFT)) {
            if(!isInvincible) {
                setCurrentFrameIndex(0);
            }
            pointsRight = false;
        } else if (pressedKeys.contains(KeyCode.RIGHT)) {
            if(!isInvincible) {
                setCurrentFrameIndex(1);
            }
            pointsRight = true;
        }
    }

    public boolean getPointsRight () {
        return pointsRight;
    }
}