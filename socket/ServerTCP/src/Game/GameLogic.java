package Game;

public class GameLogic {

    // ---Game parameters
    String gameString = null;
    StringBuilder gameStringEncoded;
    int gameLife = 9;


    public GameLogic() {

        gameString = GameWords.getRandomWord().name();
        gameStringEncoded = new StringBuilder(gameString.charAt(0) + "_".repeat(gameString.length() - 2) + gameString.charAt(gameString.length() - 1));
        System.out.println(gameString + " " + gameStringEncoded);
    }

    private String guessOfThePlayer(char toVerify) {

        String toVerifyString = Character.toString(toVerify);

        if(gameString.contains(toVerifyString)) {

            String temp = gameString.replace(toVerifyString, "_");
            for (int i = 0; i < gameString.length(); i++) {

                if (temp.charAt(i) == '_')
                    gameStringEncoded.setCharAt(i, toVerify);

            }


        }

        else {
            if(!gameStringEncoded.toString().contains(toVerifyString)) {
                System.out.println("UNA VITA PERSA!");
                lifeLost();

            }
        }

        return "Numero vite rimaste: " + gameLife + ". Indovina: " + gameStringEncoded.toString();
    }


    public String getGameStringEncoded() {
        return gameStringEncoded.toString();
    }

    private void lifeLost() {
        gameLife--;
    }

    public boolean stillInGame() {
        return gameLife > 0;
    }

    public String getGameStringEncoded(char toVerify) {
        return guessOfThePlayer(toVerify);
    }

    public String getGameString() {
        return gameString;
    }

    public void resetAll() {
        gameString = GameWords.getRandomWord().name();
        gameStringEncoded = new StringBuilder(gameString.charAt(0) + "_".repeat(gameString.length() - 2) + gameString.charAt(gameString.length() - 1));
        System.out.println(gameString + " " + gameStringEncoded);
        gameLife = 9;

    }
}
