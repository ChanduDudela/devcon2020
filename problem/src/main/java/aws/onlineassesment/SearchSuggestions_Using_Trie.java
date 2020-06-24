package aws.onlineassesment;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

//https://leetcode.com/problems/search-suggestions-system/
//https://leetcode.com/problems/search-suggestions-system/discuss/436151/JavaPython-3-Simple-Trie-and-Binary-Search-codes-w-comment-and-brief-analysis.
public class SearchSuggestions_Using_Trie {
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

        Arrays.sort(products);

        for(String product: products){
            Trie rootCopy = root;
            char[] charArray = product.toCharArray();

            for (char ch : charArray) {

                if (rootCopy.children[ch - 'a'] == null) {
                    rootCopy.children[ch - 'a'] = new Trie();
                }
                rootCopy = rootCopy.children[ch - 'a'];

                if (rootCopy.suggestions.size() < 3) {
                    rootCopy.suggestions.offer(product);
                }
            }
        }

        List<List<String>> res = new ArrayList<>();

        for(char ch : searchWord.toCharArray()) {
            if(root != null){
                root = root.children[ch - 'a'];
            }
            res.add(root == null ? Collections.emptyList() : root.suggestions);
        }

        return res;
    }
}
