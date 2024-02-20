package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrderTraversal {
    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        TreeNode root = new TreeNode(4, new TreeNode(3, null, null), new TreeNode(1, new TreeNode(7, null, null), new TreeNode(9, null, null))) ;
        System.out.println(s.levelOrder(root));
    }

    static class Solution {
        public List<List<Integer>> levelOrder(TreeNode root) {
            List<List<Integer>> res = new ArrayList<>();
            Queue<TreeNode> q = new LinkedList<TreeNode>();
            List<Integer> level = new ArrayList<>();
            q.offer(root);
            q.offer(null);
            while (!q.isEmpty()) {
                TreeNode c = q.poll();
                if (c != null) {
                    if(c.left!=null)
                        q.offer(c.left);
                    if(c.right!=null)
                        q.offer(c.right);
                    level.add(c.val);
                } else {
                    List<Integer> l = new ArrayList<>(level);
                    res.add(l);
                    level.clear();
                    if(!q.isEmpty()) {
                       q.offer(null);
                    } 
                }
            }
            return res;
        }
    }

    

}
