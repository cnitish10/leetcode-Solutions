// we will take one gloabal ans  , while calculating the max height of tree we will update this ans as max of current daimeter and lh+rh
public class DiameterOfBinaryTree {
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
           public int ans=0;
           public int height(TreeNode root){
               if(root==null)return 0;
               int lh = height(root.left);
               int rh = height(root.right);
               ans = Math.max(ans,lh+rh);
               return 1+Math.max(lh,rh);
           }
           public int diameterOfBinaryTree(TreeNode root) {
               //int ans = 0;
               height(root);
               return ans;
           }
       }
}
