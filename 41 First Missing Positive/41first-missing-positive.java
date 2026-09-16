class Solution {
    public int firstMissingPositive(int[] nums) {
        int l = nums.length;
        int bigNum = l + 1;
        int missingNum = 1;
        
        
        for (int i = 0; i < l; i++)
            if (nums[i] <= 0)
                nums[i] = bigNum;
        
        
        for (int num : nums) {
            int idx = Math.abs(num) - 1;
            
            
            if (idx < l)
                nums[idx] = Math.abs(nums[idx]) * -1;
        }
        
        
        for (int num : nums) {
            if (num > 0)
                return missingNum;
            
            
            missingNum++;
        }
        
        
        return missingNum;
    }
}