package blind.list;

import java.util.Stack;

public class ValidParantheses {
    static final char[][] validParans = {{'{', '}'}, {'[', ']'}, {'(', ')'}};

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        char[] charArray = s.toCharArray();

        for (char c : charArray) {
            for (char[] parans : validParans) {
                if (c == parans[0]) {
                    stack.push(c);
                    break;
                } else if (c == parans[1] && !stack.isEmpty() && stack.peek() != parans[0]) {
                    return false;
                }
            }
        }

        return true;
    }
}
