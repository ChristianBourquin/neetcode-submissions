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
    int[] positions;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        index = 0;

        //positions[value + 1000] = index of value in inorder
        positions = new int[2001];

        for (int i = 0; i < inorder.length; i++) {
            positions[inorder[i] + 1000] = i;
        }

        return iterate(preorder, 0, inorder.length);
    }

    public TreeNode iterate(int[] preorder, int start, int end){
        //is the array empty
        if(start >= end){
            return null;
        }

        //Preorder tells us what the root is
        TreeNode root = new TreeNode(preorder[index]);
        index++;

        //Direct array lookup instead of searching inorder(this allows for O(n))
        int count = positions[root.val + 1000];

        //Build left and right subtrees
        root.left = iterate(preorder, start, count);
        root.right = iterate(preorder, count + 1, end);

        return root;
    }

}
