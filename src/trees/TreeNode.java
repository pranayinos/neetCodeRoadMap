package trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

///  Definition for a binary tree node.
public class TreeNode {
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

    public static TreeNode generateTree(int[] levelOrderTravrsal) {
        int count = 0;
        Queue<TreeNode> q = new LinkedList<>();
        TreeNode root = new TreeNode(levelOrderTravrsal[0]);
        q.add(root);
        TreeNode cur = null;
        for (int i = 1; i < levelOrderTravrsal.length; i++) {
            TreeNode node = new TreeNode(levelOrderTravrsal[i]);
            if (count == 0) {
                cur = q.poll();
            }
            if (count == 0) {
                count++;
                cur.left = node;
            } else {
                count = 0;
                cur.right = node;
            }
            if (levelOrderTravrsal[i] != '#') {
                q.offer(node);
            }
        }
        return root;
    }

    public static List<Integer> levelOrder(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                result.add(node.val);
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return result;
    }
}
