package trees;

import java.util.ArrayList;
import java.util.List;

public class SumOfLeftLeaves {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new Integer[] {3,9,20,-1,-1,15,7});
        System.out.println(TreeNode.levelOrder(root));
        Solution solution = new Solution();
        System.out.println(solution.sumOfLeftLeaves(root));
    }

    static class Solution {
        List<Integer> leaves = new ArrayList<>();

        public int sumOfLeftLeaves(TreeNode root) {
            int sum = 0;
            recSum(root, sum);
            return leaves.stream().mapToInt(Integer::intValue).sum();
        }

        private void recSum(TreeNode root, int flag) {
            if (root.left == null  && root.right == null) {
                if (flag == 1) {
                    leaves.add(root.val);
                }
            }
            if (root.right != null) {
                recSum(root.right, 0);
            }
            if (root.left != null) {
                recSum(root.left, 1);
            }
        }
    }
}
