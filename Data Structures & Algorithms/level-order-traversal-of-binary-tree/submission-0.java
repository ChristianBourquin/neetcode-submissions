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
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        if(root != null){
            queue.add(root);
        }

        List<List<Integer>> nestedList = new ArrayList<>();
        List<Integer> row;

        while(!queue.isEmpty()){
            row = new ArrayList<>();
            int rowLength = queue.size();

            for(int i = 0; i < rowLength; i++){
                root = queue.removeFirst();
                row.add(root.val);

                if(root.left != null){
                    queue.add(root.left);
                }
                if(root.right != null){
                    queue.add(root.right);
                }
            }
            
            nestedList.add(row);
        }
        
        return nestedList;
    }
}
