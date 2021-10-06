/* Roni Oded. ID-318798782. */
/* import classes from packages. */
import tasks.PlayGameTask;
import tasks.QuitTask;
import animations.AnimationRunner;
import animations.HighScoreAnimation;
import animations.KeyPressStoppableAnimation;
import animations.MenuAnimation;
import biuoop.GUI;
import tasks.Task;
import tasks.ShowHiScoresTask;

/**
 * @author Roni Oded.
 * class ArknoidRun - run the game.
 */
public class ArknoidRun {
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int FRAMES_PER_SECOND = 60;

    /**
     * main method in order to run the game.
     * @param args - command line arguments.
     */
    public static void main(String[] args) {
        /* create new instances of objects in order to run the game. */
        GUI gui = new GUI("Game", WIDTH, HEIGHT);
        AnimationRunner runner = new AnimationRunner(gui, FRAMES_PER_SECOND);
        biuoop.KeyboardSensor keyboard = gui.getKeyboardSensor();
        KeyPressStoppableAnimation stoppableHighScore = new KeyPressStoppableAnimation(keyboard, "space",
                new HighScoreAnimation());
        MenuAnimation<Task> menu = new MenuAnimation<>("Arknoid Menu", keyboard);

        /* add selection to the menu. */
        menu.addSelection("s", "start the game.", new PlayGameTask(runner, args, keyboard));
        menu.addSelection("h", "see high score.", new ShowHiScoresTask(runner, stoppableHighScore));
        menu.addSelection("q", "quit the game.", new QuitTask());

        /* running the menu until the costumer select quit in the menu. */
        while (true) {
            //run the menu.
            runner.run(menu);
            //get the status task after a selection is being made, then run the task.
            Task task = menu.getStatus();
            task.run();
            //setting the stop conditions in the menu and stoppableHighScore animations.
            menu.setStop(false);
            stoppableHighScore.setStop(false);
        }
    }
}
