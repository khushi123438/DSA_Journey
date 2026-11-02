class Solution {
    public int minMoves2(int[] nums) {
        int n = nums.length;
        Arrays.sort(nums);
        int m = nums[n/2];
        long moves=0;
        for(int num:nums)
        moves+=Math.abs(num-m);

        return (int)moves;
    }
}