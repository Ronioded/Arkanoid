/* Roni Oded. ID-318798782. */
package sprites;

/* import classes from packages. */
import animations.GameLevel;
import biuoop.DrawSurface;

/**
 * @author Roni Oded.
 * interface Sprite - game object that can be drawn on the screen and can be notified that time has passed.
 */
public interface Sprite {

    /**
     * the method draw the sprite.
     * @param d - drawSurface to draw on.
     */
    void drawOn(DrawSurface d);

    /**
     * the method notify the sprite that time has passed.
     */
    void timePassed();

    /**
     * the method add the sprite to the game.
     * @param g - a game to add the sprite to.
     */
    void addToGame(GameLevel g);
}