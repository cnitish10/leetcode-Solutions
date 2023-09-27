import javax.swing.tree.TreeNode;

// if it is an empty tree we will simply add the node
// we will just find the correct position at which the node should be added by comparing its value with root's value
//once we get a null position we will add the node over there
public class InsertintoaBinarySearchTree {
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
    public TreeNode insertIntoBST(TreeNode root, int val) {
        TreeNode dummy = root;
        if(dummy==null)return new TreeNode(val);
        while(true){
            if(dummy.val<=val){
                if(dummy.right!=null)dummy=dummy.right;
                else{
                    dummy.right= new TreeNode(val);
                    break;
                }
            }
            else{
                if(dummy.left!=null)dummy=dummy.left;
                else{
                    dummy.left = new TreeNode(val);
                    break;
                }
            }
        }
        return root;
    }
}
}
