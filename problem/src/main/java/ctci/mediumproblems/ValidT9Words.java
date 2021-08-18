package ctci.mediumproblems;

import java.util.ArrayList;

public class ValidT9Words {
    // A TrieNode data structure

    static class TrieNode {
        private final TrieNode[] children;
        private boolean isEnd = false;

        public TrieNode() {
            children = new TrieNode[26]; //Initialize the size with English lower case characters size
        }

        public boolean containsKey(char ch) {
            return children[ch - 'a'] != null;
        }

        public TrieNode getNode(char ch) {
            return children[ch - 'a'];
        }

        public void setEnd() {
            isEnd = true;
        }

        public boolean isEnd() {
            return isEnd;
        }
    }

    // get letters for a numeric character
    char[] getT9Letters (char c) {
        char[][] t9Letters = {
            null,               null,               {'a', 'b', 'c'},
            {'d', 'e', 'f'},    {'g', 'h', 'i'},    {'w', 'x', 'y', 'z'}
            // this is number to character mapping based on a t9 phone keypad
        };

        int index = Character.getNumericValue(c) - Character.getNumericValue('0');
        return t9Letters[index];
    }

    // main method
    ArrayList<String> getValidT9Words (String number, TrieNode root) {
        ArrayList<String> results = new ArrayList<>();
        getValidWords(number, 0, "", root, results);

        return results;
    }

    void getValidWords(String number, int index, String prefix, TrieNode node, ArrayList<String> results) {
        if (index == number.length()) {
            if (node.isEnd()) {
                results.add(prefix);
            }
            return;
        }

        char c = number.charAt(index);
        char[] letters = getT9Letters(c);

        for (char letter: letters) {
            if (node.containsKey(letter)) {
                getValidWords(number, index + 1, prefix + letter, node.getNode(letter), results);
            }
        }
    }
}
