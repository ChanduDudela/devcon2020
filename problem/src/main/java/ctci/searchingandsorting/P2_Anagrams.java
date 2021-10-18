package ctci.searchingandsorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class P2_Anagrams {
    String[] sortByAnagrams(String[] strArray) {
        if(strArray == null || strArray.length == 0){
            return strArray;
        }

        Map<String, List<String>> anagramMap = new HashMap<>();

        for (String str: strArray ) {
            String sorted = stringSort(str);
            List<String> anagramList =  anagramMap.getOrDefault(sorted, new ArrayList<>());
            anagramList.add(str);
            anagramMap.put(sorted, anagramList);
        }

        int i = 0;
        for (List<String> anagrams: anagramMap.values()) {
            for (String anagram: anagrams) {
                strArray[i] = anagram;
                i++;
            }
        }

        return strArray;
    }

    private String stringSort(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return String.valueOf(charArray);
    }
}
