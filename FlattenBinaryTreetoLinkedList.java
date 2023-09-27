import javax.swing.tree.TreeNode;

// we will go right most and we will keep a temp node declared as null attack it to the righmost guy
// and mark its left to null and assign temp to the current node wimiliarily do this untill we are done with all nodes 
public class FlattenBinaryTreetoLinkedList {
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
    TreeNode prev=null;
    public void flatten(TreeNode root) {
        if(root==null)return;
        flatten(root.right);
        flatten(root.left);
        root.right = prev;
        root.left = null;
        prev = root;
    }
}
}
