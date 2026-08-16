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
    public TreeNode deleteNode(TreeNode root, int key) {
        if(root == null){
            return null;
        }

        if(key < root.val){
            root.left = deleteNode(root.left, key);
        }else if(key > root.val){//if the key is hit 
            root.right = deleteNode(root.right, key);
        }else{//this happens if the key is hit before reaching the end
            if(root.right == null && root.left == null){
                root = null;
            }else if(root.right != null){
                TreeNode curr = root.right;
                while(curr.left != null){
                    curr = curr.left;
                }
                root.val = curr.val;
                root.right = deleteNode(root.right, curr.val);
            }else{
                root = root.left;
            }
        }
        return root;
    }
}