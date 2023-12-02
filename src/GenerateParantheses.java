import java.util.ArrayList;
import java.util.List;

public class GenerateParantheses {
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.generateParenthesis(3));

        SolutionII solution = new SolutionII();
        System.out.println(solution.generateParenthesis(3));
        ;
    }

    static class Solution {
        private List<String> res = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            StringBuffer sb = new StringBuffer();
            backtrack(n, 0, 0, sb);
            return res;
        }

        private void backtrack(int n, int l, int r, StringBuffer sb) {
            if (l == n && r == n) {
                res.add(sb.toString());
                return;
            }
            if (l < n) {
                backtrack(n, l + 1, r, sb.append("("));
                sb.deleteCharAt(sb.length() - 1);
            }
            if (r < l) {
                backtrack(n, l, r + 1, sb.append(")"));
                sb.deleteCharAt(sb.length() - 1);
            }
        }
    }

    static class SolutionII {
        private List<String> res = new ArrayList<>();

        public List<String> generateParenthesis(int n) {
            char[] p = new char[2 * n];
            backtrackII(p, 2 * n);
            return res;
        }

        private void backtrackII(char[] p, int n) {
            if (n == 0) {
                String s = new String(p);
                if (isValid(s)) {
                    res.add(s);
                }
            } else {
                n = n - 1;
                p[n] = '(';
                backtrackII(p, n);
                p[n] = ')';
                backtrackII(p, n);
            }
        }

        private static boolean isValid(String curr) {
            int stackHeight = 0;
            for (int i = 0; i < curr.length(); i++) {
                if (curr.charAt(i) == '(') {
                    stackHeight++;
                } else if (stackHeight <= 0) {
                    return false;
                } else {
                    stackHeight--;
                }
            }
            if (stackHeight == 0) {
                return true;
            } else {
                return false;
            }
        }
    }
}
