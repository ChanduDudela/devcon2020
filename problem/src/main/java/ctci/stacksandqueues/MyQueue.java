package ctci.stacksandqueues;

public class MyQueue<T> {
    public static class StackNode<T> {
        T value;
        StackNode<T> next;

        public StackNode(T value) {
            this.value = value;
        }
    }

    StackNode<T> first;
    StackNode<T> last;

    // a -> b -> c
    //fist       last

    // Add to last, remove from first
    private void add(T val) {
        StackNode<T> newNode = new StackNode<>(val);
        if (last != null) {
            last.next = newNode;
        }
        last = newNode;
        if(first == null) {
            first = last;
        }
    }

    private T remove() {
        T val = null;
        if (first != null) {
            val = first.value;
            first = first.next;
        } else {
            last = null;
        }
        return val;
    }

    private boolean isEmpty() {
        return first == null;
    }

    private T peek() {
        return (T) first.value;
    }
}
