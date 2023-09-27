import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;
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
public class BinaryTreeLevelOrderTraversal {

    class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> q = new LinkedList<>();
        List<List<Integer>> ans = new ArrayList<>();
        if(root==null)return ans;
        // we will keep the push the root in the queue
        q.offer(root);
        // untill the queue is not empty do the following
        while(!q.isEmpty()){
            int size = q.size();
            List<Integer> res = new ArrayList<>();
            for(int i=0;i<size;i++){
                //remove the front ele from the queue and in the array
                // this will be our current level
                TreeNode top = q.peek();
                q.poll();
                res.add(top.val);
                // add if root's left is present in the queue
                if(top.left!=null){
                    q.offer(top.left);
                }
                // add if the root's right is present in the queue
                if(top.right!=null){
                    q.offer(top.right);
                }
            }
            //add the current level in the resultant array
            ans.add(res);
        }
        return ans;
    }
}
}
