import java.util.*;

class Solution {
    public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {


        boolean[] knows = new boolean[n];
        knows[0] = true;
        knows[firstPerson] = true;

      
        Arrays.sort(meetings, (a, b) -> a[2] - b[2]);

        int i = 0;
        int m = meetings.length;

        while (i < m) {
            int time = meetings[i][2];

            Map<Integer, List<Integer>> graph = new HashMap<>();
            Set<Integer> people = new HashSet<>();

            while (i < m && meetings[i][2] == time) {
                int x = meetings[i][0];
                int y = meetings[i][1];

                graph.computeIfAbsent(x, k -> new ArrayList<>()).add(y);
                graph.computeIfAbsent(y, k -> new ArrayList<>()).add(x);

                people.add(x);
                people.add(y);
                i++;
            }

            Queue<Integer> queue = new LinkedList<>();
            Set<Integer> visited = new HashSet<>();

            for (int p : people) {
                if (knows[p]) {
                    queue.offer(p);
                    visited.add(p);
                }
            }

            while (!queue.isEmpty()) {
                int curr = queue.poll();
                for (int next : graph.getOrDefault(curr, new ArrayList<>())) {
                    if (!visited.contains(next)) {
                        visited.add(next);
                        knows[next] = true;
                        queue.offer(next);
                    }
                }
            }
        }


        List<Integer> result = new ArrayList<>();
        for (int idx = 0; idx < n; idx++) {
            if (knows[idx]) result.add(idx);
        }

        return result;
    }
}
