class Solution {
    public long maxSubarraySum(int[] nums, int k) {
         HashMap<Integer, Long> map = new HashMap<>();
        long INF = (long)1e18;

     
        map.put(0, 0L);

        long prefix = 0;
        long ans = -INF;

        for (int i = 0; i < nums.length; i++) {
            prefix += nums[i];
            int r = (i + 1) % k;

          
            if (map.containsKey(r)) {
                long prevMinPrefix = map.get(r);
                ans = Math.max(ans, prefix - prevMinPrefix);
            }

          
            map.put(r, Math.min(map.getOrDefault(r, INF), prefix));
        }

        return ans;
    }
}