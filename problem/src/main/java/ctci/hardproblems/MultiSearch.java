package ctci.hardproblems;

import java.util.ArrayList;
import java.util.HashMap;

public class MultiSearch {
    static class Trie {
        private final TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public TrieNode getRoot() {
            return root;
        }
    }

    static class TrieNode {
        HashMap<Character, TrieNode> children;

        public TrieNode() {
            this.children = new HashMap<>();
        }

        public void insertString(String str) {
            if (str == null) {
                return;
            }

            if (str.length() == 0) {
                children.put('\0', null);
                return;
            }

            char first = str.charAt(0);
            TrieNode child = children.get(first);
            if (child == null) {
                child = new TrieNode();
                children.put(first, child);
            }
            child.insertString(str.substring(1));
        }

        public boolean terminates() {
            return children.containsKey('\0');
        }

        public TrieNode getChild(char c) {
            return children.get(c);
        }
    }

    HashMap<String, ArrayList<Integer>> searchAll (String big, String[] smalls) {
        HashMap<String, ArrayList<Integer>> result = new HashMap<>();

        TrieNode root = constructTrie(smalls).getRoot();

        for (int i = 0; i < big.length(); i++) {
            ArrayList<String> words = getWordsStartingAtIndex(i, big, root);
            prepareResultHashMap(i, words, result);
        }

        return result;
    }

    void prepareResultHashMap(
        int index, ArrayList<String> words, HashMap<String, ArrayList<Integer>> result) {

        for (String word: words) {
            ArrayList<Integer> locations = result.getOrDefault(word, new ArrayList<>());
            locations.add(index);

            result.put(word, locations);
        }
    }

    ArrayList<String> getWordsStartingAtIndex(int index, String big, TrieNode trieRoot) {
        ArrayList<String> strings = new ArrayList<>();

        int idx = index;
        while (idx < big.length()) {
            TrieNode child = trieRoot.getChild(big.charAt(idx));
            if (child == null) {
                break;
            }
            if (child.terminates()) {
                strings.add(big.substring(index, idx));
            }
            idx ++;
        }
        return strings;
    }

    Trie constructTrie (String[] words) {
        Trie trie = new Trie();

        for (String word: words) {
            trie.getRoot().insertString(word);
        }

        return trie;
    }
}
