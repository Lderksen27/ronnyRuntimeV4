package ronnyRuntime.game.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.DynamicRectangleEntity;
import com.github.hanyaeger.api.entities.impl.RectangleEntity;
import javafx.scene.paint.Color;

public class DifficultyBackground extends RectangleEntity {
    public DifficultyBackground(Coordinate2D initialLocation) {
        super(initialLocation);
        setFill(Color.WHITE);
        setHeight(90);
        setWidth(200);
        setOpacity(0.65);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
    }
}
