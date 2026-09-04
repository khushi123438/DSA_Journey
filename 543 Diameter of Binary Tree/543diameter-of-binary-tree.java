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
   /* public int diameterOfBinaryTree(TreeNode root) {
        if(root==null) return 0;

        int ldia = diameterOfBinaryTree(root.left);  approach-1
        int rdia = diameterOfBinaryTree(root.right);

        int lh = height(root.left);
        int rh = height(root.right);

        int selfdia = lh + rh; // in terms of edges

        return Math.max(selfdia,Math.max(ldia,rdia));
    }

    private int height(TreeNode root){
        if(root==null) return 0;

        int left = height(root.left);
        int right = height(root.right);

        return Math.max(left, right) + 1;
    }
    */
    int diameter=0;
    public int diameterOfBinaryTree(TreeNode root) {
       Height(root);
       return diameter;
    }

    private int Height(TreeNode node){
        if(node==null) return 0;

        int left = Height(node.left);
        int right = Height(node.right);

        diameter = Math.max(diameter, left+right);

        return Math.max(left,right)+1;
    }
}