package Game;

import java.util.Random;

public enum GameWordsNature {
    MELA, ALBERO, PERA, FRAGOLA, TAMERICE, AGRIFOGLIO, AGLAIA, GELSO, IPERICO, MELOGRANO, GIRASOLE, DELFINIO, SUSINO, CERRO, NESPOLO;


    /**
     * Pick a random value of the GameWords enum.
     *
     * @return a random word of game's vocabulary.
     */
    public static GameWordsNature getRandomWord() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

}
