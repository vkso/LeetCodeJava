import java.util.HashSet;
import java.util.Iterator;

public class StreamChecker {
    HashSet<String> set = new HashSet<>();
    HashSet<Integer> len = new HashSet<>();
    StringBuilder sb = new StringBuilder();

    public StreamChecker(String[] words) {
        for (String word : words) {
            set.add(word);
            len.add(words.length);
        }
    }

    public boolean query(char letter) {
        sb.append(letter);
        for (Integer integer : len) {
            if (sb.length() < integer) {
                continue;
            } else {
                String tail = sb.substring(sb.length() - integer, sb.length());
                if (set.contains(tail)) {
                    return true;
                }
            }
        }
        return false;
    }
}
