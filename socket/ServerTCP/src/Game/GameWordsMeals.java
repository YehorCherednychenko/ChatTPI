package Game;

import java.util.Random;

public enum GameWordsMeals {
    PIZZA, TORTA, PASTA, CARBONARA, SPAGHETTI, POMODORO, CETRIOLO, MAIS, AVOCADO, RAVIOLI, INSALATA, NANTOVA, NAPOLEONE, NOCCIOLE;

    public static GameWordsMeals getRandomWord() {
        Random random = new Random();
        return values()[random.nextInt(values().length)];
    }

}
