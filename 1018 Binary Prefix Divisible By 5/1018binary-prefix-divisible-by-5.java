class Solution {
    public List<Boolean> prefixesDivBy5(int[] nums) {
        List<Boolean> ans = new ArrayList<>();
        int current = 0;

        for (int bit : nums) {
            current = (current * 2 + bit) % 5;
            ans.add(current == 0);
        }

        return ans;
    }
}