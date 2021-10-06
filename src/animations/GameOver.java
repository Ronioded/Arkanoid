/* Roni Oded. ID-318798782. */
package animations;

/* import classes from packages. */
import biuoop.DrawSurface;
import game.Counter;
import java.awt.Color;

/**
 * @author Roni Oded.
 * class GameOver- display the end screen animation of the game if the player lose.
 * implements Animation.
 */
public class GameOver implements Animation {

    /* field of an instance of the class. */
    private Counter score;
    private GameLevel gameLevel;

    /**
     * constructor in order to create a new instance of the class.
     * @param score -counter of the score in the game.
     * @param gameLevel - the animation gameLevel in order to print the background.
     */
    public GameOver(Counter score, GameLevel gameLevel) {
        this.score = score;
        this.gameLevel = gameLevel;
    }

    /**
     * the method handle the fame specific logic.
     * @param d - the draw surface that the animation is on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        // print the level background.
        this.gameLevel.getLevelInfo().getBackground().drawOn(d);
        // print the message- game over.
        d.setColor(Color.BLACK);
        d.drawText(260, 200, "--------------------------------", 25);
        d.drawText(200, 250, "Game Over. Your score is " + score.getValue(), 30);
        d.drawText(600, 585, "press space to return menu.", 15);
    }

    /**
     * the method handle the stop conditions of the animations.
     * (always return false cause the KeyPressStoppableAnimation handle the stop conditions.)
     * @return true if the animation should stop, else return false.
     */
    @Override
    public boolean shouldStop() {
        return false;
    }
}
