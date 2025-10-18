class Solution {
    public int maxDistinctElements(int[] nums, int k) {
         Arrays.sort(nums);
        long last = Long.MIN_VALUE;   
        int count = 0;

        for (int x : nums) {
            long left = (long) x - k;
            long right = (long) x + k;

          
            long candidate = Math.max(last + 1, left);
            if (candidate <= right) {
                count++;
                last = candidate;
            }
            
        }

        return count;
    }
}