import java.util.*;

class Solution {
    public int maxTwoEvents(int[][] events) {

      
        Arrays.sort(events, (a, b) -> a[0] - b[0]);

        int n = events.length;

      
        int[] suffixMax = new int[n];
        suffixMax[n - 1] = events[n - 1][2];

        for (int i = n - 2; i >= 0; i--) {
            suffixMax[i] = Math.max(suffixMax[i + 1], events[i][2]);
        }

        
        int[] starts = new int[n];
        for (int i = 0; i < n; i++) {
            starts[i] = events[i][0];
        }

        int ans = 0;

        for (int i = 0; i < n; i++) {
            int end = events[i][1];
            int value = events[i][2];

          
            int idx = upperBound(starts, end);

            if (idx < n) {
                ans = Math.max(ans, value + suffixMax[idx]);
            } else {
                ans = Math.max(ans, value);
            }
        }

        return ans;
    }

  
    private int upperBound(int[] arr, int target) {
        int low = 0, high = arr.length;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (arr[mid] <= target) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
}
