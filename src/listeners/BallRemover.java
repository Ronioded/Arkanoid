/* Roni Oded. ID-318798782. */
package listeners;

/* import classes from packages. */
import collidables.Block;
import game.Counter;
import animations.GameLevel;
import sprites.Ball;

/**
 * @author Roni Oded.
 * class BallRemover, removing balls from the game, keeping count of the number of balls that remain.
 * implements HitListener
 */
public class BallRemover implements HitListener {

    /* fields in the class. */
    private GameLevel gameLevel;
    private Counter remainingBalls;

    /**
     * constructor in order to build an instance of the class.
     * @param gameLevel - this game.
     * @param remainingBalls - number of balls in the game.
     */
    public BallRemover(GameLevel gameLevel, Counter remainingBalls) {

        /* initializing the fields of this instance of the class. */
        this.gameLevel = gameLevel;
        this.remainingBalls = remainingBalls;
    }

    /**
     * the method is being called whenever the beingHit object is hitting the ball - hitter.
     * @param beingHit - the block that being hit.
     * @param hitter - the ball that's doing the hitting.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {

        /* remove the ball from the game and decrease the remaining ball by 1. */
        this.remainingBalls.decrease(1);
        hitter.removeFromGame(this.gameLevel);
    }
}