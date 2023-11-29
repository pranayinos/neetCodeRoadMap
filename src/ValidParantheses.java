import java.util.Stack;

public class ValidParantheses {
    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println(s.isValid("(){}[]"));
        System.out.println(s.isValid("(})"));
        System.out.println(s.isValid("({[]})"));
    }

    static class Solution {
        public boolean isValid(String s) {
            Stack<Character> charStack = new Stack<>();
            for (int i = 0; i < s.length(); i++) {
                char currChar = s.charAt(i);
                if (currChar == '{' || currChar == '(' || currChar == '[') {
                    charStack.push(currChar);
                } else if (charStack.empty()) {
                    return false;
                } else {
                    if (currChar == '}' && charStack.peek() != '{') {
                        return false;
                    } else if (currChar == ']' && charStack.peek() != '[') {
                        return false;
                    } else if (currChar == ')' && charStack.peek() != '(') {
                        return false;
                    }
                    charStack.pop();
                }
            }
            if (charStack.isEmpty()) {
                return true;
            }
            return false;
        }
    }

    static class SolutionII {
        public boolean isValid(String s) {
            Stack<Character> stack = new Stack<>();
            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                } else if (stack.isEmpty()) {
                    return false;
                } else {
                    switch (c) {
                        case ')':
                            if (stack.peek() == '(') {
                                stack.pop();
                            } else {
                                return false;
                            }
                            break;
                        case '}':
                            if (stack.peek() == '{') {
                                stack.pop();
                            } else {
                                return false;
                            }
                            break;
                        case ']':
                            if (stack.peek() == '[') {
                                stack.pop();
                            } else {
                                return false;
                            }
                            break;
                        default:
                            stack.push(c);
                    }
                }
            }
            if (stack.isEmpty()) {
                return true;
            }
            return false;
        }
    }
}
