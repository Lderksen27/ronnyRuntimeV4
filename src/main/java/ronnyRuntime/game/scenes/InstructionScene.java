package ronnyRuntime.game.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import ronnyRuntime.game.entities.buttons.Button;
import ronnyRuntime.game.entities.buttons.ReturnButton;
import ronnyRuntime.game.entities.text.Header;
import ronnyRuntime.game.entities.text.InstructionText;
import ronnyRuntime.game.ronnyRuntimeApp;

/**
 * Scherm met spelinstructies
 */
public class InstructionScene extends StaticScene {

    private final String[] INSTRUCTIONS = {
        "Verzamel zoveel mogelijk munten en wordt niet geraakt",
        "door de monsters! Bereik de tent om naar het volgende",
        "level te gaan!",
        "Pijltje links/rechts --> Beweeg links/rechts",
        "Pijltje omhoog --> Springen",
        "Space --> Schieten"
    };
    private final ronnyRuntimeApp APP;

    public InstructionScene(ronnyRuntimeApp ronnyRuntimeApp) {
        this.APP = ronnyRuntimeApp;
    }

    @Override
    public void setupScene() {
        setBackgroundAudio("audio/startEnEindScherm.mp3");
        setBackgroundAudioVolume(0.5);
        setBackgroundImage("background/startEnEindScherm/Cartoon_Forest_BG_04.png");
    }

    @Override
    public void setupEntities() {
        Coordinate2D headerLocation = new Coordinate2D( getWidth() / 2, getHeight() * 0.25);
        addEntity(new Header(headerLocation, "Instructies"));
        for (int i = 0; i < INSTRUCTIONS.length; i++) {
            addEntity(new InstructionText(new Coordinate2D(getWidth() / 2, (i * 40) + getHeight() * 0.4), INSTRUCTIONS[i]));
        }
        Coordinate2D secondButtonLocation = new Coordinate2D(getWidth() / 2, getHeight() * 0.75);
        ButtonBox bottomBox = new ButtonBox(secondButtonLocation);
        Button returnButton = new ReturnButton(secondButtonLocation, this.APP, bottomBox);
        bottomBox.setButton(returnButton);
        addEntity(bottomBox);
        addEntity(returnButton);
    }
}