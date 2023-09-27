// if either any of tree is null return false,if both null return true or check if root.val is same for both and recursively call left and right sub tree of both
public class SameTree {
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
        public boolean isSameTree(TreeNode p, TreeNode q) {
            if(p==null&&q!=null||p!=null&&q==null)return false;
            if(p==null&&q==null)return true;
            return p.val==q.val&&isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
        }
    }
}
