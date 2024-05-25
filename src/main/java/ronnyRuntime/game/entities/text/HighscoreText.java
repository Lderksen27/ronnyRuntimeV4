package ronnyRuntime.game.entities.text;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import ronnyRuntime.game.entities.highscore.Highscore;

/**
 * Text die de highscore toont.
 */
public class HighscoreText extends TextEntity {

    public HighscoreText(Coordinate2D initialLocation) {
        super(initialLocation);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(Color.WHITE);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));
        setStrokeColor(Color.DEEPPINK);
        setStrokeWidth(1);
    }

    public void setHighscoreText (Highscore highscore) {
        setText("Current highscore: " + highscore.getHighscoreName() + " with " + highscore.getHighscorePoints() + " points!");
    }
}