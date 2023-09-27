import java.util.Stack;

import javax.swing.tree.TreeNode;

// we will keep one stack and push all the elements in left untill it reaches null
// next will be out stack top, pop it
// if there is any right to it then push all left of that right one

public class BinarySearchTreeIterator {
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
class BSTIterator {
    Stack<TreeNode> st;
    public void pushAll(TreeNode root){
        while(root!=null){
            st.push(root);
            root=root.left;
        }
    }
    public BSTIterator(TreeNode root) {
        st=new Stack<>();
        pushAll(root);
    }
    
    public int next() {
        TreeNode top = st.peek();
        st.pop();
        pushAll(top.right);
        return top.val;
    }
    
    public boolean hasNext() {
        return !st.isEmpty();
    }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
}
