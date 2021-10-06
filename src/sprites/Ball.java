/* Roni Oded. ID-318798782. */
package sprites;

/* import classes from packages. */
import shapes.Line;
import shapes.Point;
import shapes.Velocity;
import collidables.CollisionInfo;
import animations.GameLevel;
import game.GameEnvironment;
import biuoop.DrawSurface;

/**
 * @author Roni Oded.
 * class Ball, have a center point, radius, color, velocity and frame boarders.
 * implements Sprite
 */
public class Ball implements Sprite {

    /* declaring the fields in the class. */
    private Point center;
    private int radius;
    private java.awt.Color color;
    private Velocity velocity;
    private GameEnvironment gameEnvironment;

    /**
     * constructor in order to build the Sprites.Ball.
     * @param center is the center point of the ball.
     * @param radius is the radius of the ball (circle).
     * @param color is the color of the ball.
     * @param gameEnvironment the collection of objects ball can collide with.
     */
    public Ball(Point center, int radius, java.awt.Color color, GameEnvironment gameEnvironment) {

        /* initializing the fields of this instance of the class. */
        this.center = center;
        this.radius = radius;
        this.color = color;
        this.gameEnvironment = gameEnvironment;
        this.velocity = new Velocity(0, 0);
    }

    /**
     * the method return the x value of the center point of the ball.
     * @return the x value of the center point of the ball.
     */
    public int getX() {
        return (int) this.center.getX();
    }

    /**
     * the method return the y value of the center point of the ball.
     * @return the y value of the center point of the ball.
     */
    public int getY() {
        return (int) this.center.getY();
    }

    /**
     * the method return the radius of the ball.
     * @return the radius of the ball.
     */
    public int getSize() {
        return this.radius;
    }

    /**
     * the method return the color of the ball.
     * @return the color of the ball.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * the method is drawing tha ball.
     * @param surface is the surface we need to draw above the ball.
     */
    @Override
    public void drawOn(DrawSurface surface) {

        /* drawing the ball with his color, center point and radius. */
        surface.setColor(this.color);
        surface.fillCircle(this.getX(), this.getY(), this.radius);
    }

    /**
     * the method notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {
        this.moveOneStep();
    }

    /**
     * the method set the velocity of this ball to the velocity that sent to the method.
     * @param v an instance of AbstractShapes.Velocity class.
     */
    public void setVelocity(Velocity v) {
        this.velocity = v;
    }

    /**
     * the method set the velocity of this ball to the velocity with dx and dy that sent to the method.
     * @param dx value of x axe.
     * @param dy value of y axe.
     */
    public void setVelocity(double dx, double dy) {
        this.velocity = new Velocity(dx, dy);
    }

    /**
     * the method return the velocity of the ball.
     * @return the velocity of the ball.
     */
    public Velocity getVelocity() {
        return this.velocity;
    }

    /**
     * the method changing the velocity of the ball by one step.
     */
    public void moveOneStep() {

        /* trajectory is the line that the ball will move if there is no intersection. */
        Line trajectory = new Line(this.center, new Point(Math.round(this.getX() + this.getVelocity().getDx()),
                Math.round(this.getY() + this.getVelocity().getDy())));

        /* collisionPoint is the closet collision of the collidables in game environment and the trajectory. */
        CollisionInfo collisionPoint = this.gameEnvironment.getClosestCollision(trajectory);

        /* if there is no collision we are moving the ball as it should be.
        * else, there is a collision so move the ball to almost the hit point, notify the hit object that a collision
        * occurred (calling the hit method) and update the velocity to the new velocity returned by the hit method. */
        if (collisionPoint != null) {
            this.center = new Point(Math.round(collisionPoint.collisionPoint().getX() - this.getVelocity().getDx()),
                    Math.round(collisionPoint.collisionPoint().getY() - this.getVelocity().getDy()));

            /* updating the velocity from the hit method. */
            this.setVelocity(collisionPoint.collisionObject().hit(this, collisionPoint.collisionPoint(),
                    this.getVelocity()));
        }
        this.center = this.getVelocity().applyToPoint(this.center);
    }

    /**
     * the method add the ball to the game.
     * @param g - a game to add the ball to.
     */
    @Override
    public void addToGame(GameLevel g) {

        /* adding to the game. */
        g.addSprite(this);
    }

    /**
     * the method change the center of the ball.
     * @param newPoint - new center to change the center ball to.
     */
    public void setCenter(Point newPoint) {
        this.center = newPoint;
    }

    /**
     * the method remove the block to the game.
     * @param gameLevel - a game to remove the block to.
     */
    public void removeFromGame(GameLevel gameLevel) {

        /* removing from the game. */
        gameLevel.removeSprite(this);
    }
}