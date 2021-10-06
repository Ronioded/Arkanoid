/* Roni Oded. ID-318798782. */
package shapes;

/**
 * @author Roni Oded.
 * class Point, have an x and y values, can calculate the distance between 2 points, and check if
 * 2 points are equal.
 */
public class Point {

    /* declaring the fields in the class. */
    private double x;
    private double y;
    public static final int TEN = 10;
    public static final int NEG_TWO = -2;


    /**
     * constructor in order to build the AbstractShapes.Point.
     * @param x the x value of a point.
     * @param y the y value of a point.
     */
    public Point(double x, double y) {

        /* initializing the fields of this instance of the class. */
        this.x = x;
        this.y = y;
    }

    /**
     * the method calculate the distance between two points.
     * @param other is a point to calculate the distance from this point and other point.
     * @return the distance between this point and the point other.
     */
    public double distance(Point other) {

        /* if other is null, 0 is returned */
        if (other == null) {
            return 0;
        }
        return Math.sqrt((this.x - other.getX()) * (this.x - other.getX()) + ((this.y - other.getY())
                * (this.y - other.getY())));
    }

    /**
     * the method checks if 2 points are equal or not.
     * @param other is a point to calculate if this point and other point are equals.
     * @return true if this point and the other point is equal. else, return false.
     */
    public boolean equals(Point other) {

        /* if other is null, false is returned */
        if (other == null) {
            return false;
        }

        /* checking with epsilon the equality of this point and other point. */
        double epsilon = Math.pow(TEN, NEG_TWO);
        return ((Math.abs(this.x - other.getX()) < epsilon) && (Math.abs(this.y - other.getY()) < epsilon));
    }

    /**
     * the method return the x value of this point.
     * @return the x value of this point.
     */
    public double getX() {
        return this.x;
    }

    /**
     * the method return the y value of this point.
     * @return the y value of this point.
     */
    public double getY() {
        return this.y;
    }
}
