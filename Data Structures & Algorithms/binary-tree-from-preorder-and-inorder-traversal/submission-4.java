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
    int index;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;
        return iterate(preorder, inorder, 0, inorder.length);
    }

    public TreeNode iterate(int[] preorder, int[] inorder, int start, int end){
        //is your sub array empty
        if(start >= end){
            return null;
        }

        //create new node to attatch to the tree
        TreeNode root = new TreeNode(preorder[index]);
        index++;

        //find where the current node is in inorder to split the current array into more sub arrays
        int count = start;
        while(root.val != inorder[count]){
            if(count > end - 1){
                return root;
            }
            count++;
        }

        //use these new sub array indices recursively
        root.left = iterate(preorder, inorder, start, count);

        root.right = iterate(preorder, inorder, count + 1, end);

        return root;

    }

}
