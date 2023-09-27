import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import javax.swing.tree.TreeNode;

//1 .we will keep one hashmap to keep track of the parent
//2. we will add the root in queue also mark it visited
// untill q is empty we will keep icrease our currdist if it is equal to k then stop
// we will get the curr node in queue check for its left,right,and parent and mark them visited if not visited 

public class AllNodesDistanceKinBinaryTree {
    /**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void mapParents(TreeNode root,HashMap<TreeNode,TreeNode> parent){
        Queue<TreeNode> temp = new LinkedList<>();
        temp.offer(root);
        while(!temp.isEmpty()){
            TreeNode curr = temp.peek();
            temp.poll();
            if(curr.left!=null){
                parent.put(curr.left,curr);
                temp.offer(curr.left);
            }
            if(curr.right!=null){
                parent.put(curr.right,curr);
                temp.offer(curr.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Queue<TreeNode> q = new LinkedList<>();
        HashMap<TreeNode,TreeNode> parent = new HashMap<>();
        HashMap<TreeNode,Boolean> vis = new HashMap<>();
        mapParents(root,parent);
        q.offer(target);
        vis.put(target,true);
        int dist = 0;
        while(!q.isEmpty()){
            int size = q.size();
            if(dist==k) break;
            dist++;
            for(int i=0;i<size;i++){
                TreeNode node = q.peek();
                q.poll();
                if(node.left!=null&&vis.get(node.left)==null){
                    q.offer(node.left);
                    vis.put(node.left,true);
                }
                if(node.right!=null&&vis.get(node.right)==null){
                    q.offer(node.right);
                    vis.put(node.right,true);
                }
                if(parent.get(node)!=null&&vis.get(parent.get(node))==null){
                    q.offer(parent.get(node));
                    vis.put(parent.get(node),true);
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while(!q.isEmpty()){
            TreeNode current =  q.poll();
            ans.add(current.val);
        }
        return ans;
    }
}
}
