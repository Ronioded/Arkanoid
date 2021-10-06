/* Roni Oded. ID-318798782. */
package collidables;

/* import classes from packages. */
import shapes.Point;
import shapes.Rectangle;
import shapes.Velocity;
import sprites.Ball;

/**
 * @author Roni Oded.
 * interface Collidable - have the location and size of items in order to know if we are colliding with it
 * or not. also know what happens when the collision occurs.
 */
public interface Collidable {

    /**
     * the method calculate and return the "collision shape" of the object.
     * @return the "collision shape" of the object.
     */
    Rectangle getCollisionRectangle();

    /**
     * the method gets a collisionPoint and currentVelocity and return the new velocity expected after the hit.
     * @param hitter - the ball that hit the collidable.
     * @param collisionPoint - the point where the object that we collided with at.
     * @param currentVelocity - the current velocity.
     * @return the new velocity expected after the hit.
     */
    Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity);
}
