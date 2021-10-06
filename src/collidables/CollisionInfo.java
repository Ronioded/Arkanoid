/* Roni Oded. ID-318798782. */
package collidables;

/* import classes from packages. */
import shapes.Point;

/**
 * @author Roni Oded.
 * class CollisionInfo - have information of the collision point and the collision object.
 */
public class CollisionInfo {

    /* declaring the fields in the class. */
    private Point collisionPoint;
    private Collidable collidable;

    /**
     * constructor in order to build instance of the class.
     * @param collisionPoint - the point where the collision occurred.
     * @param collidable - the object involved in the collision.
     */
    public CollisionInfo(Point collisionPoint, Collidable collidable) {

        /* initializing the fields. */
        this.collisionPoint = collisionPoint;
        this.collidable = collidable;
    }

    /**
     * the method return the point where the collision occurred.
     * @return the point where the collision occurred.
     */
    public Point collisionPoint() {
        return this.collisionPoint;
    }

    /**
     * the method return the object involved in the collision.
     * @return the object involved in the collision.
     */
    public Collidable collisionObject() {
        return this.collidable;
    }
}