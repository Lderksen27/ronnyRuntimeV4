module ronnyRuntime {
    requires hanyaeger;

    exports ronnyRuntime.game;
    exports ronnyRuntime.game.entities.map;
    exports ronnyRuntime.game.entities.monsters;
    exports ronnyRuntime.game.spawners;
    exports ronnyRuntime.game.entities.powerUps;
    exports ronnyRuntime.game.entities.highscore;
    exports ronnyRuntime.game.entities.map.platforms;

    opens audio;
    opens background.lvl1;
    opens background.lvl2;
    opens background.lvl3;
    opens background.startEnEindScherm;
    opens Objects.Items;
    opens Objects.Tiles;
    opens sprites.ronnyRuntime;
    opens sprites.Coin;
    opens sprites.Monster1;
    opens sprites.Monster2;
    opens sprites.Monster3;
    opens sprites.Bullet;
    opens highscore;
}