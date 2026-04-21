import java.util.*;

class Solution {

    class DSU {
        int[] parent;

        DSU(int n) {
            parent = new int[n];
            for (int i = 0; i < n; i++) parent[i] = i;
        }

        int find(int x) {
            if (parent[x] != x) parent[x] = find(parent[x]);
            return parent[x];
        }

        void union(int a, int b) {
            int pa = find(a), pb = find(b);
            if (pa != pb) parent[pb] = pa;
        }
    }

    public int minimumHammingDistance(int[] source, int[] target, int[][] allowedSwaps) {
        int n = source.length;
        DSU dsu = new DSU(n);

        for (int[] s : allowedSwaps) dsu.union(s[0], s[1]);

        Map<Integer, List<Integer>> groups = new HashMap<>();
        for (int i = 0; i < n; i++) {
            int p = dsu.find(i);
            groups.computeIfAbsent(p, k -> new ArrayList<>()).add(i);
        }

        int hamming = 0;

        for (List<Integer> g : groups.values()) {
            Map<Integer, Integer> freq = new HashMap<>();

            for (int i : g) freq.put(source[i], freq.getOrDefault(source[i], 0) + 1);

            for (int i : g) {
                int v = target[i];
                if (freq.getOrDefault(v, 0) > 0) freq.put(v, freq.get(v) - 1);
                else hamming++;
            }
        }

        return hamming;
    }
}