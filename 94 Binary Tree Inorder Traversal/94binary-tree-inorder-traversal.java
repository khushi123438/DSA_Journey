class Solution {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        TreeNode curr = root;

        while(curr!=null){
            if(curr.left==null){
                list.add(curr.val);
                curr=curr.right;
            }
            else{
                TreeNode pred = curr.left;
                while(pred.right!=null && pred.right!=curr){
                    pred=pred.right;
                }

                if(pred.right==null){
                    pred.right=curr;
                    curr=curr.left;
                }

                else{
                    pred.right=null;
                    list.add(curr.val);
                    curr=curr.right;
                }
            }
        }
        return list;
    }
}
