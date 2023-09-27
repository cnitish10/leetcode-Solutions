import javax.swing.tree.TreeNode;

// as we know that bst have smaller elements in left and greater elements in right 
// using this property we will check if root is equal return root
// if root's value is greater than the key then will go to the left part
// or else will go the right part

public class SearchinaBinarySearchTree {
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
    public TreeNode searchBST(TreeNode root, int val) {
        if(root==null)return null;
        if(root.val==val)return root;
        if(root.val>val) return searchBST(root.left,val);
        return searchBST(root.right,val);
    }
}
}
