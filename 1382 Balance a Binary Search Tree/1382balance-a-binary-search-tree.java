class Solution {
    public TreeNode balanceBST(TreeNode root) {
        List<Integer> inorder = new ArrayList<>();
        inorderTraversal(root, inorder);
        return buildBalancedBST(inorder, 0, inorder.size() - 1);
    }

    private void inorderTraversal(TreeNode root, List<Integer> list) {
        if (root == null) return;
        inorderTraversal(root.left, list);
        list.add(root.val);
        inorderTraversal(root.right, list);
    }

    private TreeNode buildBalancedBST(List<Integer> list, int low, int high) {
        if (low > high) return null;

        int mid = low + (high - low) / 2;
        TreeNode root = new TreeNode(list.get(mid));

        root.left = buildBalancedBST(list, low, mid - 1);
        root.right = buildBalancedBST(list, mid + 1, high);

        return root;
    }
}
