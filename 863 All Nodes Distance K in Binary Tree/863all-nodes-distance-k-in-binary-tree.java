class Solution {

    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {

        List<Integer> ans = new ArrayList<>();

        // Step 1: Make parent map
        HashMap<TreeNode, TreeNode> parent = new HashMap<>();
        buildParent(root, parent);


        // Step 2: BFS from target
        Queue<TreeNode> queue = new LinkedList<>();
        HashSet<TreeNode> visited = new HashSet<>();

        queue.offer(target);
        visited.add(target);


        int dist = 0;


        while (!queue.isEmpty()) {

            if (dist == k) {
                break;
            }


            int size = queue.size();


            for (int i = 0; i < size; i++) {

                TreeNode curr = queue.poll();


                // left child
                if (curr.left != null && !visited.contains(curr.left)) {
                    visited.add(curr.left);
                    queue.offer(curr.left);
                }


                // right child
                if (curr.right != null && !visited.contains(curr.right)) {
                    visited.add(curr.right);
                    queue.offer(curr.right);
                }


                // parent
                if (parent.containsKey(curr) && 
                    !visited.contains(parent.get(curr))) {

                    visited.add(parent.get(curr));
                    queue.offer(parent.get(curr));
                }
            }

            dist++;
        }


        while (!queue.isEmpty()) {
            ans.add(queue.poll().val);
        }


        return ans;
    }



    private void buildParent(TreeNode root, HashMap<TreeNode, TreeNode> parent) {

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);


        while (!queue.isEmpty()) {

            TreeNode curr = queue.poll();


            if (curr.left != null) {

                parent.put(curr.left, curr);
                queue.offer(curr.left);
            }


            if (curr.right != null) {

                parent.put(curr.right, curr);
                queue.offer(curr.right);
            }
        }
    }
}