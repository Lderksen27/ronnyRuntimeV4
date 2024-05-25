package ronnyRuntime.game.scenes;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import com.github.hanyaeger.api.userinput.KeyListener;
import javafx.scene.input.KeyCode;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import java.util.Set;
import ronnyRuntime.game.entities.buttons.Button;
import ronnyRuntime.game.entities.buttons.SubmitButton;
import ronnyRuntime.game.entities.text.Header;
import ronnyRuntime.game.entities.text.NameText;
import ronnyRuntime.game.ronnyRuntimeApp;

/**
 * Scherm waar je je naam in moet typen voor een highscore
 */
public class TypeNameScene extends StaticScene implements KeyListener {

    private String string = "";

    private final NameText NAME_TEXT;
    private final ronnyRuntimeApp APP;

    private KeyCode currentKeyCode;

    public TypeNameScene (ronnyRuntimeApp ronnyRuntimeApp) {
        this.NAME_TEXT = new NameText(new Coordinate2D(0, 0));
        this.APP = ronnyRuntimeApp;
        NAME_TEXT.setNameString(string);
    }

    @Override
    public void setupScene() {
        setBackgroundImage("background/startEnEindScherm/Cartoon_Forest_BG_04.png");
    }

    @Override
    public void setupEntities() {
        Header firstHeader = new Header(new Coordinate2D(getWidth() /2, getHeight() * 0.2), "New Highscore!");
        firstHeader.setFont(Font.font("Roboto", FontWeight.BOLD, 80));
        firstHeader.setFill(Color.DEEPPINK);
        firstHeader.setStrokeWidth(2);
        addEntity(firstHeader);
        Header secondHeader = new Header(new Coordinate2D(getWidth() /2, getHeight() * 0.4), "Enter your name!");
        secondHeader.setFont(Font.font("Roboto", FontWeight.BOLD, 80));
        secondHeader.setFill(Color.DEEPPINK);
        secondHeader.setStrokeWidth(2);
        addEntity(secondHeader);
        this.NAME_TEXT.setFill(Color.DEEPPINK);
        this.NAME_TEXT.setStrokeColor(Color.WHITE);
        this.NAME_TEXT.setStrokeWidth(2);
        this.NAME_TEXT.setFont(Font.font("Roboto", FontWeight.BOLD, 60));
        this.NAME_TEXT.setAnchorPoint(AnchorPoint.CENTER_CENTER);
        this.NAME_TEXT.setAnchorLocation(new Coordinate2D(getWidth() / 2, getHeight() * 0.6));
        addEntity(NAME_TEXT);
        Coordinate2D submitButtonLocation = new Coordinate2D(getWidth() / 2, getHeight() * 0.8);
        ButtonBox submitBox = new ButtonBox(submitButtonLocation);
        Button submitButton = new SubmitButton(submitButtonLocation, this.APP, submitBox, this);
        addEntity(submitBox);
        addEntity(submitButton);
    }

    @Override
    public void onPressedKeysChange(Set<KeyCode> set) {
        if (set.size() == 1) {
            for (KeyCode keyCode : set) {
                setCurrentKeyCode(keyCode);
            }
        } else if (set.isEmpty()) {
            KeyCode current = getCurrentKeyCode();
            if (current == KeyCode.BACK_SPACE && !this.string.isEmpty()) {
                this.string = this.string.substring(0,this.string.length() - 1);
            } else if (this.string.length() <= 10 && current != KeyCode.BACK_SPACE) {
                this.string = this.string + getCurrentKeyCode().getChar();
            }
            NAME_TEXT.setNameString(this.string);
        }
    }

    public KeyCode getCurrentKeyCode() {
        return currentKeyCode;
    }

    public String getString () {
        return this.string;
    }

    public void setCurrentKeyCode(KeyCode newKeyCode) {
        this.currentKeyCode = newKeyCode;
    }
}