package ronnyRuntime.game.entities.text;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Tekst voor een instructieregel.
 */
public class InstructionText extends TextEntity {

    public InstructionText(Coordinate2D initialLocation, String instructie) {
        super(initialLocation);
        setText(instructie);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        setFill(Color.DEEPPINK);
        setStrokeColor(Color.WHITE);
        setStrokeWidth(1);
    }
}