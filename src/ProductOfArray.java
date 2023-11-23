import java.util.Arrays;

public class ProductOfArray {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] input = new int[] { 1, 2, 3, 4 };
        System.out.println(Arrays.toString(sol.productExceptSelf(input)));
    }

    static class Solution {
        public int[] productExceptSelf(int[] nums) {
            int ipSize = nums.length;
            int[] prefixProduct = new int[ipSize];
            int[] postfixProduct = new int[ipSize];
            prefixProduct[0] = nums[0];
            postfixProduct[ipSize - 1] = nums[ipSize - 1];
            for (int i = 1; i < ipSize; i++) {
                prefixProduct[i] = prefixProduct[i - 1] * nums[i];
                postfixProduct[ipSize - 1 - i] = postfixProduct[ipSize - i] * nums[ipSize - i - 1];
            }
            nums[0] = postfixProduct[1];
            nums[ipSize - 1] = prefixProduct[ipSize - 2];
            for (int i = 1; i < ipSize - 1; i++) {
                nums[i] = postfixProduct[i + 1] * prefixProduct[i - 1];
            }
            return nums;
        }
    }
}
