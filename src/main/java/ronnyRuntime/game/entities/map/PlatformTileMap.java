package ronnyRuntime.game.entities.map;

import com.github.hanyaeger.api.scenes.TileMap;
import ronnyRuntime.game.entities.map.platforms.ElevatorPlatform;
import ronnyRuntime.game.entities.map.platforms.RegularPlatform;
import ronnyRuntime.game.entities.map.platforms.BombPlatform;
import ronnyRuntime.game.entities.map.platforms.WaterPlatform;
import ronnyRuntime.game.entities.monsters.MovingMonster;
import ronnyRuntime.game.entities.monsters.StationaryMonster;
import ronnyRuntime.game.entities.powerUps.ExtraLife;
import ronnyRuntime.game.entities.powerUps.Invincible;
import ronnyRuntime.game.entities.powerUps.FastShooter;
import ronnyRuntime.game.scenes.GameLevel;

/**
 * Klasse waarin de entiteiten (platforms, monsters, coins, enz) worden gedefinieerd waarmee het level wordt gevuld.
 */
public class PlatformTileMap extends TileMap {

    private final GameLevel GAME_LEVEL;

    public PlatformTileMap (GameLevel gameLevel) {
        this.GAME_LEVEL = gameLevel;
    }

    @Override
    public void setupEntities() {
        addEntity(1, RegularPlatform.class, "Objects/Tiles/1.png");
        addEntity(2, RegularPlatform.class, "Objects/Tiles/2.png");
        addEntity(3, RegularPlatform.class, "Objects/Tiles/3.png");
        addEntity(4, RegularPlatform.class, "Objects/Tiles/4.png");
        addEntity(5, RegularPlatform.class, "Objects/Tiles/5.png");
        addEntity(6, RegularPlatform.class, "Objects/Tiles/6.png");
        addEntity(7, RegularPlatform.class, "Objects/Tiles/7.png");
        addEntity(8, RegularPlatform.class, "Objects/Tiles/8.png");
        addEntity(9, RegularPlatform.class, "Objects/Tiles/9.png");
        addEntity(10, RegularPlatform.class, "Objects/Tiles/10.png");
        addEntity(11, RegularPlatform.class, "Objects/Tiles/11.png");
        addEntity(12, RegularPlatform.class, "Objects/Tiles/12.png");
        addEntity(13, RegularPlatform.class, "Objects/Tiles/13.png");
        addEntity(14, RegularPlatform.class, "Objects/Tiles/14.png");
        addEntity(15, RegularPlatform.class, "Objects/Tiles/15.png");
        addEntity(16, RegularPlatform.class, "Objects/Tiles/16.png");
        addEntity(17, WaterPlatform.class, "Objects/Tiles/17.png");
        addEntity(19, Scenery.class, "Objects/Items/Stone.png");
        addEntity(20, Scenery.class, "Objects/Items/Bush (1).png");
        addEntity(21, RegularPlatform.class, "Objects/Items/Crate.png");
        addEntity(22, Scenery.class, "Objects/Items/Tree_2.png");
        addEntity(23, Scenery.class, "Objects/Items/Mushroom_2.png");
        addEntity(24, Coin.class);
        addEntity(25, StationaryMonster.class, GAME_LEVEL);
        addEntity(26, MovingMonster.class, GAME_LEVEL);
        addEntity(27, BombPlatform.class, "Objects/Tiles/2.png");
        addEntity(28, BombPlatform.class, "Objects/Tiles/14.png");
        addEntity(29, ExtraLife.class, "Objects/Items/health.png");
        addEntity(30, Invincible.class, "Objects/Items/invincible.png");
        addEntity(31, FastShooter.class, "Objects/Items/Mushroom_1.png");
        addEntity(32, ElevatorPlatform.class, GAME_LEVEL);
    }

    @Override
    public int[][] defineMap() {
        return switch (this.GAME_LEVEL.getLevel()) {
            case 1 -> TileMapLevel.LEVEL_ONE;
            case 2 -> TileMapLevel.LEVEL_TWO;
            case 3 -> TileMapLevel.LEVEL_THREE;
            default -> new int[0][];
        };
    }
}