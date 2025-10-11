class Solution {
    public long maximumTotalDamage(int[] power) {
         Map<Integer, Integer> freq = new HashMap<>();
        for (int p : power) {
            freq.put(p, freq.getOrDefault(p, 0) + 1);
        }

       
        List<Integer> unique = new ArrayList<>(freq.keySet());
        Collections.sort(unique);
        int n = unique.size();

      
        int[] next = new int[n];
        for (int i = 0; i < n; i++) {
            int target = unique.get(i) + 2;
            int lo = i + 1, hi = n;
            while (lo < hi) {
                int mid = (lo + hi) / 2;
                if (unique.get(mid) > target) {
                    hi = mid;
                } else {
                    lo = mid + 1;
                }
            }
            next[i] = lo;
        }

        
        long[] dp = new long[n + 1];

        for (int i = 0; i < n; i++) {
           
            dp[i + 1] = Math.max(dp[i + 1], dp[i]);
          
            long damage = (long) unique.get(i) * freq.get(unique.get(i));
            int j = next[i];
            dp[j] = Math.max(dp[j], dp[i] + damage);
        }

        return Arrays.stream(dp).max().getAsLong();
    }
}