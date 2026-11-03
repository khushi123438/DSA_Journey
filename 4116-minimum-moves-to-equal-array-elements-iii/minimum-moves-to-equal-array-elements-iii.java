class Solution {
    public int minMoves(int[] nums) {
        int mx=Integer.MIN_VALUE;
        for(int num:nums){
            mx=Math.max(mx,num);
        }
        int ans=0;
        for(int x:nums){
            ans+=(mx-x);
        }
        return ans;
    }
}