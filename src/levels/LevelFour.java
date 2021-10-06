/* Roni Oded. ID-318798782. */
package levels;

/* import classes from packages. */
import levels.backgrounds.LevelFourBackground;
import collidables.Block;
import shapes.Point;
import shapes.Rectangle;
import shapes.Velocity;
import sprites.Sprite;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roni Oded.
 * class LevelFour, stores the data about level four.
 * implements LevelInformation.
 */
public class LevelFour implements LevelInformation {
    private static final int HEIGHT_BLOCKS = 20;
    private static final int WIDTH_BLOCKS = 50;
    private static final int FIRST_ROW_HEIGHT_BLOCKS = 150;

    @Override
    public int numberOfBalls() {
        return initialBallVelocities().size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {

        /* initialize velocities. */
        List<Velocity> list = new ArrayList<>();
        list.add(new Velocity(3, -5));
        list.add(new Velocity(-3, -5));
        list.add(new Velocity(-3, -3));
        list.add(new Velocity(3, -3));

        return list;
    }

    @Override
    public int paddleSpeed() {
        return 15;
    }

    @Override
    public int paddleWidth() {
        return 100;
    }

    @Override
    public String levelName() {
        return "Level 4";
    }

    @Override
    public Sprite getBackground() {
        return new LevelFourBackground();
    }

    @Override
    public List<Block> blocks() {

        /* colors of the blocks in the lines. */
        java.awt.Color[] colorsList = {Color.BLACK, Color.MAGENTA, Color.RED, Color.YELLOW, Color.BLUE, Color.PINK,
                Color.GREEN, Color.CYAN};
        List<Block> listOfBlocks = new ArrayList<>();

        int width = 25;
        int firstWidth = 25;
        int numBlocks = 15;
        /* moving the lines to add blocks on. */
        for (int j = 0; j < colorsList.length; j++) {

            /* setting the blocks in line j, and adding them to the game.
             adding the listeners to the blocks and with every block added increase the blockCounter by 1. */
            for (int i = 1; i <= numBlocks; i++) {
                listOfBlocks.add(new Block(new Rectangle(new Point(width,
                        FIRST_ROW_HEIGHT_BLOCKS + j * HEIGHT_BLOCKS), WIDTH_BLOCKS, HEIGHT_BLOCKS), colorsList[j]));
                width += 50;
            }
            width = firstWidth + 50;
            firstWidth = width;
            numBlocks -= 2;
        }
        return listOfBlocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
