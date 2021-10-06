/* Roni Oded. ID-318798782. */
package shapes;

/**
 * @author Roni Oded.
 * class Velocity, specifies the change in position on the x and y axises.
 */
public class Velocity {

    /* declaring the fields in the class. */
    private double dx;
    private double dy;
    public static final int MAX_ANGLE = 360;
    public static final int ZERO = 0;

    /**
     * constructor in order to build the AbstractShapes.Velocity.
     * @param dx value of x axis.
     * @param dy value of y axis.
     */
    public Velocity(double dx, double dy) {

        /* initializing the fields of this instance of the class. */
        this.dx = dx;
        this.dy = dy;
    }

    /**
     * the method return the dx value of velocity.
     * @return the dx value of velocity.
     */
    public double getDx() {
        return this.dx;
    }

    /**
     * the method return the dy value of velocity.
     * @return the dy value of velocity.
     */
    public double getDy() {
        return this.dy;
    }

    /**
     * the method calculating the dx and dy from angle and speed.
     * @param angle the angle.
     * @param speed the speed.
     * @return new velocity from angle and speed.
     */
    public static Velocity fromAngleAndSpeed(double angle, double speed) {

        /* while the angle is equal or bigger than 360 i'm decreasing 360. */
        while (angle >= MAX_ANGLE) {
            angle -= MAX_ANGLE;
        }

        /* while the angle is smaller than 360 i'm adding 360. */
        while (angle < ZERO) {
            angle += MAX_ANGLE;
        }

        /* changing the angle to radians. */
        angle = Math.toRadians(angle);

        /* setting the dx and dy from angle and speed. */
        double dx = Math.round(Math.sin(angle) * speed);
        double dy = -1 * Math.round(Math.cos(angle) * speed);

        /* return the AbstractShapes.Velocity from dx and dy. */
        return new Velocity(dx, dy);
    }

    /**
     * the method gets a point (x,y) and return a new point (x+dx, y+dy).
     * @param point a point-(x,y).
     * @return a new point-(x+dx, y+dy).
     */
    public Point applyToPoint(Point point) {
        return new Point(Math.round(point.getX() + this.dx), Math.round(point.getY() + this.dy));
    }

    /**
     * the method change the dx value as the value entered.
     * @param x - the new dx value.
     */
    public void setDx(double x) {
        this.dx = x;
    }

    /**
     * the method change the dy value as the value entered.
     * @param y - the new dy value.
     */
    public void setDy(double y) {
        this.dy = y;
    }
}