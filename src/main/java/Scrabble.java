import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;


public class Scrabble {
    private String word;
    private Character[] douLetter;
    private Character[] triLetter;
    private Boolean isDouble, isTriple;
    public HashMap<Character, Integer> values = new HashMap<>();

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
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            score += values.get(c);
        }
        score = addDoubleScore(score);
        score = addTripleScore(score);
        score = addWordScore(score);
        return score;
}
    private int addWordScore(int score){
        return score *= (isTriple != null && isTriple.booleanValue() ? 3 : (isDouble != null && isDouble.booleanValue() ? 2 : 1));
    }
    private int addDoubleScore(int score) {
        this.douLetter = douLetter == null ? new Character[0] : douLetter;
        for (Character doubleLetter : douLetter) {
            if (word.indexOf(doubleLetter) != -1) {
                int doubleLetterValue = values.get(doubleLetter);
                score += doubleLetterValue;
            }
        }
        return score;
    }
    private int addTripleScore(int score) {
        this.triLetter = triLetter == null ? new Character[0] : triLetter;
        for (Character tripleLetter : triLetter) {
            if (word.indexOf(tripleLetter) != -1) {
                    int tripleLetterValue = values.get(tripleLetter);
                    score += tripleLetterValue * 2;
                }
            }
        return score;
        }
    }





