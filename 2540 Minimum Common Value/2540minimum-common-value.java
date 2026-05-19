import java.util.*;

class Solution {
    public int getCommon(int[] nums1, int[] nums2) {

        HashSet<Integer> s = new HashSet<>();
        HashSet<Integer> s1 = new HashSet<>();

        for (int x : nums1) {
            s.add(x);
        }

        for (int y : nums2) {
            s1.add(y);
        }

        s.retainAll(s1);

        if (s.isEmpty()) {
            return -1;
        }

        return Collections.min(s);
    }
}