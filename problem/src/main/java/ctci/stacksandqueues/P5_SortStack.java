package ctci.stacksandqueues;

import java.util.Stack;

public class P5_SortStack {

    // See CTCI explanation
    public void sort(Stack<Integer> stack) {
        Stack<Integer> tempStack = new Stack<>();

        while (!stack.empty()) {
            int temp = stack.pop();

            while (!tempStack.empty() && tempStack.peek() > temp) {
                stack.push(tempStack.pop());
            }
            tempStack.push(temp);
        }

        while(!tempStack.empty()) {
            stack.push(tempStack.pop());
        }
    }
}
