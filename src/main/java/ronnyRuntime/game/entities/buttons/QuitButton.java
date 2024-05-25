package ronnyRuntime.game.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.input.MouseButton;
import ronnyRuntime.game.ronnyRuntimeApp;
import ronnyRuntime.game.scenes.ButtonBox;

/**
 * Knop die het spel sluit
 */
public class QuitButton extends Button implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener{

    private final ronnyRuntimeApp APP;
    private final ButtonBox BUTTON_BOX;

    public QuitButton(Coordinate2D initialLocation, ronnyRuntimeApp ronnyRuntimeApp, ButtonBox buttonBox) {
        super(initialLocation, "Quit!");
        this.APP = ronnyRuntimeApp;
        this.BUTTON_BOX = buttonBox;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        voerActieUit();
    }

    @Override
    public void onMouseEntered() {
        BUTTON_BOX.toggleColor(true);
        toggleTextColor(true);
    }

    @Override
    public void onMouseExited() {
        BUTTON_BOX.toggleColor(false);
        toggleTextColor(false);
    }

    /**
     * Sluit de applicatie af.
     */
    @Override
    public void voerActieUit() {
        APP.quit();
    }
}