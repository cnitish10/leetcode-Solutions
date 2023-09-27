import javax.swing.tree.TreeNode;

// simply doing any traversal and keep counting the nodes when found
public class CountCompleteTreeNodes {
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
    public int solve(TreeNode root){
        if(root==null)return 0;
        return 1+solve(root.left)+solve(root.right);
    }
    public int countNodes(TreeNode root) {
        if(root==null)return 0;
        return solve(root);
    }
}
}
