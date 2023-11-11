import java.util.Arrays;

public class TwoSumII {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] input = new int[]{2, 7, 11, 15};
        int target = 9;
        System.out.println(Arrays.toString(sol.twoSum(input, target)));
    }

    static class Solution {
        public int[] twoSum(int[] numbers, int target) {
            int i = 0, j = numbers.length-1;
            int[] result = new int[2];
            while (i < j) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i+1; result[1] = j+1;
                    break;
                } else if (numbers[i] + numbers[j] > target) {
                    j--;
                } else {
                    i++;
                }
            }
            return result;
        }
}

}
