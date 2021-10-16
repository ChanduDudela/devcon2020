package leetcode;

import java.util.ArrayList;
import java.util.List;

//https://leetcode.com/problems/word-search-ii/discuss/59780/Java-15ms-Easiest-Solution-(100.00)
public class WordSearch_2_Hard {

    public List<String> findWords(char[][] board, String[] words) {
        List<String> res = new ArrayList<>();

        // build trie with the given dictionary
        TrieNode root = buildTrie(words);

        // Recurse for each char in the board
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs(board, root, i, j, res);
            }
        }

        return res;
    }

    // DFS
    private void dfs(char[][] board, TrieNode root, int i, int j, List<String> res) {

        char ch = board[i][j];

        //base condition. For each recursion, If visited or Trie doesn't have this char, return
        if (ch == '#' || root.links[ch - 'a'] == null || i < 0 || j < 0 || i > board.length - 1
            || j > board[0].length - 1) {
            return;
        }
        TrieNode node = root.links[ch - 'a'];

        if (node.word != null) { // found a word! Add it to the result array
            res.add(node.word);
            node.word = null;   // make it null to de-duplicate
        }

        // visited (only for this recursion)
        board[i][j] = '#';

        dfs(board, node, i, j + 1, res);
        dfs(board, node, i - 1, j, res);
        dfs(board, node, i, j - 1, res);
        dfs(board, node, i + 1, j, res);

        // set it back to original value for other char recursions.
        board[i][j] = ch;
    }

    // build trie with the given dictionary
    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode node = root;

            for (int i = 0; i < word.length(); i++) {
                char ch = word.charAt(i);
                if (node.links[ch - 'a'] == null) {
                    node.links[ch - 'a'] = new TrieNode();
                }
                node = node.links[ch - 'a'];
            }
            node.word = word;
        }

        return root;
    }

    // Trie Data structure
    static class TrieNode {
        TrieNode[] links;
        String word;

        public TrieNode() {
            links = new TrieNode[26];
        }
    }
}
