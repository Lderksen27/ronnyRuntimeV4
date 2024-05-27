package ronnyRuntime.game.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

/**
 * Achtergrond voor de moeilijkheidsinstelling op het startscherm. Verandert
 * van kleur bij het toggelen.
 */
public class DifficultyBackground extends RectangleEntity {
    public DifficultyBackground(Coordinate2D initialLocation) {
        super(initialLocation);
        setFill(Color.WHITE);
        setHeight(90);
        setWidth(200);
        setOpacity(0.65);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }

    public void setBackGroundColor(Color color) {
        setFill(color);
    }
}
