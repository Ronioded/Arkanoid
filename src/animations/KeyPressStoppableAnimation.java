/* Roni Oded. ID-318798782. */
package animations;

/* import classes from packages. */
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;

/**
 * @author Roni Oded.
 * class KeyPressStoppableAnimation- handle the animation that waits to a key pressed.
 * implements Animation.
 */
public class KeyPressStoppableAnimation implements Animation {

    /* fields of an instance of the class. */
    private KeyboardSensor keyboardSensor;
    private String key;
    private Animation animation;
    private boolean stop;
    private boolean isAlreadyPressed;

    /**
     * constructor in order to create a new instance of the class.
     * @param sensor - KeyboardSensor to recognize keyboard keys.
     * @param key - the key that waiting to be pressed.
     * @param animation - the animation that waits to a key pressed.
     */
    public KeyPressStoppableAnimation(KeyboardSensor sensor, String key, Animation animation) {

        /* initializing the fields. */
        this.keyboardSensor = sensor;
        this.key = key;
        this.animation = animation;
        this.stop = false;
        this.isAlreadyPressed = true;
    }

    /**
     * the method handle the fame specific logic.
     * @param d - the draw surface that the animation is on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {

        /* running one frame of the animation. */
        this.animation.doOneFrame(d);

        /* if the key is being pressed, and if the key was not already pressed, the running is stopped.
        * else, isAlreadyPressed is false */
        if ((this.keyboardSensor.isPressed(this.key))) {
            if (!(this.isAlreadyPressed)) {
                this.stop = true;
            }
        } else {
            this.isAlreadyPressed = false;
        }
    }

    /**
     * the method handle the stop conditions of the animations.
     * @return true if the animation should stop, else return false.
     */
    @Override
    public boolean shouldStop() {
        return stop;
    }

    /**
     * the method changing stop to the value.
     * @param value - the value stop should change to.
     */
    public void setStop(boolean value) {
        this.stop = value;
    }
}
