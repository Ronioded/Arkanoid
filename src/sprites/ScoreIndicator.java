/* Roni Oded. ID-318798782. */
package sprites;

/* import classes from packages. */
import game.Counter;
import animations.GameLevel;
import biuoop.DrawSurface;
import java.awt.Color;

/**
 * @author Roni Oded.
 * class ScoreIndicator, responsible on the score pannel above.
 * implements Sprite
 */
public class ScoreIndicator implements Sprite {
    private Counter score;
    private static final int WIDTH = 800;
    private static final int HEIGHT_BLOCKS = 20;
    private static final int ZERO = 0;
    private static final int X_VALUE = 380;
    private static final int Y_VALUE = 15;
    private static final int FONT_SIZE = 15;


    /**
     * constructor in order to build an instance of the class.
     * @param score - the score in the game.
     */
    public ScoreIndicator(Counter score) {
        this.score = score;
    }

    /**
     * the method draw the sprite.
     * @param d - drawSurface to draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {

        /* draw and fill the rectangle of the score. */
        d.setColor(Color.BLACK);
        d.drawRectangle(ZERO, ZERO, WIDTH, HEIGHT_BLOCKS);
        d.setColor(Color.WHITE);
        d.fillRectangle(ZERO, ZERO, WIDTH, HEIGHT_BLOCKS);
        d.setColor(Color.BLACK);

        /* adding the Text and score. */
        d.drawText(X_VALUE, Y_VALUE, "Score: " + score.getValue(), FONT_SIZE);
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
