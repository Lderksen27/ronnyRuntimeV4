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
 * Knop die ervoor zorgt dat het spel start.
 */
public class StartButton extends Button implements MouseButtonPressedListener, MouseExitListener, MouseEnterListener{

    private final ronnyRuntimeApp APP;
    private final ButtonBox BUTTON_BOX;
    private final DifficultyButton DIFFICULTY;

    public StartButton(Coordinate2D initialLocation, ronnyRuntimeApp ronnyRuntimeApp, ButtonBox buttonBox, DifficultyButton difficulty) {
        super(initialLocation, "Start!");
        this.APP = ronnyRuntimeApp;
        this.BUTTON_BOX = buttonBox;
        this.DIFFICULTY = difficulty;
    }

    /**
     * Start eerste level
     */
    @Override
    public void voerActieUit() {
        RonnyRuntime.setDifficulty(DIFFICULTY.getDifficultyLevel());
        APP.setActiveScene(1);
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

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        voerActieUit();
    }
}