/* Roni Oded. ID-318798782. */
package game;

/* import classes from packages. */
import shapes.Line;
import shapes.Point;
import collidables.Collidable;
import collidables.CollisionInfo;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Roni Oded.
 * class GameEnvironment - collection of things ball can collide with.
 */
public class GameEnvironment {

    /* declaring the fields in the class. */
    private List<Collidable> gameCollidable;
    public static final int ZERO = 0;

    /**
     * constructor in order to build instance of the class.
     */
    public GameEnvironment() {

        /* declaring new list. */
        this.gameCollidable = new ArrayList<>();
    }

    /**
     * the method add c to the list of things ball can collide with.
     * @param c - a collidable the ball can collide with.
     */
    public void addCollidable(Collidable c) {
        this.gameCollidable.add(c);
    }

    /**
     * the method remove c from the list of things ball can collide with.
     * @param c - a collidable the ball can collide with.
     */
    public void removeCollidable(Collidable c) {
        this.gameCollidable.remove(c);
    }

    /**
     * if the object will not collide with any of the collidables return null, else return the information about
     * the closest collision that is going to occur.
     * @param trajectory - a line to check collision with.
     * @return the information about the closest collision that is going to occur,if there is no collision return null.
     */
    public CollisionInfo getClosestCollision(Line trajectory) {

        /* declaring new List. */
        List<CollisionInfo> list = new ArrayList<>();

        /* Make a copy of the gameCollidable before iterating over them. */
        List<Collidable> environment = new ArrayList<>(this.gameCollidable);

        /* moving on the objects that collides. */
        for (Collidable collidable : environment) {

            /* collision point is the closest intersection point of the collidable shape and the trajectory. */
            Point collisionPoint = trajectory.closestIntersectionToStartOfLine(collidable.getCollisionRectangle());

            /* if the collision point is not null i am adding it to the list. */
            if (collisionPoint != null) {
                list.add(new CollisionInfo(collisionPoint, collidable));
            }
        }

        /* if the list size is 0,there is no intersections- return null. else, looking for the closest intersection. */
        if (list.size() == ZERO) {
            return null;
        } else {

            /* closestPoint is the first point in the list. */
            CollisionInfo closestPoint = list.get(ZERO);

            /* moving the points in the list. */
            for (CollisionInfo checkCollisionInfo : list) {

                /* if the distance between the point to the point start is low than the distance from closest point to
                 * the point start i am changing between them. */
                if (checkCollisionInfo.collisionPoint().distance(trajectory.start())
                        <= closestPoint.collisionPoint().distance(trajectory.start())) {
                    closestPoint = checkCollisionInfo;
                }
            }

            /* return the closestPoint. */
            return closestPoint;
        }
    }
}