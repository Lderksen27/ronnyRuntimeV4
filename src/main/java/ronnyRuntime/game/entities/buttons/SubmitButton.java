package ronnyRuntime.game.entities.buttons;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.input.MouseButton;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import ronnyRuntime.game.entities.highscore.Highscore;
import ronnyRuntime.game.entities.ronnyRuntime.RonnyRuntime;
import ronnyRuntime.game.ronnyRuntimeApp;
import ronnyRuntime.game.scenes.ButtonBox;
import ronnyRuntime.game.scenes.TypeNameScene;

/**
 * Knop die de naam voor de highscore bevestigt.
 */
public class SubmitButton extends Button implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener{

    private final ronnyRuntimeApp APP;
    private final ButtonBox BUTTON_BOX;
    private final TypeNameScene TYPE_NAME_SCENE;

    public SubmitButton(Coordinate2D initialLocation, ronnyRuntimeApp ronnyRuntimeApp, ButtonBox buttonBox, TypeNameScene typeNameScene) {
        super(initialLocation, "Submit!");
        setFont(Font.font("Roboto", FontWeight.BOLD, 45));
        this.APP = ronnyRuntimeApp;
        this.BUTTON_BOX = buttonBox;
        this.TYPE_NAME_SCENE = typeNameScene;
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
     * Schrijft mits er een naam ingegeven is de naam + punten weg naar de klasse Highscore
     */
    @Override
    public void voerActieUit() {
        String name = TYPE_NAME_SCENE.getString();
        int points = RonnyRuntime.getPoints();
        if (!name.isEmpty()) {
            Highscore highscore = new Highscore();
            highscore.setHighscore(name, points);
            APP.setActiveScene(4);
        }
    }
}