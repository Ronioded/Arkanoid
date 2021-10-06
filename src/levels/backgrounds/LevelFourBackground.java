/* Roni Oded. ID-318798782. */
package levels.backgrounds;

/* import classes from packages. */
import biuoop.DrawSurface;
import animations.GameLevel;
import java.awt.Color;

/**
 * @author Roni Oded.
 * class LevelFourBackground, has the background of level4.
 * implements Background.
 */
public class LevelFourBackground implements Background {

    /**
     * the method draw the sprite.
     * @param d - drawSurface to draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        /* drawing the background */
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.ORANGE);
        int height = 6;
        int width = 6;
        for (int i = 0; i < 40; i++) {
            for (int j = 0; j < 55; j++) {
                d.fillCircle(width, height, 5);
                width += 15;
            }
            width = 6;
            height += 15;
        }
        d.setColor(Color.BLACK);
        d.drawText(260, 200, "You Rock!, almost done!", 25);
        d.setColor(Color.YELLOW);
        d.drawText(277, 202, "You Rock!, almost done!", 25);
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
