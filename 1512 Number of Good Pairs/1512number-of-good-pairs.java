class Solution {
    public int numIdenticalPairs(int[] nums) {
        int count = 0;
        int ans[]= new int[101];
        for(int a: nums){
            count+= ans[a]++;
        }
        return count;
    }
}