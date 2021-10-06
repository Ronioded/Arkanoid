/* Roni Oded. ID-318798782. */
package animations;

/* import classes from packages. */
import biuoop.DrawSurface;
import sprites.SpriteCollection;

/**
 * @author Roni Oded.
 * class CountdownAnimation- support count down in the start of a level.
 * implements Animation.
 */
public class CountdownAnimation implements Animation {

    /* fields of an instance of the class. */
    private double numOfSeconds;
    private int countFrom;
    private int decreasingCount;
    private boolean stop;
    private SpriteCollection gameScreen;
    private double startTime;

    /**
     * constructor in order to create a new instance of the class.
     * @param numOfSeconds - seconds to display the count.
     * @param countFrom - the number to countdown from.
     * @param gameScreen - all the sprites in the game.
     */
    public CountdownAnimation(double numOfSeconds, int countFrom, SpriteCollection gameScreen) {

        /* initializing the fields. */
        this.countFrom = countFrom;
        this.decreasingCount = countFrom;
        this.gameScreen = gameScreen;
        this.numOfSeconds = numOfSeconds;
        this.stop = false;
        this.startTime = System.currentTimeMillis();
    }

    /**
     * the method handle the frame specific logic.
     * @param d - the draw surface that the game is draw on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {

        /* drawing all the sprites */
        this.gameScreen.drawAllOn(d);

        /* printing the count number. */
        d.drawText(400, 300, String.valueOf(this.decreasingCount), 30);

        /* if its has been (numOfSeconds / (countFrom + 1)) seconds since the start time of this count,
        i am decreasing the count so the next number will appear. */
        if ((System.currentTimeMillis() - this.startTime) >= (this.numOfSeconds / (this.countFrom + 1)) * 1000) {
            this.startTime = System.currentTimeMillis();
            this.decreasingCount = this.decreasingCount - 1;
        }

        /* if count from reaches to 0, replacing stop to true because the animation should stop. */
        if (this.decreasingCount == 0) {
            this.stop = true;
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
}