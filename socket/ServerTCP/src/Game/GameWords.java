package Game;

import java.util.Random;

public enum GameWords {
    MELA, ALBERO, PERA, FRAGOLA;


    /**
     * Pick a random value of the GameWords enum.
     *
     * @return a random word of game's vocabulary.
     */
    public static GameWords getRandomWord() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

}
