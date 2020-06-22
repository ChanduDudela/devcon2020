package aws.random.questions;

import java.util.Stack;

//https://leetcode.com/problems/min-stack/
class MinStack {

    //main stack to store numbers
    private Stack<Integer> mainStack;

    //stack to main the min number at 0th index and its count at 1st index
    private Stack<int[]> minStack;

    public MinStack() {
        mainStack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int x) {
        mainStack.push(x);

        if(minStack.isEmpty() || x < minStack.peek()[0]){
            minStack.push(new int[]{x, 1});
        } else if (x == minStack.peek()[0]){
            minStack.peek()[1]++;
        }
    }

    public void pop() {
        int x = mainStack.pop();

        if(minStack.peek()[0] == x){
            if(minStack.peek()[1] > 1){
                minStack.peek()[1]--;
            } else{
                minStack.pop();
            }
        }
    }

    public int top() {
        return mainStack.peek();
    }

    public int getMin() {
        return minStack.peek()[0];
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
