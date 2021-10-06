/* Roni Oded. ID-318798782. */
package animations;

/**
 * @author Roni Oded.
 * Interface Menu, enable creating some menu options
 * @param <T> - generic variable in order to specify the return type from the menu.
 * extends Animation
 */
public interface Menu<T> extends Animation {

    /**
     * the method add a selection to the menu.
     * @param key - a key to press for this selection.
     * @param messageToPrint - a 'title' to this selection.
     * @param returnTask - the return value that this selection should return.
     */
    void addSelection(String key, String messageToPrint, T returnTask);

    /**
     * the method return the status from the menu- return the selection that was made from the menu.
     * @return the selection that was made from the menu.
     */
    T getStatus();
}
