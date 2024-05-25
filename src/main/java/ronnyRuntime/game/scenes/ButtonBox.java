package ronnyRuntime.game.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.paint.Color;
import ronnyRuntime.game.entities.buttons.Button;

/**
 * Witte chtergrond voor een knop op een statisch scherm.
 */
public class ButtonBox extends RectangleEntity implements MouseEnterListener, MouseExitListener {

    public Button button;

    protected ButtonBox(Coordinate2D initialLocation) {
        super(initialLocation);
        this.setFill(Color.WHITE);
        this.setHeight(90);
        this.setWidth(200);
        this.setOpacity(0.65);
        this.setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    @Override
    public void onMouseEntered() {
        toggleColor(true);
        if (this.button != null) {
            button.toggleTextColor(true);
        }
    }

    @Override
    public void onMouseExited() {
        toggleColor(false);
        if (this.button != null) {
            button.toggleTextColor(false);
        }
    }

    /**
     * Toggelt de achtergrond van een button wanneer de curus er boven hangt.
     * @param hover boolean-waarde hangt de cursor erboven?
     */
    public void toggleColor(boolean hover) {
        setFill(hover ? Color.DEEPPINK : Color.WHITE);
    }

    public void setButton (Button button) {
        this.button = button;
    }
}