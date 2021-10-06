/* Roni Oded. ID-318798782. */
package levels;

/* import classes from packages. */
import levels.backgrounds.LevelTreeBackground;
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
 * class LevelThree, stores the data about level three.
 * implements LevelInformation.
 */
public class LevelThree implements LevelInformation {
    private static final int WIDTH = 800;
    private static final int HEIGHT_BLOCKS = 20;
    private static final int WIDTH_BLOCKS = 50;
    private static final int FIRST_NUM_BLOCKS = 12;
    private static final int FIRST_ROW_HEIGHT_BLOCKS = 250;

    @Override
    public int numberOfBalls() {
        return initialBallVelocities().size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {

        /* initialize velocities. */
        List<Velocity> list = new ArrayList<>();
        list.add(new Velocity(3, 3));
        list.add(new Velocity(-3, 3));
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 15;
    }

    @Override
    public int paddleWidth() {
        return 150;
    }

    @Override
    public String levelName() {
        return "Level 3";
    }

    @Override
    public Sprite getBackground() {
        return new LevelTreeBackground();
    }

    @Override
    public List<Block> blocks() {

        /* colors of the blocks in the lines. */
        java.awt.Color[] colorsList = {Color.RED, Color.YELLOW, Color.GREEN};
        List<Block> listOfBlocks = new ArrayList<>();

        /* moving the lines to add blocks on. */
        for (int j = 0; j < colorsList.length; j++) {

            /* setting the blocks in line j, and adding them to the game.
             adding the listeners to the blocks and with every block added increase the blockCounter by 1. */
            for (int i = 1; i <= FIRST_NUM_BLOCKS - j; i++) {
                listOfBlocks.add(new Block(new Rectangle(new Point(WIDTH - HEIGHT_BLOCKS - i * WIDTH_BLOCKS,
                        FIRST_ROW_HEIGHT_BLOCKS + j * HEIGHT_BLOCKS), WIDTH_BLOCKS, HEIGHT_BLOCKS), colorsList[j]));
            }
        }
        return listOfBlocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
