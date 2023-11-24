import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {

    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] input = new int[] { -1, 0, 1, 2, -1, -4 };
        sol.threeSum(input).stream()
                .map(l -> l.stream().toArray(Integer[]::new))
                .forEach(array -> System.out.println(Arrays.toString(array)));
        // System.out.println(Arrays.toString(array));
    }

    static class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            List<List<Integer>> res = new ArrayList<>();
            Arrays.sort(nums);
            for (int x = 0; x < nums.length - 2; x++) {
                if (x > 0 && nums[x] == nums[x - 1]) {
                    continue;
                }
                int target = -1 * nums[x];
                int i = x + 1, j = nums.length - 1;
                while (i < j) {
                    int currSum = nums[i] + nums[j];
                    if (currSum == target) {
                        List<Integer> trip = new ArrayList<>();
                        trip.add(nums[x]);
                        trip.add(nums[i]);
                        trip.add(nums[j]);
                        res.add(trip);
                        i++;
                        while (i < j && nums[i] == nums[i - 1]) {
                            i++;
                        }
                    } else if (currSum < target) {
                        i++;
                    } else {
                        j--;
                    }
                }
            }
            return res;
        }
    }
}
