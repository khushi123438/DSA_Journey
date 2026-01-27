import java.util.*;

class Solution {

    static class Pair {
        int node;
        int weight;

        Pair(int node, int weight) {
            this.node = node;
            this.weight = weight;
        }
    }

    public int minCost(int n, int[][] edges) {

        // Adjacency list
        Map<Integer, List<Pair>> adj = new HashMap<>();

        for (int[] edge : edges) {
            int u = edge[0];
            int v = edge[1];
            int wt = edge[2];

            adj.computeIfAbsent(u, k -> new ArrayList<>()).add(new Pair(v, wt));
            adj.computeIfAbsent(v, k -> new ArrayList<>()).add(new Pair(u, 2 * wt));
        }

        // Min heap: {distance, node}
        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> a[0] - b[0]
        );

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);

        dist[0] = 0;
        pq.offer(new int[]{0, 0});

        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0];
            int node = cur[1];

            if (d > dist[node]) continue;

            if (node == n - 1) return d;

            for (Pair p : adj.getOrDefault(node, new ArrayList<>())) {
                int nextNode = p.node;
                int weight = p.weight;

                if (d + weight < dist[nextNode]) {
                    dist[nextNode] = d + weight;
                    pq.offer(new int[]{dist[nextNode], nextNode});
                }
            }
        }

        return -1;
    }
}
