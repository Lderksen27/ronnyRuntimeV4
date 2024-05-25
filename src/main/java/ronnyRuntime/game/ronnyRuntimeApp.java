package ronnyRuntime.game;

import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.YaegerGame;
import ronnyRuntime.game.scenes.*;

/**
 * De hoofdklasse van de applicatie
 */
public class ronnyRuntimeApp extends YaegerGame {

    public static void main(String[] args) {
        launch(args);
        System.out.println("Start!");
    }

    @Override
    public void setupGame() {
        setGameTitle("Ronny Runtime");
        setSize(new Size(1000, 800));
    }

    @Override
    public void setupScenes() {
        addScene(0, new ButtonScene(ButtonSceneType.START, this));
        addScene(1, new GameLevel(1, this));
        addScene(2, new GameLevel(2, this));
        addScene(3, new GameLevel(3, this));
        addScene(4, new ButtonScene(ButtonSceneType.END, this));
        addScene(5, new ButtonScene(ButtonSceneType.GAME_OVER, this));
        addScene(6, new TypeNameScene(this));
        addScene(7, new InstructionScene(this));
    }
}