import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] nextGreater = new int[n];
        Stack<Integer> s = new Stack<>();

        
        Arrays.fill(nextGreater, -1);

        
        for (int i = 2 * n - 1; i >= 0; i--) {
            int index = i % n; 
            while (!s.isEmpty() && nums[s.peek()] <= nums[index]) {
                s.pop();

            }

            if (i < n) {
                if (!s.isEmpty()) {
                    nextGreater[index] = nums[s.peek()];
                }
            }

         
            s.push(index);
        }

        return nextGreater;
    }
}
