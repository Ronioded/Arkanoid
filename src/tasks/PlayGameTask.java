/* Roni Oded. ID-318798782. */
package tasks;

/* import classes from packages. */
import animations.AnimationRunner;
import biuoop.KeyboardSensor;
import game.GameFlow;
import levels.LevelOne;
import levels.LevelTwo;
import levels.LevelFour;
import levels.LevelThree;
import levels.LevelInformation;
import java.util.ArrayList;
import java.util.List;

/**
 * class PlayGameTask- responsible og playing the game.
 * implements Task.
 */
public class PlayGameTask implements Task {
    /* fields in the class. */
    private AnimationRunner runner;
    private String[] args;
    private KeyboardSensor keyboard;

    /**
     * constructor in order to build instance of the class.
     * @param runner - the animation runner.
     * @param args - command line arguments.
     * @param keyboard - the keyboard sensor.
     */
    public PlayGameTask(AnimationRunner runner, String[] args, KeyboardSensor keyboard) {
        /* initializing the fields of this instance of the class. */
        this.runner = runner;
        this.args = args;
        this.keyboard = keyboard;
    }

    /**
     * the method run the task after a selection in the menu.
     */
    @Override
    public void run() {
        /* declaring new list and initializing it with the levels with the method createLevelsList. */
        List<LevelInformation> levelsList = createLevelsList(args);

        /* create a new instance of GameFlow and then run the levels. */
        GameFlow game = new GameFlow(runner, keyboard);
        game.runLevels(levelsList);
    }

    /**
     * a method that create the levels list from the argument in command line.
     * @param args - command line arguments.
     * @return a list with the levels from args.
     */
    public static List<LevelInformation> createLevelsList(String[] args) {
        List<LevelInformation> levelsList = new ArrayList<>();

        /* creating instances of the 4 levels. */
        LevelOne levelOne = new LevelOne();
        LevelTwo levelTwo = new LevelTwo();
        LevelThree levelThree = new LevelThree();
        LevelFour levelFour = new LevelFour();

        /* moving the string in args */
        for (String levels : args) {

            /* adding the levels by the order it is in args. */
            switch (levels) {
                case "1":
                    levelsList.add(levelOne);
                    break;
                case "2":
                    levelsList.add(levelTwo);
                    break;
                case "3":
                    levelsList.add(levelThree);
                    break;
                case "4":
                    levelsList.add(levelFour);
                    break;
                default:
                    break;
            }
        }

        /* if no argument were input a regular 4 levels is being added to the list. */
        if (levelsList.isEmpty()) {
            levelsList.add(levelOne);
            levelsList.add(levelTwo);
            levelsList.add(levelThree);
            levelsList.add(levelFour);
        }

        return levelsList;
    }
}
