import java.util.*;

class Solution {
    public int[] processQueries(int c, int[][] connections, int[][] queries) {
        // Step 1: Build adjacency list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i <= c; i++) {
            adj.add(new ArrayList<>());
        }

        for (int[] edge : connections) {
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);
            adj.get(v).add(u);
        }

        // Step 2: Find connected components
        int[] compId = new int[c + 1];
        Arrays.fill(compId, -1);
        int comp = 0;

        for (int i = 1; i <= c; i++) {
            if (compId[i] == -1) {
                Queue<Integer> q = new LinkedList<>();
                q.offer(i);
                compId[i] = comp;

                while (!q.isEmpty()) {
                    int node = q.poll();
                    for (int nei : adj.get(node)) {
                        if (compId[nei] == -1) {
                            compId[nei] = comp;
                            q.offer(nei);
                        }
                    }
                }
                comp++;
            }
        }

        // Step 3: Track online status and available nodes per component
        boolean[] online = new boolean[c + 1];
        Arrays.fill(online, true);

        List<TreeSet<Integer>> compOnline = new ArrayList<>();
        for (int i = 0; i < comp; i++) compOnline.add(new TreeSet<>());

        for (int i = 1; i <= c; i++) {
            compOnline.get(compId[i]).add(i);
        }

        // Step 4: Process queries
        List<Integer> resultList = new ArrayList<>();

        for (int[] q : queries) {
            int type = q[0];
            int x = q[1];
            int cid = compId[x];

            if (type == 1) {
                if (online[x]) {
                    resultList.add(x);
                } else {
                    if (compOnline.get(cid).isEmpty())
                        resultList.add(-1);
                    else
                        resultList.add(compOnline.get(cid).first());
                }
            } else if (type == 2) {
                if (online[x]) {
                    online[x] = false;
                    compOnline.get(cid).remove(x);
                }
            }
        }

        // Convert List<Integer> to int[]
        int[] result = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            result[i] = resultList.get(i);
        }

        return result;
    }
}
