package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//https://leetcode.com/problems/group-anagrams/
public class GroupAnagrams {
    public List<List<String>> groupAnagrams(String[] strs) {

        if(strs == null || strs.length == 0){
            return new ArrayList<>();
        }

        Map<String, List<String>> anagramMap = new HashMap<>();

        for(String str: strs) {
            char[] strArr = str.toCharArray();
            Arrays.sort(strArr);
            String sortedStr = String.valueOf(strArr);

            if(!anagramMap.containsKey(sortedStr)){
                anagramMap.put(sortedStr, new ArrayList<>());
            }
            anagramMap.get(sortedStr).add(str);
        }

        return new ArrayList<>(anagramMap.values());
    }
}
