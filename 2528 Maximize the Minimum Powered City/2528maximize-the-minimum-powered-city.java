import java.util.*;

public class Solution {
    public long maxPower(int[] stations, int r, int k) {
        int n = stations.length;
        long[] power = new long[n];
        long[] prefix = new long[n + 1];

        // Step 1: prefix sum to compute initial power for each city
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stations[i];
        }

        for (int i = 0; i < n; i++) {
            int left = Math.max(0, i - r);
            int right = Math.min(n - 1, i + r);
            power[i] = prefix[right + 1] - prefix[left];
        }

        // Step 2: binary search for the maximum minimum power value
        long low = Arrays.stream(power).min().getAsLong();
        long high = prefix[n] + k;
        long ans = low;

        while (low <= high) {
            long mid = (low + high) / 2;
            if (canReach(power, r, k, mid)) {
                ans = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return ans;
    }

    // Step 3: check if it's possible to make every city have >= target power
    private boolean canReach(long[] power, int r, long k, long target) {
        int n = power.length;
        long[] diff = new long[n + 1];  // difference array for added stations
        long currAdd = 0;
        long remain = k;

        for (int i = 0; i < n; i++) {
            currAdd += diff[i];
            long currPower = power[i] + currAdd;

            if (currPower < target) {
                long need = target - currPower;
                remain -= need;
                if (remain < 0) return false;

                currAdd += need;
                int end = Math.min(n, i + 2 * r + 1);
                diff[end] -= need;
            }
        }
        return true;
    }
}
