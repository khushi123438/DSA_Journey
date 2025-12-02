import java.util.*;

class Solution {
    public int countTrapezoids(int[][] points) {
        final long MOD = 1_000_000_007L;

     
        Map<Integer, Integer> freq = new HashMap<>();
        for (int[] p : points) {
            freq.put(p[1], freq.getOrDefault(p[1], 0) + 1);
        }

      
        List<Integer> ys = new ArrayList<>(freq.keySet());
        Collections.sort(ys);

      
        List<Long> cnt = new ArrayList<>();
        for (int y : ys) {
            long k = freq.get(y);
            if (k >= 2) cnt.add((k * (k - 1) / 2) % MOD);
            else cnt.add(0L);
        }

        long prefix = 0, ans = 0;

     
        for (long c : cnt) {
            ans = (ans + c * prefix) % MOD;
            prefix = (prefix + c) % MOD;
        }

        return (int) ans;
    }
}
