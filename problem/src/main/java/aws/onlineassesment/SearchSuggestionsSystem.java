package aws.onlineassesment;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/search-suggestions-system/
//https://leetcode.com/problems/search-suggestions-system/discuss/436151/JavaPython-3-Simple-Trie-and-Binary-Search-codes-w-comment-and-brief-analysis.
public class SearchSuggestionsSystem {
    static class Trie {
        Trie[] children;
        LinkedList<String> suggestions;

        public Trie() {
            this.children = new Trie[26];
            suggestions = new LinkedList<>();
        }
    }

    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        Trie root = new Trie();

        buildTrieWithSuggestions(products, root);

        List<List<String>> res = new ArrayList<>();

        for(char ch : searchWord.toCharArray()) {
            if(root != null){
                root = root.children[ch - 'a'];
            }
            res.add(root == null ? Collections.emptyList() : root.suggestions);
        }

        return res;
    }

    private void buildTrieWithSuggestions(String[] products, Trie root) {
        Trie node = root;

        for (String product : products) {
            for (int i = 0; i < product.length(); i++) {
                char ch = product.charAt(i);

                if (node.children[ch - 'a'] == null) {
                    node.children[ch - 'a'] = new Trie();
                }
                node = node.children[ch - 'a'];

                if (node.suggestions.size() < 3) {
                    node.suggestions.offer(product);
                }
            }
        }
    }
}
