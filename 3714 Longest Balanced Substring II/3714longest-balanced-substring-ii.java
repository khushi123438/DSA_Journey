import java.util.*;

class Solution {
    public int longestBalanced(String s) {
        int n = s.length();
        if (n == 0) return 0;

        int ans = 1;

        int run = 1;
        for (int i = 1; i < n; i++) {
            if (s.charAt(i) == s.charAt(i - 1)) run++;
            else run = 1;
            ans = Math.max(ans, run);
        }

        char[][] pairs = {{'a','b'}, {'b','c'}, {'a','c'}};

        for (char[] p : pairs) {
            int diff = 0;
            HashMap<Integer, Integer> map = new HashMap<>();
            map.put(0, -1);

            for (int i = 0; i < n; i++) {
                char ch = s.charAt(i);

                if (ch == p[0]) diff++;
                else if (ch == p[1]) diff--;
                else {
                    diff = 0;
                    map = new HashMap<>();
                    map.put(0, i);
                    continue;
                }

                Integer prev = map.get(diff);
                if (prev != null) ans = Math.max(ans, i - prev);
                else map.put(diff, i);
            }
        }

        HashMap<Long, Integer> map3 = new HashMap<>();
        map3.put(0L, -1);

        int a = 0, b = 0, c = 0;

        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == 'a') a++;
            else if (ch == 'b') b++;
            else c++;

            long key = (((long)(a - b)) << 32) ^ (long)(b - c);

            Integer prev = map3.get(key);
            if (prev != null) ans = Math.max(ans, i - prev);
            else map3.put(key, i);
        }

        return ans;
    }
}
