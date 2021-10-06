/* Roni Oded. ID-318798782. */
package levels;

/* import classes from packages. */
import collidables.Block;
import shapes.Point;
import shapes.Rectangle;
import shapes.Velocity;
import sprites.Sprite;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;
import levels.backgrounds.LevelOneBackground;

/**
 * @author Roni Oded.
 * class LevelOne, stores the data about level one.
 * implements LevelInformation.
 */
public class LevelOne implements LevelInformation {
    private static final int HEIGHT_BLOCKS = 20;
    private static final int WIDTH_BLOCKS = 95;
    private static final int FIRST_ROW_HEIGHT_BLOCKS = 200;

    @Override
    public int numberOfBalls() {
        return initialBallVelocities().size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {

        /* initialize velocities. */
        List<Velocity> list = new ArrayList<>();
        list.add(new Velocity(5, -5));
        list.add(new Velocity(3, -3));
        list.add(new Velocity(-5, -5));
        list.add(new Velocity(-3, -3));
        list.add(new Velocity(-2, -2));
        list.add(new Velocity(2, -2));
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 15;
    }

    @Override
    public int paddleWidth() {
        return 300;
    }

    @Override
    public String levelName() {
        return "Level 1";
    }

    @Override
    public Sprite getBackground() {
        return new LevelOneBackground();
    }

    @Override
    public List<Block> blocks() {

        /* colors of the blocks in the lines. */
        java.awt.Color[] colorsList = {Color.RED, Color.YELLOW, Color.BLUE, Color.PINK, Color.GREEN, Color.MAGENTA,
                Color.CYAN, Color.ORANGE};
        /* declaring new list of blocks. */
        List<Block> listOfBlocks = new ArrayList<>();
        int width = 20;

        /* moving the colors to add blocks on. */
        for (java.awt.Color color : colorsList) {
            listOfBlocks.add(new Block(new Rectangle(new Point(width, FIRST_ROW_HEIGHT_BLOCKS), WIDTH_BLOCKS,
                    HEIGHT_BLOCKS), color));
            width += WIDTH_BLOCKS;
        }
        return listOfBlocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
