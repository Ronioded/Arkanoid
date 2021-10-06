/* Roni Oded. ID-318798782. */
package animations;

/* import classes from packages. */
import biuoop.DrawSurface;
import collidables.Block;
import game.Counter;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;
import game.GameEnvironment;
import shapes.Rectangle;
import sprites.Ball;
import shapes.Point;

/**
 * @author Roni Oded.
 * class YouWin, display the end screen animation of the game.
 * implements Animation.
 */
public class YouWin implements Animation {

    /* fields of an instance of the class. */
    private Counter score;
    private GameLevel gameLevel;
    private List<Ball> ballList;
    private List<Block> blockList;
    private GameEnvironment gameEnvironment;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int HEIGHT_BLOCKS = 20;
    private static final int ZERO = 0;


    /**
     * constructor in order to create a new instance of the class.
     * @param score - counter of the score in the game.
     * @param gameLevel - animation of the game level.
     */
    public YouWin(Counter score, GameLevel gameLevel) {

        /* initializing all the fields of the class. */
        this.score = score;
        this.gameLevel = gameLevel;
        this.ballList = new ArrayList<>();
        this.blockList = new ArrayList<>();
        this.gameEnvironment = new GameEnvironment();
        addBallsAndBlocks();
    }

    /**
     * the method handle the frame specific logic.
     * @param d - the draw surface that the animation is on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        // draw all the sprites.
        this.gameLevel.drawAllSprites(d);
        // draw the balls and move one step.
        for (Ball b : ballList) {
            b.drawOn(d);
            b.moveOneStep();
        }
        // draw the blocks.
        for (Block b : blockList) {
             b.drawOn(d);
        }
        /* printing the message- you win. */
        d.setColor(Color.RED);
        d.drawText(210, 300, "You Win! Your score is " + score.getValue(), 30);
        d.drawText(600, 585, "press space to return menu.", 15);
    }

    /**
     * the method handle the stop conditions of the animations.
     * (always return false cause the KeyPressStoppableAnimation handle the stop conditions.)
     * @return true if the animation should stop, else return false.
     */
    @Override
    public boolean shouldStop() {
        return false;
    }

    /**
     * the method create a ball and block lists.
     */
    public void addBallsAndBlocks() {
        //setting the blocks in the borders.
        blockList.add(new Block(new Rectangle(new Point(ZERO, HEIGHT_BLOCKS), WIDTH, HEIGHT_BLOCKS), Color.black));
        blockList.add(new Block(new Rectangle(new Point(ZERO, HEIGHT_BLOCKS), HEIGHT_BLOCKS, HEIGHT), Color.black));
        blockList.add(new Block(new Rectangle(new Point(WIDTH - HEIGHT_BLOCKS, HEIGHT_BLOCKS), HEIGHT_BLOCKS,
                HEIGHT), Color.black));
        blockList.add(new Block(new Rectangle(new Point(ZERO, HEIGHT - HEIGHT_BLOCKS), WIDTH, HEIGHT_BLOCKS),
                Color.black));
        // add the blocks to the game environment.
        for (Block b : this.blockList) {
            this.gameEnvironment.addCollidable(b);
        }
        int x = 30;
        int startX = 20;
        int y = 30;
        int startY = 20;
        // colors of the balls.
        java.awt.Color[] colorsList = {Color.BLACK, Color.MAGENTA, Color.RED, Color.YELLOW, Color.BLUE, Color.PINK,
                Color.GREEN, Color.CYAN, Color.ORANGE, Color.WHITE};
        // add balls to the list.
        for (int k = 3; k <= 7; k += 2) {
            for (int i = 1; i <= colorsList.length; i++) {
                for (int j = 0; j < 50; j++, x += 20, y += 20) {
                    Ball b = new Ball(new Point(x, y), k, colorsList[i - 1], this.gameEnvironment);
                    b.setVelocity(5, 5);
                    this.ballList.add(b);
                }
                startX += 50;
                x = startX;
                y = startY;
            }
        }
    }
}
