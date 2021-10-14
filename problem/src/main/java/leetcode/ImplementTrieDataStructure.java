package leetcode;

public class ImplementTrieDataStructure {

    /** Initialize your data structure here. */
    private TrieNode root;

    public ImplementTrieDataStructure() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode node = root;

        for(int i =0; i< word.length(); i++){
            char ch = word.charAt(i);

            if(!node.containsKey(ch)){
                node.putNode(ch, new TrieNode());
            }
            node = node.getNode(ch);
        }
        node.setEnd();
    }

    private TrieNode getPrefixNode(String word){
        TrieNode node = root;

        for(int i =0; i< word.length(); i++){
            char ch = word.charAt(i);

            if(node.containsKey(ch)){
                node = node.getNode(ch);
            } else{
                return null;
            }
        }
        return node;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode node = getPrefixNode(word);

        return node != null && node.isEnd();
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode node = getPrefixNode(prefix);

        return node != null;
    }

    // A TrieNode data structure
    static class TrieNode{
        private TrieNode[] links;
        private boolean isEnd = false;

        public TrieNode(){
            links = new TrieNode[26]; //Initialize the size with English lower case characters size
        }

        public boolean containsKey(char ch){
            return links[ch - 'a'] != null;
        }

        public TrieNode getNode(char ch){
            return links[ch - 'a'];
        }

        public void putNode(char ch, TrieNode node) {
            links[ch - 'a'] = node;
        }

        public void setEnd(){
            isEnd = true;
        }

        public boolean isEnd(){
            return isEnd;
        }
    }
}
