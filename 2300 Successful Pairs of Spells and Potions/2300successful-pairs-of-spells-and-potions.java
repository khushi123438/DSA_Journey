class Solution {
    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        int n = spells.length;
        int m = potions.length;
        int[] pairs = new int[n];

        Arrays.sort(potions);

        for (int i = 0; i < n; i++) {
        long minPotion = (long) Math.ceil((double) success / spells[i]);
        int left = 0, right = m - 1;
        int idx = m;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (potions[mid] >= minPotion) {
                idx = mid;
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        pairs[i] = m - idx;
        }
        return pairs;
    }
   
}