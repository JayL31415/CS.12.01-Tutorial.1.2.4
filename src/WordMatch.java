public class WordMatch {
    private String secret;

    public WordMatch(String secret) {
        this.secret = secret;
    }

    public int scoreGuess(String guess) {
        if (guess.isEmpty()) {
            throw new IllegalArgumentException("Your guess cannot be an empty String!");
        }
        if (guess.length() > secret.length()) {
            throw new IllegalArgumentException("Your guess cannot exceed the number of characters in the Secret word");
        }

        int count = 0;
        int index = 0;


        while ((index = secret.indexOf(guess, index)) != -1) {
            count++;
            index++;
        }


        return count * (guess.length() * guess.length());
    }

    public String findBetterGuess(String guess1, String guess2) {
        int score1 = scoreGuess(guess1);
        int score2 = scoreGuess(guess2);


        if (score1 >= score2) {
            return guess1;
        } else {
            return guess2;
        }
    }
}