/* Roni Oded. ID-318798782. */
package shapes;

/**
 * @author Roni Oded.
 * class Line, connects two points. a line have start, middle and end points, also the length of the
 * line. lines may intersect with other lines.
 */
public class Line {

    /* declaring the fields in the class. */
    private Point start;
    private Point middle;
    private Point end;
    private Point sortedStart;
    private Point sortedEnd;
    private double length;
    public static final int ZERO = 0;
    public static final int TEN = 10;
    public static final int NEG_TWO = -2;


    /**
     * constructor in order to build the line. gets the points in the start and in the end and calculate
     * the middle point and the length of the line.
     * @param start the point in the start of the line.
     * @param end the point in the end of the line.
     */
    public Line(Point start, Point end) {

        /* initializing the fields of this instance of the class. */
        this.start = start;
        this.end = end;
        this.middle = new Point(((end.getX() + start.getX()) / 2), ((end.getY() + start.getY()) / 2));
        this.length = this.start.distance(this.end);
        this.sortedStart = start;
        this.sortedEnd = end;

        /* if the x value of start point is bigger than the x value of end point (or the x values are equal but the y
        value of start point is bigger than the y value of end point) i'm setting the sorted start and end. */
        if ((start.getX() > end.getX() || ((start.getX() == end.getX()) && (start.getY() > end.getY())))) {
            this.sortedStart = end;
            this.sortedEnd = start;
        }
    }

    /**
     * constructor in order to build the AbstractShapes.Line. gets the x and y values of 2 points and calculate the
     * start, middle and end points and the length of the line.
     * @param x1 the x value of the first point.
     * @param y1 the y value of the first point.
     * @param x2 the x value of the second point.
     * @param y2 the y value of the second point.
     */
    public Line(double x1, double y1, double x2, double y2) {

        /* initializing the fields of this instance of the class. */
        this.start = new Point(x1, y1);
        this.end = new Point(x2, y2);
        this.middle = new Point(((x1 + x2) / 2), ((y1 + y2) / 2));
        this.length = this.start.distance(this.end);
        this.sortedStart = this.start;
        this.sortedEnd = this.end;

        /* if the x value of start point is bigger than the x value of end point (or the x values are equal but the y
        value of start point is bigger than the y value of end point) i'm setting the sorted start and end. */
        if ((start.getX() > end.getX() || ((start.getX() == end.getX()) && (start.getY() > end.getY())))) {
            this.sortedStart = this.end;
            this.sortedEnd = this.start;
        }
    }

    /**
     * the method return the length of the line.
     * @return the length of the line.
     */
    public double length() {
        return this.length;
    }

    /**
     * the method return the middle point of the line.
     * @return the middle point of the line.
     */
    public Point middle() {
        return this.middle;
    }

    /**
     * the method return the start point of the line.
     * @return the start point of the line.
     */
    public Point start() {
        return this.start;
    }

    /**
     * the method return the end point of the line.
     * @return the end point of the line.
     */
    public Point end() {
        return this.end;
    }

    /**
     * the method check if this line and line other is intersecting.
     * @param other another line in order to check if this line and other line are intersecting.
     * @return true if the lines intersect. else, return false.
     */
    public boolean isIntersecting(Line other) {

        /* if other is null, false is returned */
        if (other == null) {
            return false;
        }

        /* if the method intersectionWith not return null, true is returned else false. */
        return (this.intersectionWith(other) != null);
    }

    /**
     * the method check if this line and line other is equal.
     * @param other another line in order to check if this line and other line are equal.
     * @return true is the lines are equal. else, return false.
     */
    public boolean equals(Line other) {

        /* if other is null, false is returned */
        if (other == null) {
            return false;
        }

        return ((this.sortedStart.equals(other.sortedStart)) && (this.sortedEnd.equals(other.sortedEnd)));
    }

    /**
     * the method calculate the intersection point of the lines if they are intersecting.
     * @param other another line in order to calculate the intersection point between this line and other line if
     *              they are intersecting.
     * @return the intersection point if the lines intersect. else, return null.
     */
    public Point intersectionWith(Line other) {

        /* if other is null, null is returned */
        if (other == null) {
            return null;
        }

        /* thisIncline-incline of the line this, otherIncline-incline of the line other, if it isn't defines it is 0. */
        double thisIncline = this.calculateIncline();
        double otherIncline = other.calculateIncline();

        /* the function findIntersection return the intersection point. if there is no intersection, return null.*/
        Point intersectionPoint = findIntersection(other, thisIncline, otherIncline);

        /* if the intersection point is in both lines other and this, the point is returned. else, null returned */
        if (this.checkInLine(intersectionPoint) && other.checkInLine(intersectionPoint)) {
            return intersectionPoint;
        } else {
            return null;
        }
    }

    /**
     * the method is finding the intersection point between this line and other line.
     * @param other another line in order to calculate the intersection point between this line and other line.
     * @param thisIncline the incline of this line.
     * @param otherIncline the incline of the line other.
     * @return the intersection point if the lines intersect. else, return null.
     */
    private Point findIntersection(Line other, double thisIncline, double otherIncline) {

        /* if the start point of other is equal to the end point in this, this point is the intersection point. */
        if (other.sortedStart.equals(this.sortedEnd)) {
            return other.start();
        }

        /* if the start point of this is equal to the end point in other, this point is the intersection point. */
        if (this.sortedStart.equals(other.sortedEnd)) {
            return this.start();
        }

        /* x and y is the values of the intersection point. initialized to 0.*/
        double x = 0;
        double y = 0;

        /*
         * calculating the values of x and y with some scenarios of the line.
         * 1. if the x values of the both lines start and end points are equal, both lines are parallel to the y axis
         * so the lines are foreign (in that case there is no intersection) or the lines have one intersection and
         * they are continuing each other (in that case we already returned the start or end point above) or they have
         * some intersection point so in that case it counts there is no intersection - so null is returns in all cases.
         * 2. if in only one line the x values of start and end are equal, the x value of the intersection is the
         * x value of the line and the y is the value when we are putting x in the other line equation.
         * 3. if this is not any of the cases above, the x value is being calculated by the lines equations
         * and the y is being calculated by putting the x value in this line equation (that is no matter which line).
         */
        if  ((this.sortedStart.getX() == this.sortedEnd.getX())
                && (other.sortedStart.getX() == other.sortedEnd.getX())) {

            /* if also the y values of start and end in this or other line is equal, one of the lines are just a point
             and that intersection point is being returned. else, return null cause there is no intersection point. */
            if (this.sortedStart.getY() == this.sortedEnd.getY()) {
                return this.sortedStart;
            } else if (other.sortedStart.getY() == other.sortedEnd.getY()) {
                return other.sortedStart;
            } else {
                return null;
            }
        } else if (this.sortedStart.getX() == this.sortedEnd.getX()) {
            x = this.sortedStart.getX();
            y = otherIncline * x - otherIncline * other.sortedStart.getX() + other.sortedStart.getY();
        } else if (other.sortedStart.getX() == other.sortedEnd.getX()) {
            x = other.sortedStart.getX();
            y = thisIncline * x - thisIncline * this.sortedStart.getX() + this.sortedStart.getY();
        } else {
            x = ((thisIncline * this.sortedStart.getX()) - this.sortedStart.getY()
                    - (otherIncline * other.sortedStart.getX())
                    + other.sortedStart.getY()) / (thisIncline - otherIncline);
            y = thisIncline * x - thisIncline * this.sortedStart.getX() + this.sortedStart.getY();
        }

        /* a new point with the x and y values is returned.  */
        return new Point(x, y);
    }


    /**
     * the method check if the checkPoint is in the line or not (between the start and end points).
     * @param checkPoint the point to check if it is in the line or not.
     * @return true if checkPoint is in the line, false if not.
     */
    public boolean checkInLine(Point checkPoint) {

        /* if checkPoint is null, false returned. */
        if (checkPoint == null) {
            return false;
        }
        /* if the x values of checkPoint is before the x value of start or after the x value of end, false returned. */
        if ((checkPoint.getX() < this.sortedStart.getX()) || (checkPoint.getX() > this.sortedEnd.getX())) {
            return false;
        }

        /* minY is the low value of y in the line, maxY is the high value of y in the line. initialized to 0.*/
        double minY = 0;
        double maxY = 0;

        /*
         * if the y value of start is bigger than the y value of end, maxY is the y value of start and minY is the y
         *  value of end. else, the values are the opposite.
         */
        if (this.sortedStart.getY() > this.sortedEnd.getY()) {
            maxY = this.sortedStart.getY();
            minY = this.sortedEnd.getY();
        } else {
            minY = this.sortedStart.getY();
            maxY = this.sortedEnd.getY();
        }

        /* if the y value of checkPoint is in the range of minY and maxY, true returned. */
        if ((checkPoint.getY() > minY) && (checkPoint.getY() < maxY)) {
            return true;
        }

        /* if the y value of checkPoint is is equal to minY or maxY, true returned. else, return false. */
        double epsilon = Math.pow(TEN, NEG_TWO);
        return ((Math.abs(checkPoint.getY() - minY) <= epsilon) || (Math.abs(checkPoint.getY() - maxY) <= epsilon));
    }

    /**
     * the method is calculate the incline of the line, if it is not define return 0.
     * @return the incline of the line.
     */
    private double calculateIncline() {

        /* if the x values of start and end are not equal the incline is being calculated, else return 0. */
        if (this.start().getX() != this.end().getX()) {
            return (this.start.getY() - this.end.getY()) / (this.start.getX() - this.end.getX());
        } else {
            return ZERO;
        }
    }

    /**
     * the method check if this line intersect with the rectangle. if not - return null.
     * else, return the closest intersection point to the start of the line.
     * @param rect - an instance of the class AbstractShapes.Rectangle.
     * @return the closest intersection point to the start of the line if the line and the rectangle intersect.
     *         else, return null.
     */
    public Point closestIntersectionToStartOfLine(Rectangle rect) {

        /* intersectionPointsList is the list of the intersection points between the line and rectangle. */
        java.util.List<Point> intersectionPointsList = rect.intersectionPoints(this);

        /* if the list size is 0, there is no intersection points between the line and rectangle so null returned. */
        if (intersectionPointsList.size() == ZERO) {
            return null;
        }

        /* closestPoint is the first AbstractShapes.Point in the list. */
        Point closestPoint = intersectionPointsList.get(ZERO);

        /* moving on the points in the list. */
        for (Point point : intersectionPointsList) {

            /* if the distance between the point to the point start is low than the distance from closest point to the
            * point start i am changing between them. */
            if (point.distance(this.start()) < closestPoint.distance(this.start())) {
                closestPoint = point;
            }
        }

        /* return closestPoint. */
        return closestPoint;
    }
}
