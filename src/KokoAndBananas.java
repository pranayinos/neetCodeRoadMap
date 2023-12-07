import java.util.Arrays;

public class KokoAndBananas {
    public static void main(String[] args) {
        int[] piles = { 805306368, 805306368, 805306368 };
        int h = 1000000000;
        Solution solution = new Solution();
        System.err.println(solution.minEatingSpeed(piles, h));
    }

    static class Solution {
        public int minEatingSpeed(int[] piles, int h) {
            int max = Arrays.stream(piles).max().orElseThrow(RuntimeException::new);
            int l = 1, r = max;
            int res = max;
            while (l <= r) {
                int mid = l + ((r - l) / 2);
                if (willFinishAllBananasIn(piles, mid) > h) {
                    l = mid + 1;
                } else {
                    res = res < mid ? res : mid;
                    r = mid - 1;
                }
            }
            return res;
        }

        private int willFinishAllBananasIn(int[] piles, int rate) {
            int time = 0;
            for (int b : piles) {
                time = time + (b / rate);
                if (b % rate > 0) {
                    time = time + 1;
                }
            }
            if (time < 0) {
                time = Integer.MAX_VALUE;
            }
            return time;
        }
    }
}
