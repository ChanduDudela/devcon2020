package ctci.stacksandqueues;

public class MyStack<T> {
    // a -> b -> c -> null
    //top
    private static class StackNode<T> {
        T value;
        StackNode<T> next;

        public StackNode(T value) {
            this.value = value;
        }
    }

    StackNode<T> top;

    T pop() {
        if (top == null) {
            return null;
        }

        T val = top.value;
        top = top.next;
        return val;
    }

    T peek() {
        return top != null ? top.value : null;
    }

    void push(T val) {
        StackNode<T> newNode = new StackNode<>(val);
        if (top != null) {
            newNode.next = top;
        }
        top = newNode;
    }

    boolean isEmpty() {
        return top == null;
    }
}
