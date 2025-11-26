class Solution {
    public TreeNode invertTree(TreeNode root) {
        swapChildren(root);
        return root;
    }

    private void swapChildren(TreeNode node) {
        if (node == null) return;

       
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;

       
        swapChildren(node.left);
        swapChildren(node.right);
    }
}
