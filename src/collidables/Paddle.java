/* Roni Oded. ID-318798782. */
package collidables;

/* import classes from packages. */
import shapes.Line;
import shapes.Point;
import shapes.Rectangle;
import shapes.Velocity;
import animations.GameLevel;
import sprites.Ball;
import sprites.Sprite;
import biuoop.DrawSurface;
import biuoop.KeyboardSensor;
import java.util.ArrayList;

/**
 * class Paddle - the player in the game, rectangle that is controlled by the arrow keys and move according
 * to the player key presses.
 * implements Sprite, Collidable.
 */
public class Paddle implements Sprite, Collidable {

    /* declaring the fields in the class. */
    private KeyboardSensor keyboard;
    private Block blockRect;
    private java.util.List<Ball> ballsList;
    private int paddleSpeed;
    private double width;
    private static final int WIDTH = 800;
    private static final int HEIGHT_BLOCKS = 20;
    private static final int FIVE = 5;
    private static final int ONE_ANGLE = 300;
    private static final int TWO_ANGLE = 330;
    private static final int THREE_ANGLE = 2;
    private static final int FOUR_ANGLE = 30;
    private static final int FIVE_ANGLE = 60;
    private static final int INITIALIZED_INDEX = 6;

    /**
     * constructor in order to build an instance of the class.
     * @param upperLeft - the upper left point of the rectangle.
     * @param width - the width of the rectangle.
     * @param height - the height of the rectangle.
     * @param color - the color of the paddle.
     * @param keyboard - keyboard sensor instance.
     * @param paddleSpeed - the speed to set to the paddle.
     */
    public Paddle(KeyboardSensor keyboard, Point upperLeft, double width, double height, java.awt.Color color,
                  int paddleSpeed) {

        /* initializing the fields. */
        this.blockRect = new Block(new Rectangle(upperLeft, width, height), color);
        this.keyboard = keyboard;
        this.ballsList = new ArrayList<>();
        this.width = this.blockRect.getCollisionRectangle().getWidth();
        this.paddleSpeed = paddleSpeed;
    }

    /**
     * the method add the ball to the ball list.
     * @param ball - the ball to add to the list.
     */
    public void addBallToPaddle(Ball ball) {
        this.ballsList.add(ball);
    }

    /**
     * moving the paddle left.
     */
    public void moveLeft() {

        /* upper left is the upper left point of the paddle. */
        Point upperLeft = this.blockRect.getCollisionRectangle().getUpperLeft();

        /* newX is after one move. */
        double newX = upperLeft.getX() - paddleSpeed;

        /* if the newX is low then the height of the block, newX is now the height of the block. */
        if (newX < HEIGHT_BLOCKS) {
            newX = HEIGHT_BLOCKS;
        }

        /* setting a new upperLeft point to the rectangle of the paddle. */
        this.blockRect.getCollisionRectangle().setUpperLeft(new Point(newX, upperLeft.getY()));
        getBallOutOfPaddle();
    }

    /**
     * moving the paddle right.
     */
    public void moveRight() {

        /* upper left is the upper left point of the paddle. */
        Point upperLeft = this.blockRect.getCollisionRectangle().getUpperLeft();

        /* newX is after one move. */
        double newX = upperLeft.getX() + paddleSpeed;

        /* if the newX is moving out of the frame, newX is now edge of the frame. */
        if (newX > (WIDTH - this.width - HEIGHT_BLOCKS)) {
            newX = (WIDTH - this.width - HEIGHT_BLOCKS);
        }

        /* setting a new upperLeft point to the rectangle of the paddle. */
        this.blockRect.getCollisionRectangle().setUpperLeft(new Point(newX, upperLeft.getY()));
        getBallOutOfPaddle();
    }

    /**
     * the method notify the sprite that time has passed.
     */
    @Override
    public void timePassed() {

        /* if the keyboard key that pressed is the left key, move left is being run. */
        if (keyboard.isPressed(KeyboardSensor.LEFT_KEY)) {
            this.moveLeft();
        }

        /* if the keyboard key that pressed is the right key, move right is being run. */
        if (keyboard.isPressed(KeyboardSensor.RIGHT_KEY)) {
            this.moveRight();
        }
    }

    /**
     * draw the paddle on the draw surface.
     * @param d - drawSurface to draw on.
     */
    @Override
    public void drawOn(DrawSurface d) {
        this.blockRect.drawOn(d);
    }

    /**
     * the method return the collision rectangle of the paddle.
     * @return the collision rectangle of the paddle.
     */
    @Override
    public Rectangle getCollisionRectangle() {
        return this.blockRect.getCollisionRectangle();
    }

    /**
     * the method gets a collisionPoint and currentVelocity and return the new velocity expected after the hit.
     * @param hitter - the ball that hit the collidable.
     * @param collisionPoint - the point where the object that we collided with at - have velocity.
     * @param currentVelocity - the current velocity.
     * @return the new velocity expected after the hit.
     */
    @Override
    public Velocity hit(Ball hitter, Point collisionPoint, Velocity currentVelocity) {

        /* fifthPaddle is an array with the five lines the paddle is diverged to. */
        Line[] fifthPaddle = new Line[FIVE];

        /* widthFifthPaddle is the width of every part of the paddle. */
        int widthFifthPaddle = (int) Math.round(blockRect.getCollisionRectangle().getWidth() / FIVE);

        /* start point is the upper left point of the rectangle. */
        Point startPoint = this.blockRect.getCollisionRectangle().getUpperLeft();

        /* end point is the point that the x value is the x + widthFifthPaddle. */
        Point endPoint = new Point(startPoint.getX() + widthFifthPaddle, startPoint.getY());

        /* array of the angles. */
        int[] angles = {ONE_ANGLE, TWO_ANGLE, THREE_ANGLE, FOUR_ANGLE, FIVE_ANGLE};
        int indexCollision = INITIALIZED_INDEX;

        for (int i = 0; i < FIVE; ++i) {

            /* making the line from start and end point. */
            fifthPaddle[i] = new Line(startPoint, endPoint);

            /* start point is now the end point and end point is a new point that the x value is the
             x + widthFifthPaddle. */
            startPoint = endPoint;
            endPoint = new Point(startPoint.getX() + widthFifthPaddle, startPoint.getY());

            /* if the paddle has intersection in the i section, indexCollision is now i. */
            if (fifthPaddle[i].checkInLine(collisionPoint)) {
                indexCollision = i;
                break;
            }
        }

        /* if the index of the collision is 2, it hits in the 3 section so the regular hit is being run. */
        if (indexCollision == THREE_ANGLE) {
            return this.blockRect.hit(hitter, collisionPoint, currentVelocity);
        }

        /* if the index is still in the initialized value, the regular his is being run. */
        if (indexCollision == INITIALIZED_INDEX) {
            return this.blockRect.hit(hitter, collisionPoint, currentVelocity);
        }

        /* return the new velocity with from angle and speed (with pitaguras sentence). */
        return Velocity.fromAngleAndSpeed(angles[indexCollision], Math.sqrt(Math.pow(currentVelocity.getDx(), 2)
                + Math.pow(currentVelocity.getDy(), 2)));
    }

    /**
     * the method add the paddle to the game.
     * @param g - a game to add the sprite to.
     */
    @Override
    public void addToGame(GameLevel g) {

        /* add the paddle to the gamed sprite and collidable lists. */
        g.addSprite(this);
        g.addCollidable(this);
    }


    /**
     * the method take the balls out of the paddle.
     */
    public void getBallOutOfPaddle() {

        /* moving on the balls from ballsList. */
        for (Ball ball : ballsList) {

            /* if the ball is in the paddle i am changing it's y value. */
            if (((ball.getX()) > blockRect.getCollisionRectangle().getUpperLeft().getX())
                    && ((ball.getX()) < blockRect.getCollisionRectangle().getUpperRight().getX())
                    && ((ball.getY()) >= blockRect.getCollisionRectangle().getUpperLeft().getY())
                    && ((ball.getY()) < blockRect.getCollisionRectangle().getDownLeft().getY())) {

                /* if the ball coming from up i am changing it to be as the y value of the up line of the paddle.
                * else, i am changing it to be as the y value of the down line of the paddle  */
                if (((ball.getVelocity().getDx() >= 0) && (ball.getVelocity().getDy() >= 0))
                        || (((ball.getVelocity().getDx() <= 0) && (ball.getVelocity().getDy() >= 0)))) {
                    ball.setCenter(new Point(ball.getX(), blockRect.getCollisionRectangle().getUpperLeft().getY()));
                } else {
                    ball.setCenter(new Point(ball.getX(), blockRect.getCollisionRectangle().getDownLeft().getY()));
                }
            }
        }
    }
}