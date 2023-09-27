import javax.swing.tree.TreeNode;

// we know that inorder traversal of bst is sorted 
// using this property we will do inorder traversal we will keep four nodes first last middle ,prev
// all will be null ecept prev it will be minimum no
//whenever our node is less than prev which means this is one of the index if we didnt find any idex till now ,this will be first
// if we found anpther index which is greater than prev this will be our last index , in that case we assign this to last ,and swap with first
// if we didnt find any second voilation then middle will be used to swap which means two adjacent elements were swapped 

public class RecoverBinarySearchTree {
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
    TreeNode first;
    TreeNode middle;
    TreeNode last;
    TreeNode prev;
    
    public void inorder(TreeNode root){
        if(root==null) return ;
        inorder(root.left);
        
        if(prev!=null&&(root.val<prev.val)){
            if(first==null){
                first=prev;
                middle = root;
            }
            else{
                last=root;
            }
        }
        prev=root;
        inorder(root.right);
    }
    public void recoverTree(TreeNode root) {
        first = middle=last = null;
        prev = new TreeNode(Integer.MIN_VALUE);
        inorder(root);
        if(first!=null&&last!=null){
            int t = first.val;
            first.val = last.val;
            last.val = t;
        }
        else if(first!=null&&middle!=null){
            int t = first.val;
            first.val = middle.val;
            middle.val = t;
        }
        
    }
}
}
