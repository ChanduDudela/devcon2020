package ctci.stacksandqueues;
import ctci.stacksandqueues.MyQueue.StackNode;

public class P2_StackMin {

    //  2 -> 4 -> 3 -> null
    // tail

    //  2 ->  3 -> null
    // min

    StackNode<Integer> tail;
    StackNode<Integer> tailForMinValue;

    public void push(int value) {
        StackNode<Integer> node = new StackNode<>(value);
        if (tail != null) {
            node.next = tail;
        }

        if (tailForMinValue == null) {
            tailForMinValue = new StackNode<>(value);
        } else if (value <= tailForMinValue.value) {
            StackNode<Integer> newMinNode = new StackNode<>(value);
            newMinNode.next = tailForMinValue;
            tailForMinValue = newMinNode;
        }

        tail = node;
    }

    public int pop() {
        if (tail == null) {
            return -1;
        }

        int val = tail.value;
        tail = tail.next;
        if (val == tailForMinValue.value) {
            tailForMinValue = tailForMinValue.next;
        }

        return val;
    }

    public int min() {
        return tailForMinValue.value;
    }
}
