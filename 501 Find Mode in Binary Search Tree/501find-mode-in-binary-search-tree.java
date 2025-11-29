class Solution {
    public int[] findMode(TreeNode root) {
        // Edge case
        if (root == null) return new int[0];

        // Step 1: Count all frequencies
        HashMap<Integer, Integer> map = new HashMap<>();
        countFreq(root, map);

        // Step 2: Find the highest frequency
        int maxFreq = 0;
        for (int freq : map.values()) {
            if (freq > maxFreq) maxFreq = freq;
        }

        // Step 3: Collect all values equal to max frequency
        List<Integer> result = new ArrayList<>();
        for (int key : map.keySet()) {
            if (map.get(key) == maxFreq) {
                result.add(key);
            }
        }

        // Step 4: Convert to array
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            ans[i] = result.get(i);
        }

        return ans;
    }

    private void countFreq(TreeNode node, HashMap<Integer, Integer> map) {
        if (node == null) return;

        map.put(node.val, map.getOrDefault(node.val, 0) + 1);

        countFreq(node.left, map);
        countFreq(node.right, map);
    }
}
