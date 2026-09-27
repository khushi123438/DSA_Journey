class Solution {

    class Pair {
        TreeNode node;
        int row;
        int col;

        Pair(TreeNode node, int row, int col) {
            this.node = node;
            this.row = row;
            this.col = col;
        }
    }

    public List<List<Integer>> verticalTraversal(TreeNode root) {

        List<int[]> nodes = new ArrayList<>();

        dfs(root, 0, 0, nodes);

   
        Collections.sort(nodes, (a, b) -> {

            if (a[0] != b[0])
                return Integer.compare(a[0], b[0]);

            if (a[1] != b[1])
                return Integer.compare(a[1], b[1]);

            return Integer.compare(a[2], b[2]);
        });

        List<List<Integer>> ans = new ArrayList<>();

        int prevCol = Integer.MIN_VALUE;

        for (int[] x : nodes) {

            int col = x[0];
            int value = x[2];

            if (col != prevCol) {
                ans.add(new ArrayList<>());
                prevCol = col;
            }

            ans.get(ans.size() - 1).add(value);
        }

        return ans;
    }

    private void dfs(TreeNode root, int row, int col,
                     List<int[]> nodes) {

        if (root == null)
            return;

        nodes.add(new int[]{col, row, root.val});

        dfs(root.left, row + 1, col - 1, nodes);
        dfs(root.right, row + 1, col + 1, nodes);
    }
}