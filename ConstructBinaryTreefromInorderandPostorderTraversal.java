import java.util.HashMap;
import java.util.Map;

import javax.swing.tree.TreeNode;

public class ConstructBinaryTreefromInorderandPostorderTraversal{
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
    // we will put all inorder elements in map along with their index
    // we will call helper function with inOrder start index inorder end index 
    //and the postordder start index and its end index
    // as we know that what ever is in the last in the postorder will be the  root of the tree , 
    //also that root in inorder will divide the tree in left and right subtree
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        Map<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1, map);
    }

    // so using that property we will use end index of post order for root , 
    //find that index in map of inorder, once we get that we will pass that index for creating left half and right half
    private TreeNode helper(int[] inorder, int[] postorder, int inStart, int inEnd, int postStart, int postEnd, Map<Integer, Integer> map) {
        if(inStart > inEnd || postStart > postEnd) return null;

        TreeNode root = new TreeNode(postorder[postEnd]);

        int inRoot = map.get(root.val);

        root.left = helper(inorder, postorder, inStart, inRoot - 1, postStart, postEnd - (inEnd - inRoot) - 1, map);
        root.right = helper(inorder, postorder, inRoot + 1, inEnd, postEnd - (inEnd - inRoot), postEnd - 1, map);
        
        return root;
    }
}
}