/* Roni Oded. ID-318798782. */
package animations;

/* import classes from packages. */
import game.Counter;
import game.GameEnvironment;
import levels.LevelInformation;
import shapes.Point;
import shapes.Rectangle;
import collidables.Block;
import collidables.Collidable;
import collidables.Paddle;
import listeners.BallRemover;
import listeners.BlockRemover;
import listeners.ScoreTrackingListener;
import shapes.Velocity;
import sprites.Ball;
import sprites.ScoreIndicator;
import sprites.Sprite;
import sprites.SpriteCollection;
import biuoop.DrawSurface;
import java.awt.Color;
import biuoop.KeyboardSensor;

/**
 * @author Roni Oded.
 * class GameLevel- stores all the information about the levels in the game.
 * implements Animation.
 */
public class GameLevel implements Animation {

    /* fields of the instances in the class. */
    private SpriteCollection sprites;
    private GameEnvironment environment;
    private Counter blockCounter;
    private Counter ballsCounter;
    private Counter score;
    private AnimationRunner runner;
    private boolean stop;
    private KeyboardSensor keyboard;
    private LevelInformation levelInfo;
    private static final int WIDTH = 800;
    private static final int HEIGHT = 600;
    private static final int HEIGHT_BLOCKS = 20;
    private static final int ZERO = 0;
    private static final int RADIUS = 7;

    /**
     * constructor in order to create an instance of the class.
     * @param levelInfo - the info of this level.
     * @param score - score counter of the game.
     * @param keyboard - keyboard sensor.
     * @param runner - animation runner in order to run the animations of the game.
     */
    public GameLevel(LevelInformation levelInfo, Counter score, AnimationRunner runner, KeyboardSensor keyboard) {

        /* initializing all the fields of the class. */
        this.sprites = new SpriteCollection();
        this.environment = new GameEnvironment();
        this.blockCounter = new Counter();
        this.ballsCounter = new Counter();
        this.score = score;
        this.stop = true;
        this.runner = runner;
        this.keyboard = keyboard;
        this.levelInfo = levelInfo;
    }

    /**
     * the method add a collidable to the environment.
     * @param c - a collidable to add to the environment.
     */
    public void addCollidable(Collidable c) {
        this.environment.addCollidable(c);
    }

    /**
     * the method add a sprite to the sprite collection.
     * @param s - a sprite to add to the sprite collection.
     */
    public void addSprite(Sprite s) {
        this.sprites.addSprite(s);
    }

    /**
     * the method initialize - initialize a new game - create the blocks, the sprites, balls, collidables and paddle.
     * then add them to the game.
     */
    public void initialize() {

        /* adding the background of the level to the game. */
        this.levelInfo.getBackground().addToGame(this);

        /* generate the boarders blocks */
        generateBoardersBlocks();

        /* generate the blocks */
        generateBlocks();

        /* declaring new score indicator and adding it to the game. */
        ScoreIndicator scoreIndicator = new ScoreIndicator(this.score);
        scoreIndicator.addToGame(this);

        /* calculate the paddle width. */
        int paddleX = (WIDTH - this.levelInfo.paddleWidth()) / 2;

        /* setting the paddle and adding it to the game. */
        Paddle paddle = new Paddle(this.keyboard, new Point(paddleX, HEIGHT - 2 * HEIGHT_BLOCKS),
                this.levelInfo.paddleWidth(), HEIGHT_BLOCKS, Color.BLACK, this.levelInfo.paddleSpeed());
        paddle.addToGame(this);

        /* moving on the velocity from the level info. */
        for (Velocity velocity : this.levelInfo.initialBallVelocities()) {

            /* setting the ball and add it to the game. then increase the balls counter by 1 */
            Ball ball = new Ball(new Point(400, 553), RADIUS, Color.BLACK, this.environment);
            ball.setVelocity(velocity);
            ball.addToGame(this);
            paddle.addBallToPaddle(ball);
            this.ballsCounter.increase(1);
        }
    }

    /**
     * the method handle the frame specific logic.
     * @param d - the draw surface that the game is on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {

        /* drawing the sprites, and then notify time passed(this one frame is over). */
        this.sprites.drawAllOn(d);
        this.sprites.notifyAllTimePassed();

        /* prints level name. */
        d.setColor(Color.BLACK);
        d.drawText(700, 15, levelInfo.levelName(), 15);

        /* if p is being pressed, the game pause. run the animation that wait to receive space in order to continue
         the game.*/
        if (this.keyboard.isPressed("p")) {
            this.runner.run(new KeyPressStoppableAnimation(this.keyboard, KeyboardSensor.SPACE_KEY,
                    new PauseScreen(this)));
        }

        /* if there is no balls or blocks, stop is now true cause the animation should stop. */
        if ((blockCounter.getValue() <= ZERO) || (ballsCounter.getValue() <= ZERO)) {
            this.stop = true;
        }
    }

    /**
     * the method run - run the game, start the animation loop.
     */
    public void run() {
        this.stop = false;

        /* countdown before the level starts. */
        AnimationRunner animationRunner = new AnimationRunner(runner.getGui(), 4);
        animationRunner.run(new CountdownAnimation(2, 3, this.sprites));

        /* running the animation loop */
        this.runner.run(this);
    }

    /**
     * the method handle the stop conditions of the animations.
     * @return true if the animation should stop, else return false.
     */
    @Override
    public boolean shouldStop() {
        return this.stop;
    }

    /**
     * the method remove c from the list of things ball can collide with.
     * @param c - a collidable the ball can collide with.
     */
    public void removeCollidable(Collidable c) {
        this.environment.removeCollidable(c);
    }

    /**
     * the method remove s from the list of sprites.
     * @param s - sprite to remove from the list.
     */
    public void removeSprite(Sprite s) {
        this.sprites.removeSprite(s);
    }

    /**
     * the method return the ball counter.
     * @return - the ball counter0
     */
    public Counter getBallsCounter() {
        return this.ballsCounter;
    }

    /**
     * the method return the block counter.
     * @return - the block counter.
     */
    public Counter getBlockCounter() {
        return this.blockCounter;
    }

    /**
     * the method generate the boarders block and adding to the game.
     */
    public void generateBoardersBlocks() {
        /* ball remover is a listener that responsible of removing balls from the game if they fall from the screen. */
        BallRemover ballRemover = new BallRemover(this, this.ballsCounter);

        /* setting the blocks in the borders */
        Block topBlock = new Block(new Rectangle(new Point(ZERO, HEIGHT_BLOCKS), WIDTH, HEIGHT_BLOCKS), Color.black);
        Block leftBlock = new Block(new Rectangle(new Point(ZERO, HEIGHT_BLOCKS), HEIGHT_BLOCKS, HEIGHT + 5),
                Color.black);
        Block rightBlock = new Block(new Rectangle(new Point(WIDTH - HEIGHT_BLOCKS, HEIGHT_BLOCKS), HEIGHT_BLOCKS,
                HEIGHT + 5), Color.black);
        Block deathBlock = new Block(new Rectangle(new Point(ZERO, HEIGHT + 5), WIDTH, HEIGHT_BLOCKS), Color.black);

        /* adding the boarders blocks to the game. */
        topBlock.addToGame(this);
        leftBlock.addToGame(this);
        rightBlock.addToGame(this);
        deathBlock.addToGame(this);

        /* adding to the death block the listener ballRemover to delete the ball when it hits the death block. */
        deathBlock.addHitListener(ballRemover);
    }

    /**
     * the method generate the blocks.
     */
    public void generateBlocks() {

        /* instances of the listeners. */
        BlockRemover blockRemover = new BlockRemover(this, this.blockCounter);
        ScoreTrackingListener scoreTrackingListener = new ScoreTrackingListener(this.score);

        /* adding blocks to the game. */
        for (Block block : this.levelInfo.blocks()) {
            block.addToGame(this);
            block.addHitListener(blockRemover);
            block.addHitListener(scoreTrackingListener);
            this.blockCounter.increase(1);
        }
    }

    /**
     * the method draw all the sprites on the draw surface.
     * @param d - the draw surface that the game is on.
     */
    public void drawAllSprites(DrawSurface d) {
        this.sprites.drawAllOn(d);
    }

    /**
     * the method return the level information.
     * @return level information.
     */
    public LevelInformation getLevelInfo() {
        return this.levelInfo;
    }
}