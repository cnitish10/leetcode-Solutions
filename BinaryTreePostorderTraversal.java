import java.util.ArrayList;
import java.util.List;

import javax.swing.tree.TreeNode;

public class BinaryTreePostorderTraversal {
    // left , right , root
        public void postorder(TreeNode root,List<Integer> ans){
        if(root==null)return;
        postorder(root.left,ans);
        postorder(root.right,ans);
        ans.add(root.val);
    }
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        postorder(root,ans);
        return ans;
    }
}
