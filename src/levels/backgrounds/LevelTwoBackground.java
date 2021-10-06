/* Roni Oded. ID-318798782. */
package levels.backgrounds;

/* import classes from packages. */
import biuoop.DrawSurface;
import animations.GameLevel;
import java.awt.Color;

/**
 * @author Roni Oded.
 * class LevelTwoBackground, has the background of level2.
 * implements Background.
 */
public class LevelTwoBackground implements Background {

    /**
     * the method draw the sprite.
     * @param d - drawSurface to draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        /* drawing the targets. */
        d.setColor(Color.PINK);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.BLACK);
        d.drawCircle(160, 210, 50);
        d.drawCircle(160, 210, 100);
        d.drawCircle(640, 210, 50);
        d.drawCircle(640, 210, 100);
        d.drawCircle(400, 410, 50);
        d.drawCircle(400, 410, 100);
        d.drawLine(160, 60, 160, 360);
        d.drawLine(10, 210, 310, 210);
        d.drawLine(640, 60, 640, 360);
        d.drawLine(790, 210, 490, 210);
        d.drawLine(400, 260, 400, 560);
        d.drawLine(250, 410, 550, 410);
    }

    /**
     * the method notify the sprite that time has passed.
     */
    @Override
    public void timePassed() { }

    /**
     * the method add the sprite to the game.
     * @param g - a game to add the sprite to.
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
