package ronnyRuntime.game.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.scenes.StaticScene;
import ronnyRuntime.game.entities.buttons.*;
import ronnyRuntime.game.entities.highscore.Highscore;
import ronnyRuntime.game.entities.text.Header;
import ronnyRuntime.game.entities.text.HighscoreText;
import ronnyRuntime.game.ronnyRuntimeApp;

/**
 * Statisch scherm met header en knoppen
 */
public class ButtonScene extends StaticScene {

    private final ButtonSceneType type;
    private final ronnyRuntimeApp ronnyRuntimeApp;

    public ButtonScene (ButtonSceneType type, ronnyRuntimeApp ronnyRuntimeApp) {
        this.type = type;
        this.ronnyRuntimeApp = ronnyRuntimeApp;
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
        Coordinate2D firstButtonLocation = new Coordinate2D( getWidth() / 2, getHeight() * 0.5);
        Coordinate2D secondButtonLocation = new Coordinate2D(getWidth() / 2, getHeight() * 0.75);
        ButtonBox topBox = new ButtonBox(firstButtonLocation);
        ButtonBox bottomBox = new ButtonBox(secondButtonLocation);
        Button quitButton = new QuitButton(secondButtonLocation, this.ronnyRuntimeApp, bottomBox);
        bottomBox.setButton(quitButton);
        addEntity(bottomBox);
        addEntity(quitButton);
        Highscore currentHighscore = new Highscore();
        HighscoreText newHighScoreText = new HighscoreText(new Coordinate2D(getWidth() / 2, getHeight() * 0.9));
        newHighScoreText.setHighscoreText(currentHighscore);
        addEntity(newHighScoreText);
        switch (this.type) {
            case ButtonSceneType.START:
                addEntity(new Header(headerLocation, "Ronny Runtime"));
                Button startButton = new StartButton(firstButtonLocation, this.ronnyRuntimeApp, topBox);
                topBox.setButton(startButton);
                addEntity(topBox);
                addEntity(startButton);
                InstructionButton instructionButton = new InstructionButton(new Coordinate2D(getWidth() * 0.8, 50), this.ronnyRuntimeApp);
                addEntity(instructionButton);
                Coordinate2D difficultyLoc = new Coordinate2D(getWidth() * 0.8, getHeight() * 0.5);
                DifficultyBackground difficultyBackground = new DifficultyBackground(difficultyLoc);
                addEntity(difficultyBackground);
                DifficultyButton difficultyButton = new DifficultyButton(difficultyLoc);
                addEntity(difficultyButton);
                break;
            case ButtonSceneType.GAME_OVER:
                addEntity(new Header(headerLocation, "Game Over"));
                Button againButtonGameOver = new PlayAgainButton(firstButtonLocation, this.ronnyRuntimeApp, topBox);
                topBox.setButton(againButtonGameOver);
                addEntity(topBox);
                addEntity(againButtonGameOver);
                break;
            case ButtonSceneType.END:
                addEntity(new Header(headerLocation, "Congratulations"));
                Button againButtonEnd = new PlayAgainButton(firstButtonLocation, this.ronnyRuntimeApp, topBox);
                topBox.setButton(againButtonEnd);
                addEntity(topBox);
                addEntity(againButtonEnd);
                break;
        }
    }
}