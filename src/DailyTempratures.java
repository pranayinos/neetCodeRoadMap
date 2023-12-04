import java.util.Arrays;
import java.util.Stack;

public class DailyTempratures {
    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ip = { 73, 74, 75, 71, 69, 72, 76, 73 };
        int[] ip2 = { 30, 40, 50, 60 };
        System.out.println(Arrays.toString(solution.dailyTemperatures(ip2)));
    }

    static class Solution {
        public int[] dailyTemperatures(int[] temperatures) {
            int[] res = new int[temperatures.length];
            Stack<Element> stack = new Stack<>();
            for (int i = 0; i < temperatures.length; i++) {
                while (!stack.isEmpty() && stack.peek().temp < temperatures[i]) {
                    Element e = stack.pop();
                    res[e.index] = (i - e.index);

                }
                stack.push(new Element(temperatures[i], i));
            }
            return res;
        }

        class Element {
            int temp;
            int index;

            public Element(int temp, int index) {
                this.temp = temp;
                this.index = index;
            }
        }
    }
}
