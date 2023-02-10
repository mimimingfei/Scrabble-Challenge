import java.util.HashMap;
import java.util.Map;

public class Scrabble {
    private String word;
    private Character[] douLetter, triLetter;
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
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            score += values.get(c);
        }
        score *= isTriple != null && isTriple.booleanValue() ? 3 : (isDouble != null && isDouble.booleanValue() ? 2 : 1);
        return score;
    }
}