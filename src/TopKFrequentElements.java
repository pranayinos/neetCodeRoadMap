import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TopKFrequentElements {
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] input = new int[] { 1 };
        int target = 1;
        System.out.println(Arrays.toString(sol.topKFrequent(input, target)));
    }

    static class Solution {
        public int[] topKFrequent(int[] nums, int k) {
            Map<Integer, Integer> elementFrequencyMap = new HashMap<>();
            for (int i : nums)
            elementFrequencyMap.merge(i, 1, Integer::sum);//For Getting Frequency

            List<List<Integer>> frequencyBuckets = new ArrayList();
            for (int i = 0; i < nums.length; i++) {
                frequencyBuckets.add(i, new ArrayList<>());
            }
            for (Map.Entry<Integer, Integer> var : elementFrequencyMap.entrySet()) {
                frequencyBuckets.get(var.getValue() - 1).add(var.getKey());
            }
            List<Integer> result = new ArrayList();
            int j = 0;
            for (int i = nums.length - 1; i >= 0; i--) {
                List<Integer> eList = frequencyBuckets.get(i);
                if (!eList.isEmpty()) {
                    result.addAll(eList);
                    j = j + eList.size();
                }
                if (j == k)
                    break;
            }
            return result.stream()
                    .mapToInt(Integer::intValue)
                    .toArray();
        }
    }
}
