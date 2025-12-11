import java.util.*;

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        Map<Integer, TreeSet<Integer>> rows = new HashMap<>();
        Map<Integer, TreeSet<Integer>> cols = new HashMap<>();

        for (int[] b : buildings) {
            rows.computeIfAbsent(b[0], k -> new TreeSet<>()).add(b[1]);
            cols.computeIfAbsent(b[1], k -> new TreeSet<>()).add(b[0]);
        }

        int ans = 0;
        for (int[] b : buildings) {
            int x = b[0], y = b[1];

            TreeSet<Integer> row = rows.get(x);
            TreeSet<Integer> col = cols.get(y);

            Integer left = row.lower(y);
            Integer right = row.higher(y);
            Integer up = col.lower(x);
            Integer down = col.higher(x);

            if (left != null && right != null && up != null && down != null) {
                ans++;
            }
        }

        return ans;
    }
}
