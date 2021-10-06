/* Roni Oded. ID-318798782. */
package collidables;

/* import classes from packages. */
import listeners.HitListener;

/**
 * @author Roni Oded.
 * interface HitNotifier - the notifier that notify to the listeners when a hit is being occured.
 */
public interface HitNotifier {

    /**
     * the method add hl as a listener to hit events.
     * @param hl - the listener.
     */
    void addHitListener(HitListener hl);

    /**
     * the method remove hl from the list of listeners to hit events.
     * @param hl - the listener.
     */
    void removeHitListener(HitListener hl);
}