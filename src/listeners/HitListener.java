/* Roni Oded. ID-318798782. */
package listeners;

/* import classes from packages. */
import collidables.Block;
import sprites.Ball;

/**
 * @author Roni Oded.
 * interface HitListener - the listeners that knows when a hit is being occured.
 */
public interface HitListener {

    /**
     * the method is being called whenever the beingHit object is hitting the ball - hitter.
     * @param beingHit - the block that being hit.
     * @param hitter - the ball that's doing the hitting.
     */
     void hitEvent(Block beingHit, Ball hitter);
}