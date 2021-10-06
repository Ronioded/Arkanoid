/* Roni Oded. ID-318798782. */
package shapes;

/* import classes in order to use lists. */
import java.util.ArrayList;

/**
 * @author Roni Oded.
 * class Rectangle, have points of the rectagle, width and height and can return a list of intersections
 * points.
 */
public class Rectangle {

    /* fields of the instances in the class. */
    private Point upperLeft;
    private Point upperRight;
    private Point downLeft;
    private Point downRight;
    private Line upLine;
    private Line downLine;
    private Line rightLine;
    private Line leftLine;
    private double width;
    private double height;

    /**
     * constructor in order to build the AbstractShapes.Rectangle.
     * @param upperLeft - an upper left point of the rectangle.
     * @param width  - the width of the rectangle.
     * @param height - the height of the rectangle.
     */
    public Rectangle(Point upperLeft, double width, double height) {

        /* initializing the fields of this instance of the class. */
        this.upperLeft = upperLeft;
        this.height = height;
        this.width = width;

        /* setting the other points of the rectangle. */
        this.upperRight = new Point(this.getUpperLeft().getX() + width, this.getUpperLeft().getY());
        this.downLeft = new Point(this.getUpperLeft().getX(), this.getUpperLeft().getY() + height);
        this.downRight = new Point(this.getUpperLeft().getX() + width, this.getUpperLeft().getY() + height);

        /* setting the lines of the rectangle. */
        this.upLine = new Line(upperLeft, this.upperRight);
        this.downLine = new Line(this.downLeft, this.downRight);
        this.rightLine = new Line(this.downRight, this.upperRight);
        this.leftLine = new Line(this.downLeft, this.upperLeft);
    }

    /**
     * the method change the upperLeft point of the rectangle and the other points according to it.
     * @param uLeft - the new upperLeft point.
     */
    public void setUpperLeft(Point uLeft) {

        this.upperLeft = uLeft;

        /* setting the other points of the rectangle. */
        this.upperRight = new Point(this.getUpperLeft().getX() + width, this.getUpperLeft().getY());
        this.downLeft = new Point(this.getUpperLeft().getX(), this.getUpperLeft().getY() + height);
        this.downRight = new Point(this.getUpperLeft().getX() + width, this.getUpperLeft().getY() + height);

        /* setting the lines of the rectangle. */
        this.upLine = new Line(upperLeft, this.upperRight);
        this.downLine = new Line(this.downLeft, this.downRight);
        this.rightLine = new Line(this.downRight, this.upperRight);
        this.leftLine = new Line(this.downLeft, this.upperLeft);
    }

    /**
     * the method return the a list of intersections points with the line if there is. if there is no intersection it
     * return an empty list.
     * @param line - a line in order to check intersection with.
     * @return - a list of intersections points with the line if there is. else, return empty list.
     */
    public java.util.List<Point> intersectionPoints(Line line) {

        /* declaring new list. */
        java.util.List<Point> list = new ArrayList<>();

        /* checking if the line have intersection with the up line. */
        if (line.intersectionWith(this.upLine) != null) {
            list.add(new Point(Math.round(line.intersectionWith(this.upLine).getX()),
                    Math.round(line.intersectionWith(this.upLine).getY())));
        }

        /* checking if the line have intersection with the down line. */
        if (line.intersectionWith(this.downLine) != null) {
            list.add(new Point(Math.round(line.intersectionWith(this.downLine).getX()),
                    Math.round(line.intersectionWith(this.downLine).getY())));
        }

        /* checking if the line have intersection with the left line. */
        if (line.intersectionWith(this.leftLine) != null) {
            list.add(new Point(Math.round(line.intersectionWith(this.leftLine).getX()),
                    Math.round(line.intersectionWith(this.leftLine).getY())));
        }

        /* checking if the line have intersection with the right line. */
        if (line.intersectionWith(this.rightLine) != null) {
            list.add(new Point(Math.round(line.intersectionWith(this.rightLine).getX()),
                    Math.round(line.intersectionWith(this.rightLine).getY())));
        }

        /* return the list. */
        return list;
    }

    /**
     * the method return the width of the rectangle.
     * @return the width of the rectangle.
     */
    public double getWidth() {
        return this.width;
    }

    /**
     * the method return the height of the rectangle.
     * @return the height of the rectangle.
     */
    public double getHeight() {
        return this.height;
    }

    /**
     * the method return the upper left point of the rectangle.
     * @return the upper left point of the rectangle.
     */
    public Point getUpperLeft() {
        return this.upperLeft;
    }

    /**
     * the method return the down left point of the rectangle.
     * @return the down left point of the rectangle.
     */
    public Point getDownLeft() {
        return this.downLeft;
    }

    /**
     * the method return the upper right point of the rectangle.
     * @return the upper right point of the rectangle.
     */
    public Point getUpperRight() {
        return this.upperRight;
    }

    /**
     * the method return the down right point of the rectangle.
     * @return the down right point of the rectangle.
     */
    public Point getDownRight() {
        return this.downRight;
    }


    /**
     * the method return the up line of the rectangle.
     * @return the up line of the rectangle.
     */
    public Line getUpLine() {
        return upLine;
    }

    /**
     * the method return the down line of the rectangle.
     * @return the down line of the rectangle.
     */
    public Line getDownLine() {
        return downLine;
    }

    /**
     * the method return the left line of the rectangle.
     * @return the left line of the rectangle.
     */
    public Line getLeftLine() {
        return leftLine;
    }

    /**
     * the method return the right line of the rectangle.
     * @return the right line of the rectangle.
     */
    public Line getRightLine() {
        return rightLine;
    }
}
