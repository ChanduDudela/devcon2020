package aws.random.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * 1. put the given words in a trie
 * 2. For each word, dfs the trie (traverse characters in the word one by one).
 *      If the trie node of current character represent a word,
 *      then for next character, we again search from the root node of the trie.
 *
 *https://leetcode.com/problems/concatenated-words/discuss/280915/java-41ms-trie-and-dfs-solution-which-beats-97
 */
public class ConcatenatedWords {

    public List<String> findAllConcatenatedWordsInADict(String[] words) {
        Trie root = new Trie();

        for (String word : words) {
            if (word.length() > 0) {
                buildTrie(word, root);
            }
        }

        List<String> res = new ArrayList<>();

        for (String word : words) {
            if (word.length() > 0) {
                if (search(root, word, 0, 0)) {
                    res.add(word);
                }
            }
        }
        return res;
    }

    private boolean search(Trie root, String word, int beginIndex, int num) {
        Trie current = root;

        for (int i = beginIndex; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (current.children[ch - 'a'] == null) {
                return false;
            }
            current = current.children[ch - 'a'];

            if (current.isWord && search(root, word, i + 1, num + 1)) {
                return true;
            }
        }

        return num >= 1 && current.isWord;
    }

    public static class Trie {
        Trie[] children;
        boolean isWord = false;

        public Trie() {
            children = new Trie[26];
        }
    }

    private void buildTrie(String word, Trie root) {
        Trie node = root;

        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);

            if (node.children[ch - 'a'] == null) {
                node.children[ch - 'a'] = new Trie();
            }
            node = node.children[ch - 'a'];
        }
        node.isWord = true;
    }
}
