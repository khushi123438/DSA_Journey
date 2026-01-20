class Solution {
    public int[] minBitwiseArray(List<Integer> nums) {
        int n = nums.size();
        int[] ans = new int[n];

        for (int idx = 0; idx < n; idx++) {
            int x = nums.get(idx);

            if (x == 2) {
                ans[idx] = -1;
                continue;
            }

            for (int i = 1; i < 32; i++) {
                if (((x >> i) & 1) == 0) {
                    ans[idx] = x ^ (1 << (i - 1));
                    break;
                }
            }
        }
        return ans;
    }
}
