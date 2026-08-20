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
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return traverse(root, targetSum, 0);
    }

    public boolean traverse(TreeNode root, int targetSum, int total){
        if(root == null){
            return false;
        }

        boolean curr = false;
        int tempTotal = total + root.val;

        if(root.left == null && root.right == null){
            if(tempTotal == targetSum){
                return true;
            }else{
                return false;
            }
        }
        if(root.left != null){
            curr = traverse(root.left, targetSum, tempTotal);
        }
        if(root.right != null && !curr){
            curr = traverse(root.right, targetSum, tempTotal);
        }
        
        return curr;
    }
}