public class Solution {
    public int thirdMax(int[] nums) {
        Long first = null, second = null, third = null;

        for (int num : nums) {
            long n = (long) num;

            // skip if this number is already recorded
            if (first != null && n == first) continue;
            if (second != null && n == second) continue;
            if (third != null && n == third) continue;

            if (first == null || n > first) {
                third = second;
                second = first;
                first = n;
            } else if (second == null || n > second) {
                third = second;
                second = n;
            } else if (third == null || n > third) {
                third = n;
            }
        }

        // if third maximum exists, return it; otherwise return maximum
        return (third != null) ? third.intValue() : first.intValue();
    }
}
