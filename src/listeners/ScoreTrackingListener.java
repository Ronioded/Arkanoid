/* Roni Oded. ID-318798782. */
package listeners;

/* import classes from packages. */
import collidables.Block;
import game.Counter;
import sprites.Ball;

/**
 * @author Roni Oded.
 * class ScoreTrackingListener, keep track on the scores in the game.
 * implements HitListener
 */
public class ScoreTrackingListener implements HitListener {
    private Counter currentScore;
    private static final int HIT_BLOCK_POINTS = 5;

    /**
     * constructor in order to build an instance of the class.
     * @param scoreCounter - the score counter of the game.
     */
    public ScoreTrackingListener(Counter scoreCounter) {
        this.currentScore = scoreCounter;
    }

    /**
     * the method is being called whenever the beingHit object is hitting the ball - hitter - add 5 points when its
     * happen.
     * @param beingHit - the block that being hit.
     * @param hitter - the ball that's doing the hitting.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
       this.currentScore.increase(HIT_BLOCK_POINTS);
    }
}
