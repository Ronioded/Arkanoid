/* Roni Oded. ID-318798782. */
package levels.backgrounds;

/* import classes from packages. */
import biuoop.DrawSurface;
import animations.GameLevel;
import java.awt.Color;

/**
 * @author Roni Oded.
 * class LevelTreeBackground, has the background of level3.
 * implements Background.
 */
public class LevelTreeBackground implements Background {

    /**
     * the method draw the sprite.
     * @param d - drawSurface to draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        /* drawing the clouds. */
        d.setColor(Color.CYAN);
        d.fillRectangle(0, 0, d.getWidth(), d.getHeight());
        d.setColor(Color.BLUE);
        d.fillCircle(100, 100, 40);
        d.fillCircle(50, 130, 40);
        d.fillCircle(150, 115, 40);
        d.fillCircle(80, 160, 40);
        d.fillCircle(130, 155, 40);

        d.fillCircle(700, 400, 40);
        d.fillCircle(650, 430, 40);
        d.fillCircle(750, 415, 40);
        d.fillCircle(680, 460, 40);
        d.fillCircle(730, 455, 40);

        d.fillCircle(550, 150, 40);
        d.fillCircle(500, 180, 40);
        d.fillCircle(600, 165, 40);
        d.fillCircle(530, 210, 40);
        d.fillCircle(580, 205, 40);

        d.fillCircle(200, 500, 40);
        d.fillCircle(150, 530, 40);
        d.fillCircle(250, 515, 40);
        d.fillCircle(180, 560, 40);
        d.fillCircle(230, 555, 40);
    }

    /**
     * the method notify the sprite that time has passed.
     */
    @Override
    public void timePassed() { }

    /**
     * the method add the sprite to the game.
     *
     * @param g - a game to add the sprite to.
     */
    @Override
    public void addToGame(GameLevel g) {
        g.addSprite(this);
    }
}
