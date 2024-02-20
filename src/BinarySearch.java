public class BinarySearch {
    public static void main(String[] args) {
        int[] nums = {-1,0,3,5,9,12};
        int target = 9;
        Solution solution = new Solution();
        System.out.println(solution.search(nums, target));
        // Issue with adding in binary search 
        //System.out.println((Integer.MAX_VALUE/2 + 2 + Integer.MAX_VALUE/2)/2);
    }

    static class Solution {
        public int search(int[] nums, int target) {
            int l = 0, r = nums.length - 1;
            while (l<=r) {
                int mid = l + ((r-l)/2);
                if(nums[mid] == target) {
                    return mid;
                } else if (nums[mid]>target) {
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            return -1;
        }
    }
}
