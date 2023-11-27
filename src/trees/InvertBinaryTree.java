package trees;

public class InvertBinaryTree {
    public static void main(String[] args) {
        TreeNode root = TreeNode.generateTree(new int[] {4,2,7,1,3,6,9});
        System.out.println(TreeNode.levelOrder(root));
        Solution solution = new Solution();
        solution.invertTree(root);
        System.out.println(TreeNode.levelOrder(root));
    }   
    
    static class Solution {
        public TreeNode invertTree(TreeNode root) {
            if (root != null) {
                invertRecursive(root);
            }
            return root;
        }
    
        private void invertRecursive(TreeNode curr) {
            TreeNode temp = curr.left;
            curr.left = curr.right;
            curr.right = temp;
            if (curr.left != null) {
                invertRecursive(curr.left);
            }
            if (curr.right != null) {
                invertRecursive(curr.right);
            } 
        }
    }

}
