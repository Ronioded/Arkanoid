/* Roni Oded. ID-318798782. */
package tasks;

/**
 * class QuitTask - responsible of closing the game.
 * implements Task.
 */
public class QuitTask implements Task {

    /**
     * the method run the task after a selection in the menu.
     */
    @Override
    public void run() {
        //close the game.
        System.exit(1);
    }
}
