public class ValidPalindrome {
    public static void main(String[] args) {
        Solution sol = new Solution();
        String input = "ABcBA";
        System.out.println(sol.isPalindrome(input));
    }
}
class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length()-1;
        s = s.toLowerCase();
        while (i<=j) {
            char leftChar = s.charAt(i);
            char rightChar = s.charAt(j);
            if (isAlphaNumeric(leftChar)) {
                i++;
                continue;
            }
            if (isAlphaNumeric(rightChar)){
                j--;
                continue;
            }
            if (leftChar != rightChar) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean isAlphaNumeric(char c) {
        return ('a' > c || 'z' < c) && ('0' > c || '9' < c);
    }
}