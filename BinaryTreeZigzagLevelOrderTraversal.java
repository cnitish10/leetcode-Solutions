import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class BinaryTreeZigzagLevelOrderTraversal {
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
    // same as level order traversal just keep a track of flag variable , if it is false reverse the level array
    class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        ArrayList<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        boolean direction = false;

        if ( root == null ) return ans;

        q.add( root );

        while ( !q.isEmpty() ) {
            ArrayList<Integer> list = new ArrayList<>();
            int size = q.size();
            
            for( int i = 0; i < size; i++) {
                TreeNode node = q.peek();
                q.poll();
                list.add( node.val );

                if( node.left != null )
                    q.add(node.left);

                if( node.right != null )
                    q.add(node.right);

                if ( i == size -1 && direction )
                    Collections.reverse(list);
            }
            ans.add(list);
            direction = !direction;
        }
        return ans;
    }
}
}
