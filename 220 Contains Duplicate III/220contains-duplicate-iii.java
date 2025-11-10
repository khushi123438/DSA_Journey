import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> window = new TreeSet<>();

        for (int i = 0; i < nums.length; i++) {
            long num = nums[i];

            Long candidate = window.ceiling(num - (long)valueDiff);

           
            if (candidate != null && candidate <= num + (long)valueDiff)
                return true;

            
            window.add(num);

          
            if (i >= indexDiff)
                window.remove((long)nums[i - indexDiff]);
        }

        return false;
    }
}
