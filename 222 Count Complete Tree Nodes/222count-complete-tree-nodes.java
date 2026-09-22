class Solution {
    public int countNodes(TreeNode root) {
        if (root == null) return 0;

        int left = leftHeight(root.left);
        int right = rightHeight(root.right);

        if (left == right)
            return (int)Math.pow(2, left) - 1;

        return 1 + countNodes(root.left) + countNodes(root.right);
    }

    private int leftHeight(TreeNode root) {
        int h = 1;

        while (root != null) {
            h++;
            root = root.left;
        }

        return h;
    }

    private int rightHeight(TreeNode root) {
        int h = 1;

        while (root != null) {
            h++;
            root = root.right;
        }

        return h;
    }
}