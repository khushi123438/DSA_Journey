import java.util.*;

class Solution {
    TreeMap<Integer, Integer> small = new TreeMap<>();
    TreeMap<Integer, Integer> large = new TreeMap<>();
    long smallSum = 0;
    int smallSize = 0, largeSize = 0;
    int need;

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        if (k == 1) return nums[0];

        need = k - 1;

        for (int i = 1; i <= dist + 1 && i < n; i++) {
            add(large, nums[i]);
            largeSize++;
        }
        rebalance();

        long ans = smallSum;

        for (int i = dist + 2; i < n; i++) {
            int out = nums[i - (dist + 1)];
            int in = nums[i];

            if (small.containsKey(out)) {
                remove(small, out);
                smallSum -= out;
                smallSize--;
            } else {
                remove(large, out);
                largeSize--;
            }

            add(large, in);
            largeSize++;

            rebalance();
            ans = Math.min(ans, smallSum);
        }

        return nums[0] + ans;
    }

    private void rebalance() {
        while (smallSize < need) {
            int x = large.firstKey();
            remove(large, x);
            largeSize--;
            add(small, x);
            smallSize++;
            smallSum += x;
        }

        while (smallSize > need) {
            int x = small.lastKey();
            remove(small, x);
            smallSize--;
            smallSum -= x;
            add(large, x);
            largeSize++;
        }

        if (!small.isEmpty() && !large.isEmpty() && small.lastKey() > large.firstKey()) {
            int x = small.lastKey();
            int y = large.firstKey();
            remove(small, x);
            remove(large, y);
            add(small, y);
            add(large, x);
            smallSum += y - x;
        }
    }

    private void add(TreeMap<Integer, Integer> map, int x) {
        map.put(x, map.getOrDefault(x, 0) + 1);
    }

    private void remove(TreeMap<Integer, Integer> map, int x) {
        int cnt = map.get(x);
        if (cnt == 1) map.remove(x);
        else map.put(x, cnt - 1);
    }
}
