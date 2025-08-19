class Solution {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num : nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {4,1,2,1,2};
        Solution sol = new Solution();
        System.out.println(sol.singleNumber(arr)); 
    }
}
