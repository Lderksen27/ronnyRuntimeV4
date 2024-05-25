package ronnyRuntime.game.entities.text;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Een headertext voor een statische scene.
 */
public class Header extends TextEntity {

    public Header(Coordinate2D initialLocation, String text) {
        super(initialLocation, text);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(Color.DEEPPINK);
        setFont(Font.font("Roboto", FontWeight.BOLD, 120));
        setStrokeColor(Color.LIGHTPINK);
        setStrokeWidth(5);
    }
}