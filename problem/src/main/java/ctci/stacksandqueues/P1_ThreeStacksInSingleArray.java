package ctci.stacksandqueues;

public class P1_ThreeStacksInSingleArray {
    int[] values;
    int[] stacksSize;
    int eachStackCapacity;
    int numOfStacks = 3;

    public P1_ThreeStacksInSingleArray(int eachStackCapacity) {
        this.eachStackCapacity = eachStackCapacity;
        values = new int[eachStackCapacity * numOfStacks];
        stacksSize = new int[numOfStacks];
    }

    public void push(int stackNumber, int value) {
        if (isFull(stackNumber)) {
            return;
        }
        int idx = getStackTopIndex(stackNumber);
        values[idx] = value;
        stacksSize[stackNumber]++;
    }

    public int pop(int stackNumber) {
        if (isEmpty(stackNumber)) {
            return -1;
        }
        int idx = getStackTopIndex(stackNumber);
        int value = values[idx];
        values[idx] = 0;
        stacksSize[stackNumber]--;
        return value;
    }

    public int peek(int stackNumber) {
        if (isEmpty(stackNumber)) {
            return -1;
        }
        int idx = getStackTopIndex(stackNumber);
        return values[idx];
    }

    private boolean isEmpty(int stackNumber) {
        return stacksSize[stackNumber] == 0;
    }

    private boolean isFull(int stackNumber) {
        return stacksSize[stackNumber] == eachStackCapacity;
    }

    private int getStackTopIndex(int stackNumber) {
        int offset = eachStackCapacity * stackNumber;
        return offset + stacksSize[stackNumber] - 1;
    }
}
