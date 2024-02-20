import java.util.Arrays;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"dog, flower","flow","flight"};
        System.out.println(longestCommonPrefix(strs));
        strs[1] = "flo";
        System.out.println(longestCommonPrefix2(strs));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++)
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }

    public static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) return "";
        Arrays.sort(strs);
        System.out.println(Arrays.toString(strs));
        int idx = 0;
        while (idx < strs[0].length() && strs[0].charAt(idx) == strs[strs.length - 1].charAt(idx)) idx++;//Compare First and Last String
        String prefix = strs[0].substring(0, idx);
        return prefix;
    }
}
