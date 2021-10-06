/* Roni Oded. ID-318798782. */
package animations;

/* import classes from packages. */
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Roni Oded.
 * class PauseScreen- making the game to be abble to pause while pressing p, and continue while pressing space.
 * implements Animation.
 */
public class PauseScreen implements Animation {
    private GameLevel gameLevel;

    /**
     * constructor in order to create an instance of the class.
     * @param gameLevel - the game level in order to print the animation of the level.
     */
    public PauseScreen(GameLevel gameLevel) {
        this.gameLevel = gameLevel;
    }

    /**
     * the method handle the fame specific logic.
     * @param d - the draw surface that the game is on.
     */
    public void doOneFrame(DrawSurface d) {
        // draw all the sprites.
        this.gameLevel.drawAllSprites(d);

        /* drawing the text- the game paused. */
        d.setColor(Color.BLACK);
        d.drawText(160, d.getHeight() / 2, "paused -- press space to continue", 32);
    }

    /**
     * the method handle the stop conditions of the animations.
     * (always return false cause the KeyPressStoppableAnimation handle the stop conditions.)
     * @return true if the game should stop, else return false.
     */
    public boolean shouldStop() {
        return false;
    }
}
