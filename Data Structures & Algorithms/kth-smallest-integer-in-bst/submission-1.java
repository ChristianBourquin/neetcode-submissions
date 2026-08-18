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
    int counter;
    public int kthSmallest(TreeNode root, int k) {
        return(traverse(root,k));
    }

    public int traverse(TreeNode root, int k){
        if(root == null){
            return 0;
        }

        int min = traverse(root.left, k);
        counter++;
        if(counter > k){
            return min;
        }
        if(k == counter){
            return root.val;
        }
        min = traverse(root.right, k);

        return(min);
    }
}
