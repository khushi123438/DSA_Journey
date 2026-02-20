class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        if(root == null) return result;

        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode node, String path, List<String> res) {
        if (node == null) return;

       
        if (path.length() == 0) path = "" + node.val;
        else path = path + "->" + node.val;

        
        if (node.left == null && node.right == null) {
            res.add(path);
            return;
        }

        
        dfs(node.left, path, res);
        dfs(node.right, path, res);
    }
}
