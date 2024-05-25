package ronnyRuntime.game.entities.highscore;

import java.io.*;

/**
 * De hoogst behaalde score van het spel.
 */
public class Highscore {

    private int points;
    private String name;

    private static final String FILE_PATH = "src/main/resources/highscore/highscore.txt";

    public Highscore () {
        String currentHighscoreString = readFromFile();
        String[] highscoreCombined = currentHighscoreString.split(";");
        this.name = highscoreCombined[0];
        this.points = Integer.parseInt(highscoreCombined[1]);
    }

    /**
     * Geeft het aantal punten van de huidige highscore terug.
     * @return aantal punten.
     */
    public int getHighscorePoints() {
        return this.points;
    }

    /**
     * Geeft de naam van de houder van de huidige highscore terug.
     * @return naam
     */
    public String getHighscoreName () {
        return this.name;
    }

    /**
     * Neemt naam en aantal punten en vormt de tot een string
     * in correct formaat voor een highscore en roept de functie
     * aan die deze wegschrijft.
     * @param name Naam
     * @param points Aantal punten
     */
    public void setHighscore(String name, int points) {
        this.name = name;
        this.points = points;
        String highscoreString = name + ";" + points;
        writeToFile(highscoreString);
    }

    /**
     * Schrijft de highscore weg in de txt-file.
     * @param highscore Highscorestring
     */
    private static void writeToFile (String highscore) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(Highscore.FILE_PATH))) {
            writer.write(highscore);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Lees de .txt file uit en geeft de regel die erin staat terug.
     * @return String die de highscore van dit moment bevat.
     */
    private static String readFromFile () {
        String line = null;
        try(BufferedReader reader = new BufferedReader(new FileReader(Highscore.FILE_PATH))) {
            line = reader.readLine();
            if (line == null) {
                line = "Test;3";
            }
        } catch (IOException e) {
            line = "NO_HIGHSCORE;0";
            e.printStackTrace();
        }
        return line;
    }
}