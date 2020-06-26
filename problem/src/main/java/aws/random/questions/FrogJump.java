package aws.random.questions;

import java.util.HashSet;
import java.util.Set;
import java.util.Stack;

public class FrogJump {

    // Getting TLE in Leet code for a large input
    public boolean canCross(int[] stones) {

        //main 2 stacks. 1 for holding current position and another for possible movements (k-1, k, k+1)
        Stack<Integer> positions = new Stack<>();
        Stack<Integer> jumps = new Stack<>();

        // put stones into a set for faster lookup to check if stone exists
        Set<Integer> stonesSet = new HashSet<>();
        for(int stone : stones){
            stonesSet.add(stone);
        }

        //last stone to reach from the array
        int lastStoneValue = stones[stones.length -1];

        //add 1st stone and the first jump be 0
        positions.add(0);
        jumps.add(0);

        while(!positions.isEmpty()){
            //pop the current position
            int position = positions.pop();
            // and the previous jump value
            int prevJump = jumps.pop();

            //For all possible jumps from this prevJump, check if a stone exists.
            //if exists, then add that stone position to the Stack and also the jump value to
            // other stack
            for(int i  = prevJump -1; i <= prevJump +1; i ++){
                if(i <= 0){
                    continue;
                }

                int nextPosition = position + i;

                //if position is reached, then return true
                if(nextPosition == lastStoneValue){
                    return true;
                } else if (stonesSet.contains(nextPosition)){
                    positions.add(nextPosition);
                    jumps.add(i);
                }
            }
        }
        return false;
    }
}
