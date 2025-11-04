import java.util.*;

class Solution {
    public int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i + k <= n; i++) {
            Map<Integer, Integer> freq = new HashMap<>();

            for (int j = i; j < i + k; j++) {
                freq.put(nums[j], freq.getOrDefault(nums[j], 0) + 1);
            }

            List<int[]> pairs = new ArrayList<>();
            for (Map.Entry<Integer, Integer> entry : freq.entrySet()) {
                pairs.add(new int[]{entry.getValue(), entry.getKey()});
            }

            pairs.sort((a, b) -> {
                if (a[0] == b[0]) return b[1] - a[1];
                return b[0] - a[0];
            });

            int sum = 0;
            for (int t = 0; t < x && t < pairs.size(); t++) {
                sum += pairs.get(t)[0] * pairs.get(t)[1];
            }

            result[i] = sum;
        }

        return result;
    }
}
