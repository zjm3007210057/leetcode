package string;

/**
 * https://leetcode.com/problems/regular-expression-matching/
 *
 * 10. Regular Expression Matching
 *
 * Given an input string (s) and a pattern (p), implement regular expression matching with support for '.' and '*' where:
 *
 * '.' Matches any single character.​​​​
 * '*' Matches zero or more of the preceding element.
 * The matching should cover the entire input string (not partial).
 *
 *
 *
 * Example 1:
 *
 * Input: s = "aa", p = "a"
 * Output: false
 * Explanation: "a" does not match the entire string "aa".
 * Example 2:
 *
 * Input: s = "aa", p = "a*"
 * Output: true
 * Explanation: '*' means zero or more of the preceding element, 'a'. Therefore, by repeating 'a' once, it becomes "aa".
 * Example 3:
 *
 * Input: s = "ab", p = ".*"
 * Output: true
 * Explanation: ".*" means "zero or more (*) of any character (.)".
 * Example 4:
 *
 * Input: s = "aab", p = "c*a*b"
 * Output: true
 * Explanation: c can be repeated 0 times, a can be repeated 1 time. Therefore, it matches "aab".
 * Example 5:
 *
 * Input: s = "mississippi", p = "mis*is*p*."
 * Output: false
 *
 * Constraints:
 *
 * 0 <= s.length <= 20
 * 0 <= p.length <= 30
 * s contains only lowercase English letters.
 * p contains only lowercase English letters, '.', and '*'.
 * It is guaranteed for each appearance of the character '*', there will be a previous valid character to match.
 *
 * Created by zjm on 2021/6/1 13:56
 */
public class RegularExpressionMatching {

    public boolean isMatch(String s, String p) {
        if(s == null || p == null) {
            return false;
        }
        char[] arr = s.toCharArray();
        char[] pat = p.toCharArray();
        return isValid(arr, pat) && isMatchForce(arr, pat, 0, 0);
    }

    //递归，arr从s开始的位置能否被pat从f开始的位置匹配上
    //默认规则，pat的f位置不为*，否则无法使用递归，因为不知道怎么用*开头的串去匹配，也就是*前面必须跟一个字符才行
    private boolean isMatchForce(char[] arr, char[] pat, int s, int f) {
        if(s == arr.length) {
            //pat匹配空串
            if(f == pat.length) {
                return true;
            }
            //(f, f+1) f+2.....必须匹配空串，只能是a*b*s*这种格式，也就是各一个字符有一个*
            if(f + 1 < pat.length && pat[f + 1] == '*') {
                return isMatchForce(arr, pat, s, f + 2);
            }
            return false;
        }
        if(f == pat.length) {
            return s == arr.length;
        }
        //s, f普通情况:
        // 如果f的下一个位置不为*，则pat的f位置必须和arr的s位置匹配上或者pat的f位置为点.且后面的字符都要匹配上
        if(f >= pat.length - 1 || pat[f+1] != '*') {
            return (arr[s] == pat[f] || pat[f] == '.') && isMatchForce(arr, pat, s + 1, f + 1);
        }
        //f+1的位置是*
        if(pat[f] != '.' && arr[s] != pat[f]) {
            return isMatchForce(arr, pat, s, f + 2);
        }
        //f+1的位置是*且arr[s]=pat[f]
        if(isMatchForce(arr, pat, s, f + 2)) {
            return true;
        }
        while(s < arr.length && (arr[s] == pat[f] || pat[f] == '.')) {
            if(isMatchForce(arr, pat, s + 1, f + 2)) {
                return true;
            }
            s++;
        }
        return false;
    }

    //有效性检查
    private boolean isValid(char[] arr, char[] pat) {
        for(char c : arr) {
            if(c == '.' || c == '*') {
                return false;
            }
        }
        for(int i = 0; i < pat.length; i++) {
            if(pat[i] == '*' && (i == 0 || pat[i-1] == '*')) {
                return false;
            }
        }
        return true;
    }

    public boolean isMatchDP(String s, String p) {
        if(s == null || p == null) {
            return false;
        }
        char[] arr = s.toCharArray();
        char[] pat = p.toCharArray();
        int[][] dp = new int[arr.length + 1][pat.length + 1];
        //dp[i][j]=-1表示该位置还没有计算过，=0表示已经计算过，但是返回false，=1表示计算过，返回true
        for(int i = 0; i <= arr.length; i++) {
            for(int j = 0; j <= pat.length; j++) {
                dp[i][j] = -1;
            }
        }
        return isValid(arr, pat) && isMatchDP(arr, pat, 0, 0, dp);
    }

    //递归转动态规划，返回前先设置缓存值（数组的值），然后再return
    private boolean isMatchDP(char[] arr, char[] pat, int s, int f, int[][] dp) {
        //使用缓存
        if(dp[s][f] != -1) {
            return dp[s][f] == 1;
        }
        //第一次计算

        if(s == arr.length) {
            //pat匹配空串
            if(f == pat.length) {
                dp[s][f] = 1;
                return true;
            }
            //(f, f+1) f+2.....必须匹配空串，只能是a*b*s*这种格式，也就是各一个字符有一个*
            if(f + 1 < pat.length && pat[f + 1] == '*') {
                boolean flag = isMatchDP(arr, pat, s, f + 2, dp);
                dp[s][f] = flag ? 1 : 0;
                return flag;
            }
            dp[s][f] = 0;
            return false;
        }
        if(f == pat.length) {
            dp[s][f] = 0;
            return false;
        }
        //s, f普通情况:
        // 如果f的下一个位置不为*，则pat的f位置必须和arr的s位置匹配上或者pat的f位置为点.且后面的字符都要匹配上
        if(f >= pat.length - 1 || pat[f+1] != '*') {
            boolean flag = (arr[s] == pat[f] || pat[f] == '.') && isMatchDP(arr, pat, s + 1, f + 1, dp);
            dp[s][f] = flag ? 1 : 0;
            return flag;
        }
        //f+1的位置是*
        if(pat[f] != '.' && arr[s] != pat[f]) {
            boolean flag = isMatchDP(arr, pat, s, f + 2, dp);
            dp[s][f] = flag ? 1 : 0;
            return flag;
        }
        //f+1的位置是*且arr[s]=pat[f]
        if(isMatchDP(arr, pat, s, f + 2, dp)) {
            dp[s][f] = 1;
            return true;
        }
        while(s < arr.length && (arr[s] == pat[f] || pat[f] == '.')) {
            if(isMatchDP(arr, pat, s + 1, f + 2, dp)) {
                dp[s][f] = 1;
                return true;
            }
            s++;
        }
        dp[s][f] = 0;
        return false;
    }
}
