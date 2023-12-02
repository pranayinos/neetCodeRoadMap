import java.util.Stack;

public class EvaluateRPN {
    public static void main(String[] args) {
        BetterSolution solution = new BetterSolution();
        String[] caseI = { "2", "1", "+", "3", "*" };
        String[] caseII = { "4", "13", "5", "/", "+" };
        String[] caseIII = { "10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+" };
        System.err.println(solution.evalRPN(caseIII));
    }

    static class BetterSolution {
        public int evalRPN(String[] tokens) {
            Stack<Integer> s = new Stack<>();
            for (String t : tokens) {
                switch (t) {
                    case "+":
                        int a = s.pop();
                        s.push(s.pop() + a);
                        break;
                    case "-":
                        a = s.pop();
                        s.push(s.pop() - a);
                        break;
                    case "*":
                        a = s.pop();
                        s.push(s.pop() * a);
                        break;
                    case "/":
                        a = s.pop();
                        s.push(s.pop() / a);
                        break;
                    default:
                        s.push(Integer.parseInt(t));
                }
            }
            return s.pop();
        }
    }

    static class Solution {
        public int evalRPN(String[] tokens) {
            Stack<String> stack = new Stack<>();
            for (int i = 0; i < tokens.length; i++) {
                if (!isAnOperand(tokens[i])) {
                    stack.push(tokens[i]);
                } else {
                    stack.push("" + performOperation(tokens[i], stack.pop(), stack.pop()));
                }
            }
            return Integer.parseInt(stack.pop());
        }

        private boolean isAnOperand(String n) {
            return (n.equals("+") || n.equals("-") || n.equals("*") || n.equals("/"));
        }

        private int performOperation(String operand, String one, String two) {
            int a = 0, b = 0;
            try {
                a = Integer.parseInt(two);
                b = Integer.parseInt(one);
            } catch (Exception e) {
                // Not possible
            }
            switch (operand) {
                case "+":
                    return a + b;
                case "-":
                    return a - b;
                case "*":
                    return a * b;
                case "/":
                    return a / b;
            }
            return 0;
        }
    }
}
