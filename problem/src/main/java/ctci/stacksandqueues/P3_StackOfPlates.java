package ctci.stacksandqueues;

import ctci.stacksandqueues.MyQueue.StackNode;
import java.util.EmptyStackException;

// my own implementation
public class P3_StackOfPlates {
    int MAX_STACKS = 10;
    StackNode<Integer>[] stackArr = new StackNode[MAX_STACKS];
    int[] stackSize = new int[MAX_STACKS];
    int capacity;
    int stackPointer = 0;

    public P3_StackOfPlates(int capacity) {
        this.capacity = capacity;
    }

    public void push (int value) {
        if (stackSize[stackPointer] >= capacity) {
            if (stackPointer + 1 == MAX_STACKS) {
                throw new ArrayIndexOutOfBoundsException();
            }
            stackPointer++;
        }

        StackNode<Integer> node = new StackNode<>(value);
        StackNode<Integer> currNode = stackArr[stackPointer];
        node.next = currNode;
        stackArr[stackPointer] = node;
        stackSize[stackPointer]++;
    }

    public int pop () {
        if (stackSize[stackPointer] <= 0) {
            if (stackPointer == 0){
                throw new EmptyStackException();
            }
            stackPointer--;
        }
        StackNode<Integer> currNode = stackArr[stackPointer];
        int value = currNode.value;
        currNode = currNode.next;
        stackArr[stackPointer] = currNode;
        stackSize[stackPointer]--;
        return value;
    }

    public int popAt (int index) {
        if (index < 0 || index > MAX_STACKS -1 || stackSize[index] == 0) {
            throw new EmptyStackException();
        }

        StackNode<Integer> currNode = stackArr[index];
        int value = currNode.value;
        currNode = currNode.next;
        stackArr[index] = currNode;
        stackSize[index]--;
        return value;
    }
}

