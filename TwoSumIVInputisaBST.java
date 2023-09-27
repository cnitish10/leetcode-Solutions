import java.util.Stack;

import javax.swing.tree.TreeNode;

// we will use two iterator here next and  before , which will give us  the first and last element of inorder traversalof bst
// once we get that we can find two elemetns whose sum is target if they are return next and before
// if greater , call before
// if less , call next do this untill next crosses before 

public class TwoSumIVInputisaBST {
   class Solution {
    public boolean findTarget(TreeNode root, int k) {
        if(root==null) return false;
        BSTIterator l=new BSTIterator(root,false);
        BSTIterator r=new BSTIterator(root,true);
        int i=l.next();
        int j=r.next();
        while(i<j){
            int sum=i+j;
            if(sum==k) return true;
            else if(sum<k) i=l.next();
            else j=r.next();
        }
        return false;
    }
}
public class BSTIterator{
    Stack<TreeNode> st=new Stack<>();
    boolean reverse;
    public  BSTIterator(TreeNode root,boolean isreverse){
        reverse=isreverse;
        addelements(root);
    }
    public void addelements(TreeNode root){
        while(root!=null){
            st.push(root);
            if(reverse){
                root=root.right;
            }
            else root=root.left;
        }
    }
    public int next(){
        TreeNode node=st.pop();
        if(reverse){
            addelements(node.left);
        }
        else addelements(node.right);
        return node.val; 
    }
    public boolean hasnext(){
        return !st.isEmpty();
    }
} 
}
