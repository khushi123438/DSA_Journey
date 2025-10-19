class Solution {
     private String addToOdd(String s, int a) {
        char[] arr = s.toCharArray();
        for (int i = 1; i < arr.length; i += 2) {
            arr[i] = (char)(((arr[i] - '0' + a) % 10) + '0');
        }
        return new String(arr);
    }

    private String rotateRight(String s, int b) {
        int n = s.length();
        b %= n;
        if (b == 0) return s;
        return s.substring(n - b) + s.substring(0, n - b);
    }

    public String findLexSmallestString(String s, int a, int b) {
        Set<String> visited = new HashSet<>();
        Queue<String> q = new LinkedList<>();
        q.add(s);
        visited.add(s);
        String best = s;

        while (!q.isEmpty()) {
            String cur = q.poll();
            if (cur.compareTo(best) < 0) best = cur;

            String added = addToOdd(cur, a);
            if (!visited.contains(added)) {
                visited.add(added);
                q.add(added);
            }

            String rotated = rotateRight(cur, b);
            if (!visited.contains(rotated)) {
                visited.add(rotated);
                q.add(rotated);
            }
        }

        return best;
    }
}