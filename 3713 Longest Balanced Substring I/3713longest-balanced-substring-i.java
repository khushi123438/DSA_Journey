import java.util.*;

class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        int ans = 0;

        for (int i = 0; i < n; i++) {
            HashMap<Character, Integer> map = new HashMap<>();
            int maxFreq = 0;

            for (int j = i; j < n; j++) {
                char ch = s.charAt(j);
                map.put(ch, map.getOrDefault(ch, 0) + 1);

                maxFreq = Math.max(maxFreq, map.get(ch));
                int distinct = map.size();
                int len = j - i + 1;

                if (maxFreq * distinct == len) {
                    ans = Math.max(ans, len);
                }
            }
        }
        return ans;
    }
}
