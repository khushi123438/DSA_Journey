class Solution {
    public int maxFrequency(int[] nums, int k, int numOperations) {
         Map<Long, Integer> diff = new HashMap<>();
        Map<Long, Integer> count = new HashMap<>();

        // Step 1: Count occurrences
        for (int num : nums) {
            count.put((long) num, count.getOrDefault((long) num, 0) + 1);
        }

        // Step 2: Build difference map
        for (int num : nums) {
            long start = (long) num - k;
            long end = (long) num + k + 1;

            diff.put(start, diff.getOrDefault(start, 0) + 1);
            diff.put(end, diff.getOrDefault(end, 0) - 1);

            // Ensure the number itself is included as a potential target
            diff.putIfAbsent((long) num, 0);
        }

        // Step 3: Sort all keys
        List<Long> keys = new ArrayList<>(diff.keySet());
        Collections.sort(keys);

        // Step 4: Sweep through keys
        int ans = 1;
        long active = 0;

        for (long val : keys) {
            active += diff.get(val);  // how many ranges cover this value
            int already = count.getOrDefault(val, 0);
            long available = active;
            int possible = (int) (already + Math.min(numOperations, available - already));
            ans = Math.max(ans, possible);
        }

        return ans; 
    }
}