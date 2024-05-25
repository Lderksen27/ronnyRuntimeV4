package ronnyRuntime.game.entities.text;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Tekst die je als naam intypt in het highscorescherm.
 */
public class NameText extends TextEntity {

    public NameText(Coordinate2D initialLocation) {
        super(initialLocation);
        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.DARKBLUE);
    }

    public void setNameString (String string) {
        setText(string);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}