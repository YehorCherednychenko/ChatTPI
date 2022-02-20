package Game;

public class GameLogic {

    // ---Game parameters
    String gameString = null;
    StringBuilder gameStringEncoded;
    int gameLife = 9;


    public GameLogic() {
        gameString = GameWords.getRandomWord().name();
        gameStringEncoded = new StringBuilder(gameString.charAt(0) + "_".repeat(gameString.length() - 2) + gameString.charAt(gameString.length() - 1));
    }

    private String guessOfThePlayer(char toVerify) {

        String toVerifyString = Character.toString(toVerify).toUpperCase();

        if(gameString.contains(toVerifyString) && !gameStringEncoded.toString().contains(toVerifyString)) {

            String temp = gameString.replace(toVerifyString, "_");
            for (int i = 0; i < gameString.length(); i++) {

                if(temp.indexOf(i) == '_')
                    gameStringEncoded.setCharAt(i, toVerify);

            }
        }

        else {
            if(!gameStringEncoded.toString().contains(toVerifyString)) {
                lifeLost();
            }
        }

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
}
