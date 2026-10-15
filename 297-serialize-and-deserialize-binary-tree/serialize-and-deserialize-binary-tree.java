
import java.util.*;

public class Codec {

    // Serialize: Binary Tree -> String
    public String serialize(TreeNode root) {
        if (root == null) return "";

        Queue<TreeNode> q = new LinkedList<>();
        StringBuilder sb = new StringBuilder();

        q.offer(root);

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

            if (node == null) {
                sb.append("N,");
                continue;
            }

            sb.append(node.val).append(",");

            q.offer(node.left);
            q.offer(node.right);
        }

        return sb.toString();
    }

    // Deserialize: String -> Binary Tree
    public TreeNode deserialize(String data) {
        if (data.isEmpty()) return null;

        String[] values = data.split(",");

        TreeNode root =
            new TreeNode(Integer.parseInt(values[0]));

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        int i = 1;

        while (!q.isEmpty()) {
            TreeNode node = q.poll();

          
            if (!values[i].equals("N")) {
                node.left = new TreeNode(
                    Integer.parseInt(values[i])
                );
                q.offer(node.left);
            }
            i++;

         
            if (!values[i].equals("N")) {
                node.right = new TreeNode(
                    Integer.parseInt(values[i])
                );
                q.offer(node.right);
            }
            i++;
        }

        return root;
    }
}
