import java.util.Arrays;

public class TrappingRainWater {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] input = new int[] { 0,1,0,2,1,0,1,3,2,1,2,1 };
        System.out.println((sol.trap(input)));
    }
    
    static class Solution {
        public int trap(int[] height) {
            int res = 0;
            int[] leftMax = new int[height.length];
            int[] rightMax = new int[height.length];
            createLeftMaxAndRightMaxArray(height, leftMax, rightMax);
            System.out.println();
            // Arrays.stream(leftMax).forEach(System.out::println);
            Arrays.stream(rightMax).forEach(System.out::println);
            System.out.println();
            for (int i = 0; i < height.length - 1; i++) {
                int leftMaxC = 0;
                int rightMaxC = 0;
                if (i > 0) {
                    leftMaxC = leftMax[i - 1];
                }
                if (i < height.length - 1) {
                    rightMaxC = rightMax[i + 1];
                }
                int bound = leftMaxC < rightMaxC ? leftMaxC : rightMaxC;
                int capacity = bound - height[i];
                if (capacity > 0) {
                    res = res + capacity;
                }
            }
            return res;
        }

        private void createLeftMaxAndRightMaxArray(int[] height, int[] leftMax, int[] rightMax) {
            int length = height.length;
            leftMax[0] = height[0];
            rightMax[length - 1] = height[length - 1];
            for (int i = 1; i < length - 1; i++) {
                leftMax[i] = leftMax[i - 1] > height[i] ? leftMax[i - 1] : height[i];
            }
            for (int i = length - 2; i > 0; i--) {
                rightMax[i] = rightMax[i + 1] > height[i] ? rightMax[i + 1] : height[i];
            }
        }
    }
}
