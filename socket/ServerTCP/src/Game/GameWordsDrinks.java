package Game;

import java.util.Random;

public enum GameWordsDrinks {

    ACQUA, COLA, FANTA, SPRITE, CAFFE;


    public static GameWordsDrinks getRandomWord() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }
}
