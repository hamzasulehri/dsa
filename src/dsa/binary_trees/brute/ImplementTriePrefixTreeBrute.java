package dsa.binary_trees.brute;

/*
Problem: Implement Trie (Prefix Tree)
Approach: Brute Force
Store all inserted words in a plain array/list of strings. search()
checks for exact match by scanning every word; startsWith() scans
every word checking String.startsWith().
Time Complexity: insert O(1) amortized, search/startsWith O(n*L)
                  where n = number of words, L = word length
Space Complexity: O(n*L)
*/
import java.util.ArrayList;
import java.util.List;

public class ImplementTriePrefixTreeBrute {

    private final List<String> words;

    public ImplementTriePrefixTreeBrute() {
        words = new ArrayList<>();
    }

    public void insert(String word) {
        words.add(word);
    }

    public boolean search(String word) {
        // scan every stored word for an exact match
        for (String w : words) {
            if (w.equals(word)) return true;
        }
        return false;
    }

    public boolean startsWith(String prefix) {
        // scan every stored word checking the prefix
        for (String w : words) {
            if (w.startsWith(prefix)) return true;
        }
        return false;
    }

    public static void main(String[] args) {
        ImplementTriePrefixTreeBrute trie = new ImplementTriePrefixTreeBrute();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // expected: true
        System.out.println(trie.search("app"));     // expected: false
        System.out.println(trie.startsWith("app")); // expected: true
    }
}
