public class SearchInA2DMatrix {
    public static void main(String[] args) {
        int[][] input = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        int target = 4;
        int[][] input2 = { { 1 }, { 3 } };
        int target2 = 2;
        Solution solution = new Solution();
        System.out.println(solution.searchMatrix(input2, target2));
    }

    static class Solution {
        public boolean searchMatrix(int[][] matrix, int target) {
            int m = matrix.length;
            int n = matrix[0].length;
            int l = 0, r = m - 1;
            int m2 = 0;
            while (l <= r) {
                int mid = l + r - l / 2;
                if (matrix[mid][0] > target) {
                    r = mid - 1;
                } else if (matrix[mid][n - 1] < target) {
                    l = mid + 1;
                } else {
                    m2 = mid;
                    break;
                }
            }
            l = 0;
            r = n - 1;
            while (l <= r) {
                int mid = l + r - l / 2;
                if (matrix[m2][mid] == target) {
                    return true;
                } else if (matrix[m2][mid] > target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return false;
        }
    }
}
