package aws.random.questions;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

//https://leetcode.com/problems/design-search-autocomplete-system/
public class SearchAutoCompleteSystem {

    static class Trie {
        Map<Character, Trie> children;
        Map<String, Integer> strToCountMap;

        public Trie(){
            children = new HashMap<>();
            strToCountMap = new HashMap<>();
        }

    }

    Trie root;
    String prefix;

    private void buildTrie(String word, int count) {
        Trie currNode = root;

        for(int i =0; i< word.length(); i++) {
            char ch = word.charAt(i);
            if(currNode.children.get(ch) == null){
                Trie nextNode = new Trie();
                currNode.children.put(ch, nextNode);
            }

            currNode = currNode.children.get(ch);

            currNode.strToCountMap.put(word, currNode.strToCountMap.getOrDefault(word, 0) + count);
        }
    }

    public SearchAutoCompleteSystem(String[] sentences, int[] times) {
        prefix = "";

        root = new Trie();
        for(int i =0; i < sentences.length; i++){
            buildTrie(sentences[i], times[i]);
        }
    }

    public List<String> input(char c) {
        if(c == '#') {
            buildTrie(prefix, 1);
            prefix = "";
            return new ArrayList<String>();
        }

        prefix = prefix + c;

        Trie currNode = root;

        for(int i=0; i < prefix.length(); i++){
            char ch = prefix.charAt(i);
            Trie node = currNode.children.get(ch);

            if(node == null){
                return new ArrayList<String>();
            }

            currNode = node;
        }

        Queue<Map.Entry<String, Integer>> pq = new PriorityQueue<>((a, b) ->
            a.getValue().equals(b.getValue()) ? a.getKey().compareTo(b.getKey()) : b.getValue() - a.getValue());

        pq.addAll(currNode.strToCountMap.entrySet());
        int k = 3;
        List<String> res = new ArrayList<>();

        while(k > 0 && !pq.isEmpty()) {
            res.add(pq.poll().getKey());
            k--;
        }

        return res;
    }
}
