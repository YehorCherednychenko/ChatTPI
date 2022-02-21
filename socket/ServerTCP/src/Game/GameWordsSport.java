package Game;

import java.util.Random;

public enum GameWordsSport {
    CALCIO, PALLAMANO, PALLACANESTRO, PALLAVOLO, TENNIS, BASEBALL,
    BADMINTON, HOCKEY, BOWLING, PALLANUOTO;


    /**
     * Pick a random value of the GameWordsSport enum.
     *
     * @return a random word of game's vocabulary.
     */
    public static GameWordsSport getRandomWord() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

}
