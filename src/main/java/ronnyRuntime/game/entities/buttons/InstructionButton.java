package ronnyRuntime.game.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import com.github.hanyaeger.api.userinput.MouseEnterListener;
import com.github.hanyaeger.api.userinput.MouseExitListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import ronnyRuntime.game.ronnyRuntimeApp;

/**
 * Knop, waarbij je naar het instructiescherm gaat wanneer je erop drukt.
 */
public class InstructionButton extends Button implements MouseButtonPressedListener, MouseEnterListener, MouseExitListener {

    private final ronnyRuntimeApp APP;

    public InstructionButton(Coordinate2D initialLocation, ronnyRuntimeApp ronnyRuntimeApp) {
        super(initialLocation, "Instructies");
        this.APP = ronnyRuntimeApp;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(Color.DEEPPINK);
        setFont(Font.font("Roboto", FontWeight.NORMAL, 40));
        setStrokeColor(Color.WHITE);
        setStrokeWidth(1);
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        voerActieUit();
    }

    @Override
    public void onMouseEntered() {
        toggleTextColor(true);
    }

    @Override
    public void onMouseExited() {
        toggleTextColor(false);
    }

    /**
     * Start de scene met het instructiescherm
     */
    @Override
    public void voerActieUit() {
        APP.setActiveScene(7);
    }
}