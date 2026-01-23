class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        
        int[] freq = new int[k];
        freq[0] = 1;
        int sum=0, count=0;; 
        
        for(int num: nums){
            sum+=num;
            int r = sum%k;
            if(r<0) r+=k;
            count += freq[r];
            freq[r]++;
        }
        return count;
    }
}