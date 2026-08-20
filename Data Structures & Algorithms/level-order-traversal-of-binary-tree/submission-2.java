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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> nestedList = new ArrayList<>();
        if(root == null){
            return nestedList;
        }

        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        queue.add(root);
        
        while(!queue.isEmpty()){
            List<Integer> row = new ArrayList<>();
            int rowLength = queue.size();

            for(int i = 0; i < rowLength; i++){
                TreeNode curr = queue.poll();
                row.add(curr.val);

                if(curr.left != null){
                    queue.add(curr.left);
                }
                if(curr.right != null){
                    queue.add(curr.right);
                }
            }
            
            nestedList.add(row);
        }
        
        return nestedList;
    }
}
