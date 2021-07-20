package ctci.stacksandqueues;

import java.util.Stack;

public class P4_QueueViaStacks {
    Stack<Integer> stackNewest = new Stack<>();
    Stack<Integer> stackOldest = new Stack<>();

    public void add(int value) {
        stackNewest.push(value);
    }

    public int remove() {
        transfer();
        return stackOldest.pop();
    }

    public int peek() {
        transfer();
        return stackOldest.peek();
    }

    public boolean isEmpty() {
        return stackNewest.empty();
    }

    private void transfer() {
        if(stackOldest.empty()) {
            while (!stackNewest.empty()) {
                stackOldest.push(stackNewest.pop());
            }
        }
    }
}
