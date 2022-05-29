package blind.list;

//https://leetcode.com/problems/add-and-search-word-data-structure-design/
public class AddAndSearchWord {

    private TrieNode root = new TrieNode();

    public boolean search(String word) {
        return searchWord(word.toCharArray(), 0, root);
    }

    boolean searchWord(char[] arr, int index, TrieNode node) {
        if (arr.length-1 == index) {
            return node.isWord;
        }

        if(arr[index] == '.') {
            for (int i = 0; i < node.children.length; i++) {
                if (node.children[i] != null && searchWord(arr, index +1, node.children[i])) {
                    return true;
                }
            }
        } else {
            return node.children[arr[index] - 'a'] != null
                && searchWord(arr, index + 1, node.children[arr[index] - 'a']);
        }

        return false;
    }

    // Trie Data structure
    static class TrieNode {
        TrieNode[] children;
        boolean isWord;

        public TrieNode() {
            children = new TrieNode[26];
        }
    }
}
