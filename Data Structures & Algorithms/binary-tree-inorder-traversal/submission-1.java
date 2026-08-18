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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> output = new ArrayList<>();
        traverse(root, output);
        return output;
    }

    public void traverse(TreeNode root, List<Integer> input){
        if(root == null){
            return;
        }
        traverse(root.left, input);
        input.add(root.val);
        traverse(root.right, input);
    }
}