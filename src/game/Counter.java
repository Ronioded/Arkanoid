/* Roni Oded. ID-318798782. */
package game;

/**
 * @author Roni Oded.
 * class Counter, used for counting things.
 */
public class Counter {
    private int counter;

    /**
     * constructor in order to initialized counter.
     */
    public Counter() {
        this.counter = 0;
    }

    /**
     * constructor in order to initialized counter.
     * @param score - the score to update.
     */
    public Counter(int score) {
        this.counter = score;
    }

    /**
     * the method add number to counter.
     * @param number - number to add to counter.
     */
    public void increase(int number) {
        this.counter += number;
    }

    /**
     * the method decrease number from counter.
     * @param number - number to decrease from counter.
     */
    public void decrease(int number) {
        this.counter -= number;
    }

    /**
     * the method return counter.
     * @return counter.
     */
    public int getValue() {
        return this.counter;
    }
}