import java.util.*;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        List<Integer> arr = new ArrayList<>();
        for (int num : nums) {
            arr.add(num);
        }

        int operations = 0;

        while (true) {
            boolean sorted = true;
            for (int i = 0; i < arr.size() - 1; i++) {
                if (arr.get(i) > arr.get(i + 1)) {
                    sorted = false;
                    break;
                }
            }

            if (sorted) break;

            int minSum = Integer.MAX_VALUE;
            int targetIndex = -1;

            for (int i = 0; i < arr.size() - 1; i++) {
                int currentSum = arr.get(i) + arr.get(i + 1);
                if (currentSum < minSum) {
                    minSum = currentSum;
                    targetIndex = i;
                }
            }

            arr.set(targetIndex, minSum);
            arr.remove(targetIndex + 1);
            operations++;
        }

        return operations;
    }
}