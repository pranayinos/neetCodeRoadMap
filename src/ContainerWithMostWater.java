public class ContainerWithMostWater {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] input = new int[] { 1,8,6,2,5,4,8,3,7 };
        System.out.println(sol.maxArea(input));
    }

    static class Solution {
        public int maxArea(int[] height) {
            // initialize left and right pointers to the extremes
            // to maximize width of the box containig water
            int leftPtr = 0, rightPtr = height.length - 1;
            int maxArea = 0;
    
            // loop while leftPtr < rightPtr which means length of the box is non zero
            // because if leftPtr == rightPtr, width will become 0, area will be 0
            while (leftPtr < rightPtr) {
                // assume current min height is left bound
                // we need min height here because water can be held only 
                // till the point its bounded on both side, so, min will be bottleneck
                int currentContainerHeight = height[leftPtr];
                
                // current width of container distance between left and right bound
                int currentContainerWidth = rightPtr - leftPtr;
                
                // check if left or right bound is higher
                if(height[leftPtr] > height[rightPtr]) {
                    // right bound is lower set container height to right bound
                    currentContainerHeight = height[rightPtr];
                    // decrement right pointer as the height is lower
                    // our aim is to maximize area, will prefer higher bound
                    rightPtr--;
                } else {
                    // left bound is lower increment left pointer, no need 
                    // to set container height as its assumed and set initially
                    leftPtr++;
                }
                int currentContainerArea = currentContainerWidth * currentContainerHeight;
                maxArea = currentContainerArea > maxArea ? currentContainerArea : maxArea;
            }
            return maxArea;
        }
    }
}
