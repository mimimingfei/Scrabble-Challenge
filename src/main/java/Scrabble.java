import java.util.HashMap;
import java.util.Map;

public class Scrabble {
    private String word;
    public Scrabble(String word) {
        this.word = word;
    }
    private Map<Character, Integer> values = new HashMap<>();
    {
        char[] letters1 = {'A', 'E', 'I', 'O', 'U', 'L', 'N', 'R', 'S', 'T'};
        for (char letter : letters1) {
            values.put(letter, 1);
        }
        char[] letters3 = {'B', 'C', 'M', 'P'};
        for (char letter : letters3) {
            values.put(letter, 3);
        }
        char[] letters4 = {'F', 'H', 'V', 'W', 'Y'};
        for (char letter : letters4) {
            values.put(letter, 4);
        }
        values.put('D', 2);
        values.put('G', 2);
        values.put('K', 5);
        values.put('J', 8);
        values.put('X', 8);
        values.put('Q', 10);
        values.put('Z', 10);
    }
    public int score() {
        if (word == null || word.isEmpty()) {
            return 0;
        }

        int score = 0;
        for (int i = 0; i < word.length(); i++) {
            Character c = Character.toUpperCase(word.charAt(i));
            Integer value = values.get(c);
            if (value != null) {
                score += value;
            }
        }
        return score;
    }

}
