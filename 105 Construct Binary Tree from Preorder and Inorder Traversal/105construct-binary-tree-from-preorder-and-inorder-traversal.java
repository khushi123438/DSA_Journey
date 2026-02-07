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
    int pre=0;

   
    public TreeNode buildTree(int[] preorder, int[] inorder){
        return build(preorder, inorder, 0, inorder.length - 1);
    }
    
     private TreeNode build(int[] preorder, int[] inorder, int start, int end){
        if(start > end) return null;

        int rootVal = preorder[pre++];
        TreeNode root = new TreeNode(rootVal);

        int inIndex = start;
        while(inorder[inIndex] != rootVal) inIndex++;

        root.left = build(preorder, inorder, start, inIndex - 1);
        root.right = build(preorder, inorder, inIndex + 1, end);

        return root;


     }

}