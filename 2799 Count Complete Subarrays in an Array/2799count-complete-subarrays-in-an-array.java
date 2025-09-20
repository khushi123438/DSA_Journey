class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int n=nums.length;
        int count = 0;

        Set<Integer> distinct = new HashSet<>();
        for(int num: nums){
            distinct.add(num);
        }

        int total = distinct.size();

        for(int i=0;i<n;i++){
            Set<Integer> seen = new HashSet<>();

            for(int j=i;j<n;j++){
                seen.add(nums[j]);

                if(seen.size()==total)
                count++;
            }
        }
       return count;
    }
}