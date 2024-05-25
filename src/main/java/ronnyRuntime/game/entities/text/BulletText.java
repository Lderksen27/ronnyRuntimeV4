package ronnyRuntime.game.entities.text;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Tekst die toont hoeveel levens hij nog heeft.
 */
public class BulletText extends TextEntity {

    public BulletText(Coordinate2D initialLocation) {
        super(initialLocation);
        setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        setFill(Color.DARKBLUE);
    }

    public void setBulletText (int lives) {
        setText("Bullets: " + lives);
    }
}