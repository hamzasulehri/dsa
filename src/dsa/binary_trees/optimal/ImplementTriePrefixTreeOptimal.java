package dsa.binary_trees.optimal;

/*
Problem: Implement Trie (Prefix Tree)
Approach: Optimal
True trie structure: each TrieNode holds a children map (or array) and
an isEnd flag. insert/search/startsWith walk character by character
down the tree, giving cost proportional only to word/prefix length L,
independent of how many words are stored.
Time Complexity: insert O(L), search O(L), startsWith O(L)
Space Complexity: O(total characters inserted)
*/
import java.util.HashMap;
import java.util.Map;

public class ImplementTriePrefixTreeOptimal {

    static class TrieNode {
        Map<Character, TrieNode> children = new HashMap<>();
        boolean isEnd = false;
    }

    private final TrieNode root;

    public ImplementTriePrefixTreeOptimal() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for (char c : word.toCharArray()) {
            node = node.children.computeIfAbsent(c, k -> new TrieNode());
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
        TrieNode node = traverse(word);
        return node != null && node.isEnd;
    }

    public boolean startsWith(String prefix) {
        return traverse(prefix) != null;
    }

    // walks down the trie following each character of the given string
    private TrieNode traverse(String s) {
        TrieNode node = root;
        for (char c : s.toCharArray()) {
            node = node.children.get(c);
            if (node == null) return null;
        }
        return node;
    }

    public static void main(String[] args) {
        ImplementTriePrefixTreeOptimal trie = new ImplementTriePrefixTreeOptimal();
        trie.insert("apple");
        System.out.println(trie.search("apple"));   // expected: true
        System.out.println(trie.search("app"));     // expected: false
        System.out.println(trie.startsWith("app")); // expected: true
    }
}
