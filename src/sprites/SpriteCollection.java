/* Roni Oded. ID-318798782. */
package sprites;

/* import classes from packages. */
import biuoop.DrawSurface;
import java.util.ArrayList;

/**
 * @author Roni Oded.
 * class SpriteCollection, holds a collection list of sprite.
 */
public class SpriteCollection {

    /* declaring the fields in the class. */
    private java.util.List<Sprite> spriteList;

    /**
     * constructor in order to build instance of the class.
     */
    public SpriteCollection() {
        this.spriteList = new ArrayList<>();
    }

    /**
     * the method add s to the list of sprites.
     * @param s - sprite to add to the list.
     */
    public void addSprite(Sprite s) {
        this.spriteList.add(s);
    }

    /**
     * the method remove s from the list of sprites.
     * @param s - sprite to remove from the list.
     */
    public void removeSprite(Sprite s) {
        this.spriteList.remove(s);
    }

    /**
     * the method call timePassed() on all sprites in the list.
     */
    public void notifyAllTimePassed() {

        /* Make a copy of the spriteList before iterating over them. */
        java.util.List<Sprite> sprites = new ArrayList<>(this.spriteList);

        /* moving on all the sprites in the list and notify that time is passed. */
        for (Sprite sprite : sprites) {
            sprite.timePassed();
        }
    }

    /**
     * the method call drawOn(d) on all sprites in the list.
     * @param d - draw surface in order to draw the sprite on.
     */
    public void drawAllOn(DrawSurface d) {

        /* Make a copy of the spriteList before iterating over them. */
        java.util.List<Sprite> sprites = new ArrayList<>(this.spriteList);

        /* moving on all the sprites in the list and drawing them. */
        for (Sprite sprite : sprites) {
            sprite.drawOn(d);
        }
    }
}