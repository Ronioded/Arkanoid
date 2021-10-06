/* Roni Oded. ID-318798782. */
package tasks;

/* import classes from packages. */
import animations.AnimationRunner;
import animations.Animation;

/**
 * class ShowHiScoresTask- responsible of showing the high score.
 * implements Task.
 */
public class ShowHiScoresTask implements Task {

    /* fields in the class. */
    private AnimationRunner runner;
    private Animation highScoresAnimation;

    /**
     * constructor in order to build instance of the class.
     * @param runner - the animation runner.
     * @param highScoresAnimation - the high score animation.
     */
    public ShowHiScoresTask(AnimationRunner runner, Animation highScoresAnimation) {
        /* initializing the fields of this instance of the class. */
        this.runner = runner;
        this.highScoresAnimation = highScoresAnimation;
    }

    /**
     * the method run the task after a selection in the menu.
     */
    @Override
    public void run() {
        //run the animation.
        this.runner.run(this.highScoresAnimation);
    }
}