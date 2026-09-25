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
    int maxSum= Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        Sum(root);
        return maxSum;
    }

    public int Sum(TreeNode root){
        if(root==null) return 0;

        int leftSum=Math.max(0,Sum(root.left));
        int rightSum=Math.max(0,Sum(root.right));

        int curr = root.val + leftSum + rightSum;

        maxSum= Math.max(maxSum,curr);

        return root.val+Math.max(leftSum,rightSum);
    }
}