package Game;

import java.util.Random;

public enum GameWordsDrinks {

    ACQUA, COLA, ARANCIATA, SPRITE, CAFFE, LEMONSODA, SUCCO, CEDRATA, CHINOTTO, GASSOSA, GINGER, ORZATA, SPUMA, TAMARINDO, BIRRA, VINO, COCKTAIL, CAPPUCINO;


    public static GameWordsDrinks getRandomWord() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
