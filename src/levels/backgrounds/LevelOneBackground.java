/* Roni Oded. ID-318798782. */
package levels.backgrounds;

/* import classes from packages. */
import biuoop.DrawSurface;
import animations.GameLevel;
import java.awt.Color;

/**
 * @author Roni Oded.
 * class levelOneBackground, has the background of level1.
 * implements Background.
 */
public class LevelOneBackground implements Background {

    /**
     * the method draw the sprite.
     * @param d - drawSurface to draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        /* drawing the background */
        d.setColor(Color.WHITE);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());

        /* drawing the sun. */
        d.setColor(Color.YELLOW);
        d.drawCircle(400, 120, 70);
        d.fillCircle(400, 120, 70);
        d.setColor(Color.ORANGE);
        d.fillRectangle(280, 119, 50, 2);
        d.fillRectangle(470, 119, 50, 2);
        d.fillRectangle(399, 190, 2, 50);
        d.fillRectangle(399, 20, 2, 30);
        d.drawLine(450, 70, 520, 20);
        d.drawLine(350, 70, 280, 20);
        d.drawLine(450, 170, 520, 220);
        d.drawLine(350, 170, 280, 220);

        /* drawing the sea. */
        d.setColor(Color.CYAN);
        d.fillRectangle(0, 450, 800, 150);
        for (int i = 10; i < 800; i += 20) {
            d.setColor(Color.CYAN);
            d.fillCircle(i, 450, 5);
            d.setColor(Color.WHITE);
            d.fillCircle(i + 10, 450, 5);
        }
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
