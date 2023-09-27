import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class BinaryTreePreorderTraversal {
    // root , left ,right
        public void preorder(TreeNode root,List<Integer> ans){
        if(root==null)return;
        ans.add(root.val);
        preorder(root.left,ans);
        preorder(root.right,ans);
    }
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        preorder(root,ans);
        return ans;
    }
}
