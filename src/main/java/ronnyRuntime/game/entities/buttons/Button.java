package ronnyRuntime.game.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

/**
 * Knop, waarbij iets gebeurt wanneer je erop drukt.
 */
public abstract class Button extends TextEntity  {

    public Button(Coordinate2D initialLocation, String text) {
        super(initialLocation, text);
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(Color.DEEPPINK);
        setFont(Font.font("Roboto", FontWeight.BOLD, 60));
    }

    /**
     * Voert de actie uit behorende bij de knop die deze
     * interface implementeert.
     */
    public abstract void voerActieUit() ;

    /**
     * Toggelt de kleur van de tekst van de knop tussen
     * wit en roze, afhankelijk van of de muiscursor
     * over de button hovert.
     * @param hover boolean waarde die aangeeft of de muiscursor boven de button hangt.
     */
    public void toggleTextColor(boolean hover) {
        setFill(hover ? Color.WHITE : Color.DEEPPINK);
    }
}