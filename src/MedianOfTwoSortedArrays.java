public class MedianOfTwoSortedArrays {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums1 = { 1, 3 };
        int[] nums2 = { 2 };
        System.out.println(solution.findMedianSortedArrays(nums1, nums2));
    }

    static class Solution {
        public double findMedianSortedArrays(int[] nums1, int[] nums2) {
            int length = nums1.length + nums2.length;
            int half = length / 2;
            int[] A, B;
            if (nums1.length > nums2.length) {
                A = nums2;
                B = nums1;
            } else {
                A = nums1;
                B = nums2;
            }
            int l = 0, r = A.length;
            while (l <= r) {
                int midA = (l + r + 1) / 2;
                int midB = half - midA;

                int leftA = midA > 0 ? A[midA - 1] : Integer.MIN_VALUE;
                int rightA = midA < A.length ? A[midA] : Integer.MAX_VALUE;
                int leftB = midB > 0 ? B[midB - 1] : Integer.MIN_VALUE;
                int rightB = midB < B.length ? B[midB] : Integer.MAX_VALUE;

                if (leftA <= rightB && leftB <= rightA) {
                    if (length % 2 == 1) {
                        return rightA < rightB ? rightA : rightB;
                    } else {
                        int left = leftA > leftB ? leftA : leftB;
                        int right = rightA > rightB ? rightB : rightA;
                        return (double) (left + right) / 2;
                    }
                } else if (leftA > rightB) {
                    r = midA - 1;
                } else {
                    l = midA + 1;
                }
            }
            return 0.0;
        }
    }
}
