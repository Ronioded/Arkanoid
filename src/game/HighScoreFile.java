/* Roni Oded. ID-318798782. */
package game;

/* import classes from packages. */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author Roni Oded.
 * class highScoreFile - responsible of updating the highscores file and extracting information from it.
 */
public class HighScoreFile {

    /**
     * the method read the line from the highscores file and return it.
     * @return the line from the highscores file.
     */
    public static int readHighScoreFromFile() {
        int highScore = 0;
        // try and catch block.
        try {
            /* reading the line from the highscores file. */
            File highScores = new File(".\\highscores.txt");
            BufferedReader bufferedReader = new BufferedReader(new FileReader(highScores));
            String line = bufferedReader.readLine();
            String[] newLine = line.split("The highest score so far is: ");
            highScore = Integer.parseInt(newLine[1]);
            bufferedReader.close();
        } catch (Exception exception) {
            return 0;
        }
        // return the high score.
        return highScore;
    }

    /**
     * method that update the high score after the game in the highscores file.
     * @param score - the score of the last game.
     */
    public static void updateHighScore(Counter score) {
        File highScores = new File(".\\highscores.txt");
        int highScore = score.getValue();

        /* if the highScores file exit, it compares between the last and high score. */
        if (highScores.exists()) {
            highScore = readHighScoreFromFile();
            /* if the last score is bigger than the highScore, update it to be the highScore. */
            if (score.getValue() > highScore) {
                highScore = score.getValue();
            }
        }

        // try and catch block.
        try {
            //rewriting the high score in the file.
            FileWriter fileWriter = new FileWriter(highScores, false);
            fileWriter.write("The highest score so far is: " + highScore);
            fileWriter.close();
        } catch (Exception exception) {
            System.out.println("IO Exception.");
        }
    }
}
