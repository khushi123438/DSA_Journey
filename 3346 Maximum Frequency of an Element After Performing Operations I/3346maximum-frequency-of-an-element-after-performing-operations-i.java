class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
      
        Map<Integer, Integer> count = new HashMap<>();
        Map<Integer, Integer> diff = new HashMap<>();

        // Step 1: Count occurrences and build difference map ranges
        for (int num : nums) {
            count.put(num, count.getOrDefault(num, 0) + 1);

            int start = num - k;
            int endExcl = num + k + 1; // exclusive end for diff technique
            diff.put(start, diff.getOrDefault(start, 0) + 1);
            diff.put(endExcl, diff.getOrDefault(endExcl, 0) - 1);
        }

        // Combine keys: all diff boundaries AND all original values (nums)
        Set<Integer> keySet = new HashSet<>();
        keySet.addAll(diff.keySet());
        keySet.addAll(count.keySet());

        List<Integer> keys = new ArrayList<>(keySet);
        Collections.sort(keys);

        int ans = 1;
        int prefix = 0;

        for (int x : keys) {
            // update how many nums can reach x
            if (diff.containsKey(x)) prefix += diff.get(x);

            int already = count.getOrDefault(x, 0);
            // eligible to become x = prefix (includes those already x)
            // we can change at most numOperations distinct indices (some may already be x by choosing add 0)
            int candidate = Math.min(prefix, already + numOperations);
            ans = Math.max(ans, candidate);
        }

        return ans;
    }
}