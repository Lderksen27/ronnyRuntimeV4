package ronnyRuntime.game.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.input.MouseButton;
import ronnyRuntime.game.entities.ronnyRuntime.RonnyRuntime;
import ronnyRuntime.game.ronnyRuntimeApp;
import ronnyRuntime.game.scenes.ButtonBox;

/**
 * Knop die ervoor zorgt dat het spel opnieuw begint.
 */
public class PlayAgainButton extends Button implements MouseButtonPressedListener, MouseExitListener, MouseEnterListener{

    private final ronnyRuntimeApp APP;
    private final ButtonBox BUTTON_BOX;

    public PlayAgainButton(Coordinate2D initialLocation, ronnyRuntimeApp ronnyRuntimeApp, ButtonBox buttonBox) {
        super(initialLocation, "Again!");
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
     * Prepareert Ronny voor een nieuw spel en start
     * opnieuw het eerst level.
     */
    @Override
    public void voerActieUit() {
        RonnyRuntime.resetRonny();
        APP.setupScenes();
        APP.setActiveScene(1);
    }
}