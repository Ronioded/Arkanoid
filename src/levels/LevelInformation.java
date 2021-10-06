/* Roni Oded. ID-318798782. */
package levels;

/* import classes from packages. */
import collidables.Block;
import shapes.Velocity;
import sprites.Sprite;
import java.util.List;

/**
 * @author Roni Oded.
 * interface LevelInformation - specifies the information required to describe a level.
 */
public interface LevelInformation {

    /**
     * the method return the number of balls in the level.
     * @return - the number of balls in the level.
     */
    int numberOfBalls();

    /**
     * The method initial velocity of each ball.
     * @return list of the velocity of the balls.
     */
    List<Velocity> initialBallVelocities();

    /**
     * return the paddle speed in the level.
     * @return the paddle speed in the level.
     */
    int paddleSpeed();

    /**
     * return the paddle width in the level.
     * @return the paddle width in the level.
     */
    int paddleWidth();

    /**
     * return the level name that will be displayed at the top of the screen.
     * @return the level name.
     */
    String levelName();

    /**
     * Returns a sprite with the background of the level.
     * @return a sprite with the background of the level.
     */
    Sprite getBackground();

    /**
     * return a lists of the blocks that made in this level.
     * @return a lists of the blocks that made in this level.
     */
    List<Block> blocks();

    /**
     * return number of blocks that should be removed before the level is considered to be "cleared".
     * @return  number of blocks that should be removed before the level.
     */
    int numberOfBlocksToRemove();
}
