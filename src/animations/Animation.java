/* Roni Oded. ID-318798782. */
package animations;

/* import classes from packages. */
import biuoop.DrawSurface;

/**
 * @author Roni Oded.
 * interface Animation - hold methods that any animation of the game have to have.
 */
public interface Animation {

    /**
     * the method handle the frame specific logic.
     * @param d - the draw surface that the game is draw on.
     */
    void doOneFrame(DrawSurface d);

    /**
     * the method handle the stop conditions of the animations.
     * @return true if the animation should stop, else return false.
     */
    boolean shouldStop();
}
