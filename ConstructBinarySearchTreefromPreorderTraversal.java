import javax.swing.tree.TreeNode;

// we just need an upper bound and while creating we will keep track of the index where we are

public class ConstructBinarySearchTreefromPreorderTraversal {
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
    public TreeNode bstFromPreorder(int[] preorder) {
        return constructBST(preorder,Integer.MAX_VALUE,new int[]{0});
    }
    public TreeNode constructBST(int[] preorder,int bound,int[]i) {
        if(i[0]==preorder.length ||preorder[i[0]]>bound) return null;
        TreeNode root=new TreeNode(preorder[i[0]++]);
        root.left=constructBST(preorder,root.val,i);
        root.right=constructBST(preorder,bound,i);
        return root;
    }
}
}
