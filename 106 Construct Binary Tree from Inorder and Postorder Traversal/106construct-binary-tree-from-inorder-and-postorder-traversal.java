/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int post;
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        post = postorder.length - 1; 
        return build(inorder, postorder, 0, inorder.length - 1);
    }

     private TreeNode build(int[] inorder, int[] postorder, int start, int end) {
        if (start > end) return null; 
        int rootVal= postorder[post--];
        TreeNode root = new TreeNode(rootVal);
        
        int inIndex = start;
        while (inorder[inIndex] != rootVal) inIndex++;

        
        root.right = build(inorder, postorder, inIndex + 1, end);
        root.left = build(inorder, postorder, start, inIndex - 1);

        return root;

     }
}