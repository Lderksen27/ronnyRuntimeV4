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
    private final DifficultyBackground difficultyBackground;
    public DifficultyButton(Coordinate2D initialLocation, DifficultyBackground difficultyBackground) {
        super(initialLocation, "EASY");
        this.difficultyLevel = DifficultyLevel.EASY;
        this.difficultyBackground = difficultyBackground;
        setAnchorPoint(AnchorPoint.CENTER_CENTER);
        setFill(Color.HOTPINK);
        setFont(Font.font("Roboto", FontWeight.BOLD, 60));

    }

    public void setDifficultyLevel(DifficultyLevel difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
        setText(difficultyLevel.toString());
    }

    public DifficultyLevel getDifficultyLevel() {
        return this.difficultyLevel;
    }

    @Override
    public void onMouseButtonPressed(MouseButton mouseButton, Coordinate2D coordinate2D) {
        DifficultyLevel nextDifficulty = newDifficulty();
        switch (nextDifficulty) {
            case DifficultyLevel.EASY:
                setFill(Color.HOTPINK);
                difficultyBackground.setBackGroundColor(Color.WHITE);
                break;
            case DifficultyLevel.OKAY:
                setFill(Color.ORANGERED);
                difficultyBackground.setBackGroundColor(Color.YELLOW);
                break;
            case DifficultyLevel.HARD:
                difficultyBackground.setBackGroundColor(Color.ORANGE);
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
