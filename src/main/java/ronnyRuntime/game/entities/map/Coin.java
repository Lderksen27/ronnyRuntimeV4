package ronnyRuntime.game.entities.map;

import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.Size;
import com.github.hanyaeger.api.entities.Collider;
import com.github.hanyaeger.api.entities.impl.SpriteEntity;
import com.github.hanyaeger.api.media.SoundClip;
import ronnyRuntime.game.entities.powerUps.PowerUp;
import ronnyRuntime.game.entities.ronnyRuntime.RonnyRuntime;

/**
 * Een munt, waarmee je punten kunt behalen.
 */
public class Coin extends SpriteEntity implements Collider, PowerUp {

    public Coin(Coordinate2D initialLocation, Size size) {
        super("sprites/coin/Silver_21.png", initialLocation, size);
    }

    @Override
    public void geefEffect(RonnyRuntime ronny) {
        final SoundClip COIN = new SoundClip("audio/coin.mp3");
        COIN.setVolume(0.5);
        COIN.play();
        ronny.collectCoin();
        remove();
    }
}