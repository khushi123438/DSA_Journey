class Solution {
    public int jump(int[] nums) {
        int total=0;

        int dest = nums.length-1;
        int cover=0;
        int last=0;

        if(nums.length==1) return 0;

        for(int i=0;i<dest;i++){
            cover=Math.max(cover, i+nums[i]);

            if(i==last){
                last=cover;
                total++;
            

            if(cover>=dest){
                return total;
            }

            }
        }


        return total;
    }
}