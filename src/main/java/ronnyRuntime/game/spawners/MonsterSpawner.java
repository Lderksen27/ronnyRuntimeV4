package ronnyRuntime.game.spawners;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.EntitySpawner;
import ronnyRuntime.game.entities.buttons.DifficultyLevel;
import ronnyRuntime.game.entities.monsters.FallingMonster;
import ronnyRuntime.game.entities.ronnyRuntime.RonnyRuntime;
import ronnyRuntime.game.scenes.GameLevel;

import java.util.Random;

/**
 * Spawners voor Falling Monsters
 */
public class MonsterSpawner extends EntitySpawner {

    private final GameLevel GAME_LEVEL;


    public MonsterSpawner(GameLevel gameLevel) {
        super(3000);
        this.GAME_LEVEL = gameLevel;
    }

    @Override
    protected void spawnEntities() {
        DifficultyLevel difficultyLevel = RonnyRuntime.getDifficulty();
        int speed;
        switch (difficultyLevel) {
            case EASY:
                setIntervalInMs(5000);
                speed = 2;
                break;
            case OKAY:
                setIntervalInMs(3000);
                speed = 4;
                break;
            case HARD:
                setIntervalInMs(1000);
                speed = 6;
                break;
            default:
                speed = 2;
        }
        Coordinate2D location = randomLocation();
        spawn(new FallingMonster(location, GAME_LEVEL, speed));
    }

    /**
     * Geeft een random locatie terug, ergens bovenin het scherm.
     * @return locatie
     */
    private Coordinate2D randomLocation () {
        double x = new Random().nextInt((int) this.GAME_LEVEL.getWidth());
        return (new Coordinate2D(x, 100));
    }
}