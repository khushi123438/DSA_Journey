class Solution {
    long totalSum = 0;
    long maxProduct = 0;
    final int MOD = 1_000_000_007;

    public int maxProduct(TreeNode root) {
        totalSum = treeSum(root);   // Step 1: total sum
        dfs(root);                  // Step 2: find max product
        return (int)(maxProduct % MOD);
    }

    // Compute total sum of tree
    private long treeSum(TreeNode node) {
        if (node == null) return 0;
        return node.val + treeSum(node.left) + treeSum(node.right);
    }

    // DFS to compute subtree sums and products
    private long dfs(TreeNode node) {
        if (node == null) return 0;

        long left = dfs(node.left);
        long right = dfs(node.right);

        long subSum = node.val + left + right;
        maxProduct = Math.max(maxProduct, subSum * (totalSum - subSum));

        return subSum;
    }
}
