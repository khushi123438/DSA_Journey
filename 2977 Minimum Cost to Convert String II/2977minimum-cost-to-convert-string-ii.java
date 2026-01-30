import java.util.*;

class Solution {

    static final long INF = (long) 1e18;

    static class Trie {
        Trie[] next = new Trie[26];
        int id = -1;
    }

    Trie srcTrie = new Trie();
    Trie tgtTrie = new Trie();

    void insert(Trie root, String s, int id) {
        Trie cur = root;
        for (char c : s.toCharArray()) {
            int idx = c - 'a';
            if (cur.next[idx] == null)
                cur.next[idx] = new Trie();
            cur = cur.next[idx];
        }
        cur.id = id;
    }

    public long minimumCost(String source, String target,
                            String[] original, String[] changed, int[] cost) {

        int n = source.length();

        Map<String, Integer> map = new HashMap<>();
        int idx = 0;

        for (String s : original) map.putIfAbsent(s, idx++);
        for (String s : changed) map.putIfAbsent(s, idx++);

        int m = idx;

        long[][] dist = new long[m][m];
        for (int i = 0; i < m; i++) Arrays.fill(dist[i], INF);
        for (int i = 0; i < m; i++) dist[i][i] = 0;

        for (int i = 0; i < original.length; i++) {
            int u = map.get(original[i]);
            int v = map.get(changed[i]);
            dist[u][v] = Math.min(dist[u][v], cost[i]);
        }

        for (int k = 0; k < m; k++) {
            for (int i = 0; i < m; i++) {
                for (int j = 0; j < m; j++) {
                    dist[i][j] = Math.min(dist[i][j], dist[i][k] + dist[k][j]);
                }
            }
        }

        for (String s : original) insert(srcTrie, s, map.get(s));
        for (String s : changed) insert(tgtTrie, s, map.get(s));

        long[] dp = new long[n + 1];
        Arrays.fill(dp, INF);
        dp[n] = 0;

        for (int i = n - 1; i >= 0; i--) {

            if (source.charAt(i) == target.charAt(i))
                dp[i] = dp[i + 1];

            Trie sCur = srcTrie;
            Trie tCur = tgtTrie;

            for (int j = i; j < n; j++) {
                int sc = source.charAt(j) - 'a';
                int tc = target.charAt(j) - 'a';

                if (sCur.next[sc] == null || tCur.next[tc] == null)
                    break;

                sCur = sCur.next[sc];
                tCur = tCur.next[tc];

                if (sCur.id != -1 && tCur.id != -1) {
                    long cst = dist[sCur.id][tCur.id];
                    if (cst < INF && dp[j + 1] < INF) {
                        dp[i] = Math.min(dp[i], cst + dp[j + 1]);
                    }
                }
            }
        }

        return dp[0] >= INF ? -1 : dp[0];
    }
}
