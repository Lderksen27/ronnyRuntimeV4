package ronnyRuntime.game.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.input.MouseButton;
import ronnyRuntime.game.ronnyRuntimeApp;
import ronnyRuntime.game.scenes.ButtonBox;

/**
 * Knop die zorgt dat je terugkeert naar het startscherm.
 */
public class ReturnButton extends Button implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener{

    private final ronnyRuntimeApp APP;
    private final ButtonBox BUTTON_BOX;

    public ReturnButton(Coordinate2D initialLocation, ronnyRuntimeApp ronnyRuntimeApp, ButtonBox buttonBox) {
        super(initialLocation, "Terug");
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
     * Keert terug naar het startscherm.
     */
    @Override
    public void voerActieUit() {
        APP.setActiveScene(0);
    }
}