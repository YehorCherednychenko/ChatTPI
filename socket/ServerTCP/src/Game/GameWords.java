package Game;

import java.util.Random;

public enum GameWords {
    MELA, ALBERO, PERA, FRAGOLA, TAMERICE, AGRIFOGLIO, AGLAIA, GELSO, IPERICO, MELOGRANO,
    GIRASOLE, DELFINIO, SUSINO, CERRO, NESPOLO, CALCIO, PALLAMANO, PALLACANESTRO, PALLAVOLO, TENNIS, BASEBALL,
    BADMINTON, HOCKEY, BOWLING, PALLANUOTO, PIZZA, TORTA, PASTA, CARBONARA, SPAGHETTI, POMODORO, CETRIOLO, MAIS, AVOCADO, RAVIOLI,
    INSALATA, NANTOVA, NAPOLEONE, NOCCIOLE, ACQUA, COLA, FANTA, SPRITE, CAFFE;


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
