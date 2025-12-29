import java.util.*;

class Solution {
    Map<String, List<Character>> map = new HashMap<>();

    public boolean pyramidTransition(String bottom, List<String> allowed) {
        // Build transition map
        for (String s : allowed) {
            String key = s.substring(0, 2);
            char value = s.charAt(2);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(value);
        }

        return dfs(bottom);
    }

    private boolean dfs(String curr) {
        // If pyramid reaches the top
        if (curr.length() == 1) return true;

        return buildNext(curr, 0, new StringBuilder());
    }

    private boolean buildNext(String curr, int index, StringBuilder next) {
        // Finished building one level
        if (index == curr.length() - 1) {
            return dfs(next.toString());
        }

        String key = curr.substring(index, index + 2);

        // If no transition possible
        if (!map.containsKey(key)) return false;

        // Try all possible characters
        for (char c : map.get(key)) {
            next.append(c);
            if (buildNext(curr, index + 1, next)) return true;
            next.deleteCharAt(next.length() - 1); // backtrack
        }

        return false;
    }
}
