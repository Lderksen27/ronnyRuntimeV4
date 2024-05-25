package ronnyRuntime.game.scenes;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.EntitySpawnerContainer;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.scenes.DynamicScene;
import com.github.hanyaeger.api.scenes.TileMapContainer;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import ronnyRuntime.game.entities.map.PlatformTileMap;
import ronnyRuntime.game.entities.map.Tent;
import ronnyRuntime.game.entities.ronnyRuntime.RonnyRuntime;
import ronnyRuntime.game.entities.text.BulletText;
import ronnyRuntime.game.entities.text.LivesText;
import ronnyRuntime.game.entities.text.PointText;
import ronnyRuntime.game.ronnyRuntimeApp;
import ronnyRuntime.game.spawners.MonsterSpawner;

/**
 * Een level in het spel
 */
public class GameLevel extends DynamicScene implements TileMapContainer, EntitySpawnerContainer {

    private final int LEVEL;

    private final RonnyRuntime RONNY;
    private final ronnyRuntimeApp APP;

    public GameLevel(int level, ronnyRuntimeApp ronnyRuntimeApp) {
        this.LEVEL = level;
        this.RONNY = new RonnyRuntime(new Coordinate2D(50, 50), this);
        this.APP = ronnyRuntimeApp;
    }

    @Override
    public void setupScene() {
        switch (this.LEVEL) {
            case 1:
                setupBackground("audio/level1.mp3", 0.1,"background/lvl1/Cartoon_Forest_BG_01.png");
                break;
            case 2:
                setupBackground("audio/level2.mp3", 0.1, "background/lvl2/Cartoon_Forest_BG_02.png");
                break;
            case 3:
                setupBackground("audio/level3.mp3", 0.1, "background/lvl3/Cartoon_Forest_BG_03.png");
                break;
        }
    }

    @Override
    public void setupEntities() {
        addEntity(new Tent(new Coordinate2D(900, 680), this.APP, this.LEVEL, this.RONNY));
        addEntity(this.RONNY);
        PointText pointText = RONNY.getPointText();
        addEntity(pointText);
        LivesText livesText = RONNY.getLivesText();
        addEntity(livesText);
        BulletText bulletText = RONNY.getBulletText();
        addEntity(bulletText);
        String levelString = "Level:" + LEVEL;
        var levelText = new TextEntity(new Coordinate2D(50, 10), levelString);
        levelText.setAnchorLocation(new Coordinate2D(50, 10));
        levelText.setFont(Font.font("Roboto", FontWeight.NORMAL, 30));
        levelText.setFill(Color.DARKBLUE);
        addEntity(levelText);
    }

    @Override
    public void setupTileMaps() {
        PlatformTileMap tileMap = new PlatformTileMap(this);
        addTileMap(tileMap);
    }

    @Override
    public void setupEntitySpawners() {
        addEntitySpawner(new MonsterSpawner(this));
    }

    public ronnyRuntimeApp getRonnyRuntimeApp() {
        return this.APP;
    }

    public int getLevel() {
        return LEVEL;
    }

    public void setupBackground(String audioPath, double volumeAudio, String imagePath){
        setBackgroundAudio(audioPath);
        setBackgroundAudioVolume(volumeAudio);
        setBackgroundImage(imagePath);
    }
}