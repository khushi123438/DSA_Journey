import java.util.*;

class Solution {
    public int minOperations(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        stack.push(0); 
        int operations = 0;

        for (int num : nums) {
           
            while (!stack.isEmpty() && stack.peek() > num) {
                stack.pop();
            }

          
            if (stack.peek() < num) {
                operations++;
                stack.push(num);
            }
            
        }

        return operations;
    }
}
