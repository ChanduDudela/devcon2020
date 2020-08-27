package aws.random.questions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

//https://leetcode.com/problems/alien-dictionary/
class AlienDictionary {

    public String alienOrder(String[] words) {
        if(words==null || words.length==0) return "";

        Map<Character, Integer> inDegreeMap = new HashMap<>();
        Map<Character, Set<Character>> adjacencyMap = new HashMap<>();

        for(String word: words){
            for(char c: word.toCharArray()) {
                inDegreeMap.putIfAbsent(c, 0);
            }
        }

        for(int i=0; i < words.length-1; i++){
            String current = words[i];
            String next = words[i+1];

            if(current.length() > next.length() && current.startsWith(next))
                return "";

            int len = Math.min(current.length(), next.length());

            for(int j=0; j < len; j++){
                char currChar = current.charAt(j);
                char nextChar = next.charAt(j);

                if(currChar != nextChar){
                    Set<Character> set = adjacencyMap.getOrDefault(currChar, new HashSet<>());

                    if(!set.contains(nextChar)){
                        set.add(nextChar);

                        adjacencyMap.put(currChar, set);
                        inDegreeMap.put(nextChar, inDegreeMap.get(nextChar)+1);
                    }
                    break;
                }
            }
        }

        String res = "";

        Queue<Character> que = new LinkedList<>();
        for(char c: inDegreeMap.keySet()){
            if(inDegreeMap.get(c) == 0){
                que.add(c);
            }
        }

        while(!que.isEmpty()){
            char ch =  que.poll();
            res += ch;

            if(adjacencyMap.containsKey(ch)){
                for(char c: adjacencyMap.get(ch)){
                    inDegreeMap.put(c, inDegreeMap.get(c) -1);

                    if(inDegreeMap.get(c) == 0){
                        que.add(c);
                    }
                }
            }
        }

        return inDegreeMap.size() != res.length()? "" : res;
    }
}
