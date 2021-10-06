/* Roni Oded. ID-318798782. */
package listeners;

/* import classes from packages. */
import collidables.Block;
import game.Counter;
import animations.GameLevel;
import sprites.Ball;

/**
 * @author Roni Oded.
 * class BlockRemover, removing blocks from the game, keeping count of the number of blocks that remain.
 * implements HitListener
 */
public class BlockRemover implements HitListener {

    /* fields in the class. */
    private GameLevel gameLevel;
    private Counter remainingBlocks;

    /**
     * constructor in order to build an instance of the class.
     * @param gameLevel - this game.
     * @param remainingBlocks - number of blocks in the game.
     */
    public BlockRemover(GameLevel gameLevel, Counter remainingBlocks) {

        /* initializing the fields of this instance of the class. */
        this.gameLevel = gameLevel;
        this.remainingBlocks = remainingBlocks;
    }

    /**
     * the method remove from the game the block that are hit, remove the listener from the block and decrease
     * number of blocks in the game.
     * @param beingHit - the block that being hit.
     * @param hitter - the ball that's doing the hitting.
     */
    @Override
    public void hitEvent(Block beingHit, Ball hitter) {
        this.remainingBlocks.decrease(1);
        beingHit.removeHitListener(this);
        beingHit.removeFromGame(gameLevel);
    }
}