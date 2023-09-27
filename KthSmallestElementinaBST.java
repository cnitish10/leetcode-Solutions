import javax.swing.tree.TreeNode;

// we know that inorder traversal of a binary search tree is sorted using this property 
// while traversing we will keep increasing the cnt once cnt =k we will get our element

public class KthSmallestElementinaBST {
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
    public int inorder(TreeNode root, int k,int cnt[]){
        if(root==null)return -1;
        int left = inorder(root.left,k,cnt);
        if(left!=-1)return left;
        cnt[0]++;
        if(k==cnt[0])return root.val;
        return inorder(root.right,k,cnt);
    }
    public int kthSmallest(TreeNode root, int k) {
        int cnt[]=new int[1];
        return inorder(root,k,cnt);
    }
}
}
