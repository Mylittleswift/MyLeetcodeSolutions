/*
Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
*/


//recursive
public class Solution {
    public boolean isValidBST(TreeNode root) {
       return isBST(root, null, null);
    }
     
    private boolean isBST(TreeNode node, Integer min, Integer max) {
        if (node == null) return true;
         
        if ((min != null && node.val <= min) || (max != null && node.val >= max)) {
            return false;
        }
         
        return isBST(node.left, min, node.val) && isBST(node.right, node.val, max);
    }
}




