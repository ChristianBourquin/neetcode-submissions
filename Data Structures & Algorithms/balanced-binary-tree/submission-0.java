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
//Math.max(leftHeight, rightHeight) + 1
class Solution {
    public boolean isBalanced(TreeNode root) {
        int bool = getHeight(root);
        if(bool == -1){
            return false;
        }
        return true;
    }
    
    public int getHeight(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = getHeight(node.left);
        if(left == -1){
            return -1;
        }
        int right = getHeight(node.right);
        if(right == -1){
            return -1;
        }

        if(Math.abs(left - right) > 1){
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
