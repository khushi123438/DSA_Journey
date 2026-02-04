import java.util.*;

class Solution {
    public long maxSumTrionic(int[] nums) {
        long INF = (long) -1e17;
        long result = INF, a = INF, b = INF, c = INF;

        long prev = nums[0];

        for (int i = 1; i < nums.length; i++) {
            long curr = nums[i];
            long na = INF, nb = INF, nc = INF;

            if (curr > prev) {
                na = Math.max(a, prev) + curr;
                nc = Math.max(b, c) + curr;
            } else if (curr < prev) {
                nb = Math.max(a, b) + curr;
            }

            a = na;
            b = nb;
            c = nc;

            result = Math.max(result, c);
            prev = curr;
        }

        return result;
    }
}
