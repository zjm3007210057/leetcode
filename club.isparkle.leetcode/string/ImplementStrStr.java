package string;

/**
 * 28. Implement strStr()
 * <p>
 * Implement strStr().
 * <p>
 * Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * <p>
 * Example 1:
 * <p>
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 * <p>
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 * Clarification:
 * <p>
 * What should we return when needle is an empty string? This is a great question to ask during an interview.
 * <p>
 * For the purpose of this problem, we will return 0 when needle is an empty string.
 * This is consistent to C's strstr() and Java's indexOf()
 * <p>
 * Created by zjm on 2019/7/31 20:59
 */
public class ImplementStrStr {

    //暴力解法
    public int strStr(String haystack, String needle) {
        if(needle.length() > haystack.length()) {
            return -1;
        }
        if(needle.length() == 0) {
            return 0;
        }
        for(int i = 0; i < haystack.length(); i++) {
            int p = i;
            int n = 0;
            while(p < haystack.length() && n < needle.length() && haystack.charAt(p++) == needle.charAt(n++)) {
                if(n == needle.length()) {
                    return i;
                }
            }
        }
        return -1;
    }
}
