package ronnyRuntime.game.entities.map;

/**
 * Klasse met data in 2-dimensionale arrays over de inrichting van de gamelevels.
 */
public final class TileMapLevel {

    public static final int[][] LEVEL_ONE = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 24, 24, 0, 0, 26, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 24, 0, 0, 0, 30, 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 22, 0, 1, 2, 2, 2, 2, 2, 3, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 13, 15, 0, 12, 9, 9, 9, 9, 9, 16, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 13, 14, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 23, 25, 0, 0, 0, 0, 0, 0, 0, 13, 14, 15, 0, 0, 0, 0},
            { 0, 0, 0, 0, 13, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 14, 15, 0},
            { 0, 13, 28, 15, 0, 0, 0, 0, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 23, 0, 22, 31, 0, 13, 14, 15, 0, 0, 26, 24, 0},
            { 0, 0, 0, 0, 0, 13, 14, 15, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 24, 0, 0, 0, 0, 0, 0, 0, 4, 6, 0, 0, 0, 1, 2, 2, 2, 2, 2},
            { 0, 13, 14, 15, 0, 0, 0, 0, 0, 4, 6, 0, 0, 0, 12, 9, 9, 9, 9, 9},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 21, 0, 23, 0, 0, 4, 6, 0, 0, 0, 0, 29, 0, 24, 0, 0},
            { 0, 0, 24, 0, 13, 14, 15, 0, 0, 4, 6, 0, 0, 0, 13, 15, 0, 0, 0, 0},
            { 25, 19, 20, 0, 0, 0, 0, 0, 0, 4, 6, 24, 0, 21, 0, 0, 0, 0, 0, 0},
            { 2, 27, 2, 3, 17, 17, 17, 1, 7, 8, 10, 11, 2, 3, 17, 17, 17, 1, 2, 2}
    };

    public static final int[][] LEVEL_TWO = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 26, 24, 24, 4, 6, 0, 0, 0, 0, 0, 0},
            { 0, 0, 24, 21, 0, 0, 0, 0, 20, 0, 0, 30, 4, 6, 0, 0, 0, 0, 24, 0},
            { 0, 0, 21, 21, 0, 0, 1, 2, 2, 2, 2, 7, 8, 6, 0, 0, 0, 0, 25, 19},
            { 0, 21, 21, 21, 0, 0, 12, 9, 9, 9, 9, 9, 9, 16, 0, 0, 0, 13, 14, 14},
            { 14, 14, 14, 14, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 23, 0, 0, 0},
            { 0, 0, 0, 0, 0, 13, 15, 0, 0, 24, 0, 24, 26, 24, 0, 1, 3, 0, 0, 24},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 6, 0, 22, 25},
            { 0, 0, 0, 0, 0, 0, 0, 0, 13, 14, 14, 14, 14, 15, 0, 4, 6, 0, 1, 2},
            { 0, 0, 0, 24, 0, 25, 20, 0, 0, 0, 0, 0, 0, 0, 0, 4, 6, 0, 12, 9},
            { 24, 0, 0, 0, 13, 14, 15, 0, 0, 0, 0, 0, 0, 0, 0, 4, 6, 0, 0, 0},
            { 0, 20, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 6, 29, 0, 0},
            { 13, 14, 15, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 5, 11, 3, 0},
            { 0, 0, 0, 0, 0, 23, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 5, 9, 16, 0},
            { 0, 24, 0, 0, 0, 13, 15, 0, 0, 0, 0, 0, 0, 0, 0, 4, 6, 0, 0, 0},
            { 19, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 4, 6, 0, 0, 24},
            { 14, 14, 15, 0, 0, 0, 25, 20, 0, 0, 0, 0, 0, 24, 0, 4, 6, 0, 0, 24},
            { 0, 0, 0, 0, 0, 13, 14, 15, 0, 0, 21, 0, 0, 24, 0, 4, 6, 0, 0, 0},
            { 0, 25, 22, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 21, 31, 4, 6, 0, 0, 0},
            { 2, 2, 2, 2, 17, 17, 17, 17, 17, 17, 17, 17, 1, 2, 7, 8, 10, 11, 2, 2}
    };

    public static final int[][] LEVEL_THREE = {
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 26, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            { 24, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 21, 24, 21, 24, 21, 0, 0, 0},
            { 24, 24, 0, 0, 26, 0, 0, 0, 13, 14, 14, 14, 14, 14, 14, 14, 14, 15, 0, 24},
            { 0, 0, 0, 0, 0, 0, 0, 21, 0, 0, 0, 0, 0, 0, 0, 0, 0, 21, 0, 24},
            { 14, 14, 14, 14, 14, 15, 0, 0, 24, 0, 0, 0, 0, 0, 0, 0, 0, 21, 0, 24},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 21, 0, 24},
            { 0, 0, 0, 0, 0, 0, 13, 14, 14, 14, 14, 15, 0, 0, 0, 0, 0, 21, 0, 24},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 30, 0, 0, 0, 0, 21, 0, 24},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 15, 0, 0, 0, 0, 21, 0, 24},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 13, 14, 15, 0, 24},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 24},
            { 0, 24, 24, 0, 0, 0, 24, 0, 0, 13, 14, 14, 14, 15, 0, 0, 0, 0, 0, 29},
            { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 25, 0, 0},
            { 0, 0, 25, 0, 0, 0, 1, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 21, 0, 0},
            { 2, 2, 2, 15, 0, 0, 4, 6, 0, 0, 0, 0, 0, 0, 0, 0, 0, 21, 0, 0},
            { 9, 9, 16, 0, 0, 0, 4, 6, 21, 0, 0, 0, 0, 0, 0, 0, 0, 21, 0, 0},
            { 0, 0, 0, 0, 0, 21, 4, 6, 21, 21, 25, 0, 0, 0, 0, 0, 0, 21, 0, 0},
            { 0, 0, 31, 0, 1, 7, 8, 10, 11, 2, 2, 3, 24, 24, 0, 0, 0, 21, 0, 0},
            { 2, 2, 2, 7, 8, 5, 5, 5, 5, 5, 5, 5, 11, 3, 17, 17, 17, 1, 2, 2}
    };
}