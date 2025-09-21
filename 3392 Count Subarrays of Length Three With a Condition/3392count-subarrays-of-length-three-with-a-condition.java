class Solution {
    public int countSubarrays(int[] nums) {
        int n = nums.length;
        int ans = 0;
        
        for (int i = 1; i <= n-2; i++) {
            int a = nums[i - 1];
            int b = nums[i];
            int c = nums[i + 1];

           
            if ((a + c) * 2 == b) {
                ans++;
            }
        }

        return ans;
    }
}