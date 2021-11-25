package ctci.recursionanddynamicprogramming;

import java.util.HashSet;
import java.util.Set;

public class P9_GenerateValidParans {
    Set<String> getValidParenthesis(int n) {
        HashSet<String> resultSet = new HashSet<>();
        return getValidParenthesis(n, resultSet);
    }

    Set<String> getValidParenthesis(int n, HashSet<String> resultSet) {
        if (n == 0) {
            resultSet.add("");
            return resultSet;
        }

        Set<String> subset = getValidParenthesis(n-1, resultSet);
        for (String s: subset) {
            //add a new pair () at the beginning
            resultSet.add("()" + s);

            for (int i = 0; i < s.length(); i++) {
                // add a new pair () after each open parenthesis
                if(s.charAt(i) == '(') {
                    String newStr = insertAt(s, i);
                    resultSet.add(newStr);
                }
            }
        }
        return resultSet;
    }

    String insertAt(String s, int i) {
        return s.substring(0, i+1) + "()" + s.substring(i+1);
    }
}
