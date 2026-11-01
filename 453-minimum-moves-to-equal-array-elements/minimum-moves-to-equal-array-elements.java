class Solution {
    public int minMoves(int[] nums) {
        int n = nums.length;
        int sum = 0;
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++){
            if(nums[i]<min) min=nums[i];
            sum+=nums[i];
        }

        return sum-n*min;


    }
}