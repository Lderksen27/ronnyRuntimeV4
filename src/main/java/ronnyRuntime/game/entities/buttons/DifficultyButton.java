package ronnyRuntime.game.entities.buttons;

import com.github.hanyaeger.api.AnchorPoint;
import com.github.hanyaeger.api.Coordinate2D;
import com.github.hanyaeger.api.entities.impl.TextEntity;
import com.github.hanyaeger.api.userinput.MouseButtonPressedListener;
import javafx.scene.input.MouseButton;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;

public class DifficultyButton extends TextEntity implements MouseButtonPressedListener {

    private DifficultyLevel difficultyLevel;
    public DifficultyButton(Coordinate2D initialLocation) {
        super(initialLocation, "EASY");
        this.difficultyLevel = DifficultyLevel.EASY;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(Color.HOTPINK);
        setFont(Font.font("Roboto", FontWeight.BOLD, 30));

    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
        setText(difficultyLevel.toString());
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        DifficultyLevel nextDifficulty = newDifficulty();
        switch (nextDifficulty) {
            case DifficultyLevel.EASY:
                setFill(Color.HOTPINK);
                break;
            case DifficultyLevel.OKAY:
                setFill(Color.ORANGERED);
                break;
            case DifficultyLevel.HARD:
                setFill(Color.DARKRED);
                break;
            default:
                setFill(Color.BLUE);
        }
        setDifficultyLevel(newDifficulty());
    }

    public DifficultyLevel newDifficulty() {
        if (this.difficultyLevel == DifficultyLevel.EASY) {
            return DifficultyLevel.OKAY;
        } else if (this.difficultyLevel == DifficultyLevel.OKAY) {
            return DifficultyLevel.HARD;
        } else {
            return DifficultyLevel.EASY;
        }
    }
}
