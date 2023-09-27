// if at any point abs diff of height of left subtree and right subtree is greater than 1 return false
public class BalancedBinaryTree {
    
    // Definition for a binary tree node.
     public class TreeNode {
         int val;
         TreeNode left;
         TreeNode right;
         TreeNode() {}
         TreeNode(int val) { this.val = val; }
         TreeNode(int val, TreeNode left, TreeNode right) {
             this.val = val;
             this.left = left;
             this.right = right;
         }
     }
    
   class Solution {
       public int maxDepth(TreeNode root){
           if(root==null)return 0;
           return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
       }
       public boolean isBalanced(TreeNode root) {
           if(root==null)return true;
           int left = maxDepth(root.left);
           int right = maxDepth(root.right);
           return Math.abs(left-right)<=1&&isBalanced(root.left)&&isBalanced(root.right);
       }
   } 
}
