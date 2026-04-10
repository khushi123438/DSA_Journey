import java.util.*;

class Solution {
    public int minimumDistance(int[] nums) {
        
        Map<Integer, List<Integer>> map = new HashMap<>();
        
        for (int i = 0; i < nums.length; i++) {
            map.putIfAbsent(nums[i], new ArrayList<>());
            map.get(nums[i]).add(i);
        }

        int minDist = Integer.MAX_VALUE;

        for (List<Integer> idx : map.values()) {
            if (idx.size() >= 3) {
                for (int i = 0; i <= idx.size() - 3; i++) {
                    int first = idx.get(i);
                    int third = idx.get(i + 2);

                    int dist = 2 * (third - first);
                    minDist = Math.min(minDist, dist);
                }
            }
        }

        return minDist == Integer.MAX_VALUE ? -1 : minDist;
    }
}