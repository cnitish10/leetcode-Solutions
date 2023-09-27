// we will take one gloabal ans  , while calculating the max height of tree we will update this ans as max of ans and lh+rh+root.val and instead of returning 1+lh,rh ka max we willl return root.val+max(lh,rh) and ignoring the neg sum
public class BinaryTreeMaximuPathSum {
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
        public int ans=Integer.MIN_VALUE;
        public int solve(TreeNode root){
            if(root==null)return 0;
            int lh = Math.max(0,solve(root.left));
            int rh = Math.max(0,solve(root.right));
            ans = Math.max(ans,lh+rh+root.val);
            return Math.max(lh,rh)+root.val;
        }
        public int maxPathSum(TreeNode root) {
            
            int res = solve(root);
            return ans;
        }
    }
}
