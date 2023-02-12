import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;


public class Scrabble {
    private String word;
    private Character[] douLetter;
    private Character[] triLetter;
    private Boolean isDouble, isTriple;
    private HashMap<Character, Integer> values = new HashMap<>();

    public Scrabble(String word) {
        this.word = word;
    }

    public Scrabble(String word, Character[] douLetter, Character[] triLetter, boolean isDouble, boolean isTriple) {
        this.word = word;
        this.douLetter = douLetter;
        this.triLetter = triLetter;
        this.isDouble = isDouble;
        this.isTriple = isTriple;
    }



    public int score() {
        String character = "AEIOULNRSTDGBCMPFHVWYKJXQZ";
        int[] value = {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 8, 8, 10, 10};
        for (int i = 0; i < character.length(); i++) {
            values.put(character.charAt(i), value[i]);
        }

        int score = 0;
        this.word = word == null ? "" : word.toUpperCase();
        this.douLetter = douLetter == null ? new Character[0] : douLetter;
        this.triLetter = triLetter == null ? new Character[0] : triLetter;
        //boolean flag checks if a letter has been used for double letter or triple letter score
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            score += values.get(c);
        }
    score = addLetterScore(score);
    score *= (isTriple != null && isTriple.booleanValue() ? 3 : (isDouble != null && isDouble.booleanValue() ? 2 : 1));
        return score;
}
    private int addLetterScore(int score) {
        boolean hasDouble = false;
        boolean hasTriple = false;
        for (Character doubleLetter : douLetter) {
            if (word.indexOf(doubleLetter) != -1) {
                if (!hasDouble) {
                    int doubleLetterValue = values.get(doubleLetter);
                    score += doubleLetterValue;
                    hasDouble = true;
                }
            }
        }
        for (Character tripleLetter : triLetter) {
            if (word.indexOf(tripleLetter) != -1) {
                if (!hasTriple) {
                    int tripleLetterValue = values.get(tripleLetter);
                    score += tripleLetterValue * 2;
                    hasTriple = true;
                }
            }
        }
        return score;
    }
}





