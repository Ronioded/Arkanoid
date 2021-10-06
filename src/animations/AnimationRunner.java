/* Roni Oded. ID-318798782. */
package animations;

/* import classes from packages. */
import biuoop.DrawSurface;
import biuoop.GUI;
import biuoop.Sleeper;

/**
 * @author Roni Oded.
 * class AnimationRunner- responssible of the animation loop, cause a specific animation run over again until it should
 * stop.
 */
public class AnimationRunner {

    /* fields of an instance of the class. */
    private GUI gui;
    private Sleeper sleeper;
    private int framesPerSecond;
    private static final int MILLISECONDS = 1000;

    /**
     * constructor in order to build an instance of the class.
     * @param gui - the gui.
     * @param framesPerSecond - the frames per second the animation should run.
     */
    public AnimationRunner(GUI gui, int framesPerSecond) {

        /* initializing the fields. */
        this.gui = gui;
        this.sleeper = new Sleeper();
        this.framesPerSecond = framesPerSecond;
    }

    /**
     * the method start the animation loop.
     * @param animation - the animation that should run.
     */
    public void run(Animation animation) {
        int millisecondsPerFrame = MILLISECONDS / framesPerSecond;

        /* if the animation should stop, the loop stop. */
        while (!animation.shouldStop()) {
            long startTime = System.currentTimeMillis(); // timing
            DrawSurface d = gui.getDrawSurface();

            /* run one frame of the animation and then show the gui. */
            animation.doOneFrame(d);
            gui.show(d);

            // timing
            long usedTime = System.currentTimeMillis() - startTime;
            long milliSecondLeftToSleep = millisecondsPerFrame - usedTime;
            if (milliSecondLeftToSleep > 0) {
                this.sleeper.sleepFor(milliSecondLeftToSleep);
            }
        }
    }

    /**
     * the method return the gui.
     * @return - the gui.
     */
    public GUI getGui() {
        return gui;
    }
}
