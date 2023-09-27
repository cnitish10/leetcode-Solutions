import javax.swing.tree.TreeNode;

public class ValidateBinarySearchTree {
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
    // if we found root is null return true
    // if we found root is not in the range we passed return false 
    // if root's value is in the range we will check the same for left and right subtree as well
    public boolean validBST(TreeNode root,long mini,long maxi){
        if(root==null)return true;
        if(root.val<=mini||root.val>=maxi)return false;
        return validBST(root.left,mini,root.val)&&validBST(root.right,root.val,maxi);
    }

    // we will pass a boundary values long max ,long min
    public boolean isValidBST(TreeNode root) {
        long maxi=Long.MAX_VALUE;
        long mini=Long.MIN_VALUE;
        return validBST(root,mini,maxi);
    }
}
}
