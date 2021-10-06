/* Roni Oded. ID-318798782. */
package collidables;

/* import classes from packages. */
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;
import shapes.Velocity;
import animations.GameLevel;
import listeners.HitListener;
import sprites.Ball;
import sprites.Sprite;
import biuoop.DrawSurface;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roni Oded.
 * class Block- an object we can collide with so it is implements Collidable, sprite and
 * HitNotifier surfaces.
 */
public class Block implements Collidable, Sprite, HitNotifier {

    /* fields of the instances in the class. */
    private Rectangle rectangle;
    private java.awt.Color color;
    private java.util.List<HitListener> hitListeners;

    /**
     * constructor in order to build instance of the class.
     * @param rect - rectangle in order to update the block.
     * @param color - the color of the block.
     */
    public Block(Rectangle rect, java.awt.Color color) {

        /* initializing the fields. */
        this.rectangle = rect;
        this.color = color;
        this.hitListeners = new ArrayList<>();
    }

    /**
     * the method return the color of the block.
     * @return the color of the block.
     */
    public java.awt.Color getColor() {
        return this.color;
    }

    /**
     * the method is drawing tha block.
     * @param surface is the surface we need to draw above the block.
     */
    @Override
    public void drawOn(DrawSurface surface) {

        /* drawing the block with the color black. */
        surface.setColor(Color.BLACK);
        surface.drawRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) (this.rectangle.getUpperLeft().getY()), (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());

        /* filling the block with the color of the block. */
        surface.setColor(this.color);
        surface.fillRectangle((int) this.rectangle.getUpperLeft().getX(),
                (int) (this.rectangle.getUpperLeft().getY()), (int) this.rectangle.getWidth(),
                (int) this.rectangle.getHeight());
    }

    /**
     * the method notify the sprite that time has passed.
     */
    @Override
    public void timePassed() { }

    /**
     * the method calculate and return the "collision shape" of the object.
     * @return the "collision shape" of the object.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.rectangle;
    }

    /**
     * the method gets a collisionPoint and currentVelocity and return the new velocity expected after the hit.
     * @param hitter - the ball that hit the collidable.
     * @param collisionPoint - the point where the object that we collided with at.
     * @param currentVelocity - the current velocity.
     * @return the new velocity expected after the hit.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        /* change the velocity as the line that the collision point accrued at. */
        if (checkBetweenLine(this.getCollisionRectangle().getRightLine(), collisionPoint)) {
            currentVelocity.setDx(-1 * currentVelocity.getDx());
        }
        if (checkBetweenLine(this.getCollisionRectangle().getLeftLine(), collisionPoint)) {
            currentVelocity.setDx(-1 * currentVelocity.getDx());
        }
        if (checkBetweenLine(this.getCollisionRectangle().getUpLine(), collisionPoint)) {
            currentVelocity.setDy(-1 * currentVelocity.getDy());
        }
        if (checkBetweenLine(this.getCollisionRectangle().getDownLine(), collisionPoint)) {
            currentVelocity.setDy(-1 * currentVelocity.getDy());
        }

        /* notify there is a hit. */
        this.notifyHit(hitter);

        /* return current velocity after the changes. */
        return currentVelocity;
    }

    /**
     * the method check if the collision point is in the line.
     * @param line - a line to check if the collision point is at.
     * @param collisionPoint - the collision point to check is it is on the line.
     * @return - true if the collision point is in the line. else, return false.
     */
    public boolean checkBetweenLine(Line line, Point collisionPoint) {

        Point thisStart = line.start();
        Point thisEnd = line.end();

        /* if the x value of start point is bigger than the x value of end point (or the x values are equal but the y
        value of start point is bigger than the y value of end point) i'm replacing between the points. */
        if ((thisStart.getX() > thisEnd.getX() || ((thisStart.getX() == thisEnd.getX())
                && (thisStart.getY() > thisEnd.getY())))) {
            thisStart = line.end();
            thisEnd = line.start();
        }

        /* if the line end and start x values are equal, i am checking if the collision point is between the y values
        * and that the x value of the collision is equal to the x value of the line. */
        if (thisStart.getX() == thisEnd.getX()) {
            return ((thisStart.getX() == collisionPoint.getX()) && (collisionPoint.getY() >= thisStart.getY())
                    && (collisionPoint.getY() <= thisEnd.getY()));
        }

        /* else, return if the line end and start y values are equal, i am checking if the collision point is between
         * the x values. and that the y value of the collision is equal to the y value of the line.  */
        return ((thisStart.getY() == collisionPoint.getY()) && (collisionPoint.getX() >= thisStart.getX())
                    && (collisionPoint.getX() <= thisEnd.getX()));

    }

    /**
     * the method add the block to the game.
     * @param g - a game to add the block to.
     */
    @Override
    public void addToGame(GameLevel g) {

        /* adding to the game. */
        g.addSprite(this);
        g.addCollidable(this);
    }

    /**
     * the method remove the block to the game.
     * @param gameLevel - a game to remove the block from.
     */
    public void removeFromGame(GameLevel gameLevel) {

        /* removing from the game. */
        gameLevel.removeSprite(this);
        gameLevel.removeCollidable(this);
    }

    /**
     * the method notify all the listeners in the list that there was a hit.
     * @param hitter - the ball that this block hit.
     */
    private void notifyHit(Ball hitter) {

        /* Make a copy of the hitListeners before iterating over them. */
        List<HitListener> listeners = new ArrayList<>(this.hitListeners);

        /* Notify all listeners about a hit event: */
        for (HitListener hl : listeners) {
            hl.hitEvent(this, hitter);
        }
    }

    /**
     * the method add hl as a listener to hit events.
     * @param hl - the listener.
     */
    @Override
    public void addHitListener(HitListener hl) {
        this.hitListeners.add(hl);
    }

    /**
     * the method remove hl from the list of listeners to hit events.
     * @param hl - the listener.
     */
    @Override
    public void removeHitListener(HitListener hl) {
        this.hitListeners.remove(hl);
    }
}
