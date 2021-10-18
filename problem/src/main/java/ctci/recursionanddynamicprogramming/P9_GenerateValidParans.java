package ctci.recursionanddynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class P9_GenerateValidParans {
    Set<String> getValidParenthesis(int n) {
        HashSet<String> cache = new HashSet<>();
        return getValidParenthesis(n, cache);
    }

    Set<String> getValidParenthesis(int n, HashSet<String> cache) {
        if (n == 0) {
            cache.add("");
            return cache;
        }

        Set<String> subset = getValidParenthesis(n-1, cache);
        for (String s: subset) {
            //add a new pair () at the beginning
            cache.add("()" + s);

            for (int i = 0; i < s.length(); i++) {
                // add a new pair () after each open parenthesis
                if(s.charAt(i) == '(') {
                    String newStr = insertAt(s, i);
                    cache.add(newStr);
                }
            }
        }
        return cache;
    }

    String insertAt(String s, int i) {
        return s.substring(0, i+1) + "()" + s.substring(i+1);
    }
}
