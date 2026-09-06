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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();

        if(root == null) return ans;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int l=0;

        while(!q.isEmpty()){
            int n=q.size();
            List<Integer> curr = new ArrayList<>();

            while(n>0){
              TreeNode node = q.poll();
              curr.add(node.val);
              if(node.left!=null) q.add(node.left);
              if(node.right!=null) q.add(node.right);

              n--;
            }

            if(l%2==1) Collections.reverse(curr);

            ans.add(curr);
            l++;
        }
        return ans;
    }
}