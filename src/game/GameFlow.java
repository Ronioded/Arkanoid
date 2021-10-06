/* Roni Oded. ID-318798782. */
package game;

/* import classes from packages. */
import animations.AnimationRunner;
import animations.GameLevel;
import animations.KeyPressStoppableAnimation;
import animations.GameOver;
import animations.YouWin;
import animations.HighScoreAnimation;
import levels.LevelInformation;
import java.util.List;
import biuoop.KeyboardSensor;

/**
 * @author Roni Oded.
 * class GameFlow -support on moving from one level to another.
 */
public class GameFlow {

    /* declaring the fields in the class. */
    private AnimationRunner animationRunner;
    private KeyboardSensor keyboardSensor;
    private Counter score;

    /**
     * constructor in order to build instance of the class.
     * @param ar - the animation runner of the game.
     * @param ks - the keyboard sensor that recognize keys.
     */
    public GameFlow(AnimationRunner ar, KeyboardSensor ks) {

        /* initializing the fields. */
        this.score = new Counter();
        this.animationRunner = ar;
        this.keyboardSensor = ks;
    }

    /**
     * the method run the levels in the game.
     * @param levels - list of all the levels to run.
     */
    public void runLevels(List<LevelInformation> levels) {
        Boolean flag = true;
        GameLevel gameLevel = new GameLevel(levels.get(0), this.score, this.animationRunner, this.keyboardSensor);

        /* moving on the levels.*/
        for (LevelInformation levelInfo : levels) {

            /* level initialize. */
            GameLevel level = new GameLevel(levelInfo, this.score, this.animationRunner, this.keyboardSensor);
            gameLevel = level;
            level.initialize();

            /* while there is blocks and balls, the level is running. */
            while ((level.getBlockCounter().getValue() > 0) && (level.getBallsCounter().getValue() > 0)) {
                level.run();
            }

            /* add 100 points when there is no blocks. */
            if (level.getBlockCounter().getValue() <= 0) {
                this.score.increase(100);
            }

            /* if there is no balls, run the game over animation and finish the loop. */
            if (level.getBallsCounter().getValue() == 0) {
                this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY,
                        new GameOver(this.score, gameLevel)));
                flag = false;
                break;
            }
        }

        /* if flag is still true, the player done all levels so run the you win animation. */
        if (flag) {
            this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY,
                    new YouWin(this.score, gameLevel)));
        }

        /* update the high score and show the high score animation. */
        HighScoreFile.updateHighScore(this.score);
        this.animationRunner.run(new KeyPressStoppableAnimation(this.keyboardSensor, KeyboardSensor.SPACE_KEY,
                new HighScoreAnimation()));
    }
}

