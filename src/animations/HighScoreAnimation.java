/* Roni Oded. ID-318798782. */
package animations;

/* import classes from packages. */
import biuoop.DrawSurface;
import java.awt.Color;
import java.awt.Polygon;
import java.util.ArrayList;
import java.util.List;
import collidables.Block;
import game.HighScoreFile;
import shapes.Point;
import shapes.Rectangle;

/**
 * @author Roni Oded.
 * class HighScoreAnimation - responsible of the animation when showing the high score of the players in the game.
 * implements Animation.
 */
public class HighScoreAnimation implements Animation {

    /**
     * the method handle the frame specific logic.
     * @param d - the draw surface that the game is on.
     */
    @Override
    public void doOneFrame(DrawSurface d) {
        // fill the background.
        d.setColor(Color.CYAN);
        d.fillRectangle(0, 0, 800, 600);
        // colors of the blocks.
        java.awt.Color[] colorsList = {Color.MAGENTA, Color.RED, Color.YELLOW, Color.ORANGE, Color.PINK, Color.GREEN};
        List<Block> listOfBlocks = new ArrayList<>();
        int width = 65;
        int numBlocks = 6;
        // add blocks on.
        for (int j = 0; j < numBlocks; j++) {
            listOfBlocks.add(new Block(new Rectangle(new Point(width, 120 + j * 30), 100, 30),
                    colorsList[j]));
                width += 100;
        }
        // draw all the blocks.
        for (Block b : listOfBlocks) {
            b.drawOn(d);
        }
        // print the highest score.
        d.setColor(Color.BLACK);
        d.drawText(90, 145, "The", 30);
        d.drawText(166, 175, "highest", 30);
        d.drawText(278, 205, "score", 30);
        d.drawText(398, 235, "so", 30);
        d.drawText(495, 265, "far", 30);
        d.drawText(602, 295, "is:", 30);
        d.setColor(Color.BLUE);
        d.drawText(670, 345, String.valueOf(HighScoreFile.readHighScoreFromFile()), 50);
        d.setColor(Color.BLACK);
        d.drawText(600, 585, "press space to return menu.", 15);
        // print the first part in the medal.
        d.setColor(Color.RED);
        d.fillRectangle(100, 300, 150, 150);
        d.setColor(Color.YELLOW);
        d.fillRectangle(130, 300, 20, 150);
        d.fillRectangle(200, 300, 20, 150);
        d.setColor(Color.CYAN);
        int[] xValues = {100, 150, 100};
        int[] yValues = {400, 450, 450};
        d.fillPolygon(new Polygon(xValues, yValues, 3));
        int[] xValues1 = {250, 200, 250};
        int[] yValues1 = {400, 450, 450};
        d.fillPolygon(new Polygon(xValues1, yValues1, 3));
        // print the second part in the medal.
        d.setColor(Color.ORANGE);
        d.fillCircle(175, 500, 60);
        // print the star in the medal.
        d.setColor(Color.YELLOW);
        int[] xValues2 = {188, 162, 155, 195};
        int[] yValues2 = {480, 480, 510, 510};
        d.fillPolygon(new Polygon(xValues2, yValues2, 4));
        int[] xValues3 = {175, 162, 188};
        int[] yValues3 = {450, 480, 480};
        d.fillPolygon(new Polygon(xValues3, yValues3, 3));
        int[] xValues4 = {132, 162, 155};
        int[] yValues4 = {482, 480, 510};
        d.fillPolygon(new Polygon(xValues4, yValues4, 3));
        int[] xValues5 = {188, 218, 195};
        int[] yValues5 = {480, 482, 510};
        d.fillPolygon(new Polygon(xValues5, yValues5, 3));
        int[] xValues6 = {155, 145, 175};
        int[] yValues6 = {510, 545, 520};
        d.fillPolygon(new Polygon(xValues6, yValues6, 3));
        int[] xValues7 = {175, 205, 195};
        int[] yValues7 = {520, 545, 510};
        d.fillPolygon(new Polygon(xValues7, yValues7, 3));
        int[] xValues8 = {175, 155, 195};
        int[] yValues8 = {520, 510, 510};
        d.fillPolygon(new Polygon(xValues8, yValues8, 3));
        // number 1! :)
        d.setColor(Color.darkGray);
        d.drawText(160, 518, "1", 50);
    }

    /**
     * the method handle the stop conditions of the animations.
     * (always return false cause the KeyPressStoppableAnimation handle the stop conditions.)
     * @return true if the animation should stop, else return false.
     */
    @Override
    public boolean shouldStop() {
        return false;
    }
}
