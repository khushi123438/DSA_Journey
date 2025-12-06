class Solution {
    public int countPartitions(int[] nums) {
        long total = 0;
        for (int x : nums) total += x;

       
        if ((total & 1) == 1) return 0;

        long left = 0;
        int count = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            left += nums[i];
            long right = total - left;

        
            if ((left & 1) == (right & 1)) {
                count++;
            }
        }

        return count;
    }
}