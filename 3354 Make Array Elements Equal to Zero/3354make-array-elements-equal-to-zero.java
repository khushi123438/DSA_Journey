class Solution {
    public int countValidSelections(int[] nums) {
        int n = nums.length;
        int total = 0;
        for (int x : nums) {
            total += x;
        }

        int valid = 0;
        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
              
                if (leftSum * 2 == total) {
                    valid += 2;
                } else if (Math.abs(leftSum * 2 - total) == 1) {
                    valid += 1;
                }
            }
            leftSum += nums[i];
        }
        return valid;
    }
}