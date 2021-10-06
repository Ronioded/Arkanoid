/* Roni Oded. ID-318798782. */
package animations;

/* import classes from packages. */
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import collidables.Block;
import game.GameEnvironment;
import shapes.Point;
import shapes.Rectangle;
import sprites.Ball;
import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roni Oded.
 * class MenuAnimation - represent the animation of the menu.
 * @param <T> - generic variable in order to specify the return type from the menu.
 * implements Menu.
 */
public class MenuAnimation<T> implements Menu<T> {

    /* fields of an instance of the class. */
    private String menuTitle;
    private List<String> keysList;
    private List<String> messagesToPrintList;
    private List<T> tasksList;
    private T status;
    private Boolean stop;
    private KeyboardSensor keyboard;

    /**
     * constructor in order to create a new instance of the class.
     * @param menuTitle - string that represent the menu title.
     * @param keyboard - keyboard sensor.
     */
    public MenuAnimation(String menuTitle, KeyboardSensor keyboard) {

        /* initializing the fields. */
        this.menuTitle = menuTitle;
        this.keysList = new ArrayList<>();
        this.messagesToPrintList = new ArrayList<>();
        this.tasksList = new ArrayList<>();
        this.stop = false;
        this.keyboard = keyboard;
        this.status = null;
    }

    /**
     * the method handle the frame specific logic.
     * @param d - the draw surface that the game is on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        //printing the background.
        printBackground(d);

        /* moving on the keys list and check if one of them is pressed. */
        for (int i = 0; i < keysList.size(); i++) {
            /* if the key on index i pressed, stop the animation and update status to be the task in index i. */
            if (this.keyboard.isPressed(keysList.get(i))) {
                this.stop = true;
                this.status = tasksList.get(i);
            }
        }
    }

    /**
     * the method handle the stop conditions of the animations.
     * @return true if the animation should stop, else return false.
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }

    /**
     * the method add a selection to the menu.
     * @param key - a key to press for this selection.
     * @param messageToPrint - a 'title' to this selection.
     * @param returnTask - the return value that this selection should return.
     */
    @Override
    public void addSelection(String key, String messageToPrint, T returnTask) {
        // add all the variables to the correct list.
        this.keysList.add(key);
        this.messagesToPrintList.add(messageToPrint);
        this.tasksList.add(returnTask);
    }

    /**
     * the method return the status from the menu- return the selection that was made from the menu.
     * @return the selection that was made from the menu.
     */
    @Override
    public T getStatus() {
        return this.status;
    }

    /**
     * the method changing stop to the value.
     * @param value - the value stop should change to.
     */
    public void setStop(Boolean value) {
        this.stop = value;
    }

    /**
     * the method responsible on drawing the background of the animation.
     * @param d - the drawSurface to draw on.
     */
    public void printBackground(DrawSurface d) {
        //draw the background color.
        d.setColor(Color.orange);
        d.fillRectangle(0, 0, 800, 600);
        //colors of the blocks in the lines.
        java.awt.Color[] colorsList = {Color.MAGENTA, Color.RED, Color.YELLOW, Color.BLUE, Color.PINK, Color.GREEN,
                Color.CYAN};
        List<Block> listOfBlocks = new ArrayList<>();
        int width = 25;
        int firstWidth = 25;
        int numBlocks = 15;
        //moving the lines to add blocks on.
        for (int j = 0; j < colorsList.length; j++) {
            //setting the blocks in line j.
            for (int i = 1; i <= numBlocks; i++) {
                listOfBlocks.add(new Block(new Rectangle(new Point(width, 50 + j * 21), 49, 20),
                        colorsList[j]));
                width += 50;
            }
            width = firstWidth;
        }
        // add the "paddle".
        listOfBlocks.add(new Block(new Rectangle(new Point(325, 250), 150, 20), Color.BLACK));
        // draw all the blocks.
        for (Block b : listOfBlocks) {
            b.drawOn(d);
        }
        // create a ball and draw it.
        Ball b = new Ball(new Point(400, 235), 10, Color.white, new GameEnvironment());
        b.drawOn(d);
        //draw the menu title.
        width = 240;
        int height = 330;
        d.setColor(Color.yellow);
        d.drawText(width - 2, height - 2, this.menuTitle, 50);
        d.setColor(Color.BLACK);
        d.drawText(width, height, this.menuTitle, 50);
        //printing the menu selections.
        for (int i = 0, whereToPrint = 400; i < this.keysList.size(); i++, whereToPrint += 30) {
            d.drawText(245, whereToPrint, "press " + this.keysList.get(i) + " in order to "
                    + this.messagesToPrintList.get(i), 20);
        }
    }
}
