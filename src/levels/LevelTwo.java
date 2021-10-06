/* Roni Oded. ID-318798782. */
package levels;

/* import classes from packages. */
import levels.backgrounds.LevelTwoBackground;
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
 * class LevelTwo, stores the data about level two.
 * implements LevelInformation.
 */
public class LevelTwo implements LevelInformation {
    private static final int HEIGHT_BLOCKS = 20;
    private static final int WIDTH_BLOCKS = 20;

    @Override
    public int numberOfBalls() {
        return initialBallVelocities().size();
    }

    @Override
    public List<Velocity> initialBallVelocities() {

        /* initialize velocities. */
        List<Velocity> list = new ArrayList<>();
        list.add(new Velocity(5, -5));
        list.add(new Velocity(0, -3));
        list.add(new Velocity(-5, -5));
        return list;
    }

    @Override
    public int paddleSpeed() {
        return 15;
    }

    @Override
    public int paddleWidth() {
        return 110;
    }

    @Override
    public String levelName() {
        return "Level 2";
    }

    @Override
    public Sprite getBackground() {
        return new LevelTwoBackground();
    }

    @Override
    public List<Block> blocks() {

        /* declaring new list and adding the blocks to the list. */
        List<Block> listOfBlocks = new ArrayList<>();
        listOfBlocks.add(new Block(new Rectangle(new Point(150, 200), WIDTH_BLOCKS, HEIGHT_BLOCKS),
                Color.MAGENTA));
        listOfBlocks.add(new Block(new Rectangle(new Point(630, 200), WIDTH_BLOCKS, HEIGHT_BLOCKS),
                Color.MAGENTA));
        listOfBlocks.add(new Block(new Rectangle(new Point(390, 400), WIDTH_BLOCKS, HEIGHT_BLOCKS),
                Color.MAGENTA));
        return listOfBlocks;
    }

    @Override
    public int numberOfBlocksToRemove() {
        return blocks().size();
    }
}
