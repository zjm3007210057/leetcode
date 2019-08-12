package string;

/**
 * 459. Repeated Substring Pattern
 * <p>
 * Given a non-empty string check if it can be constructed by taking a substring of it and appending multiple copies of the substring together. You may assume the given string consists of lowercase English letters only and its length will not exceed 10000.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 * Example 2:
 * <p>
 * Input: "aba"
 * Output: False
 * Example 3:
 * <p>
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 * <p>
 * Created by zjm on 2019/8/10 09:14
 */
public class RepeatedSubstringPattern {

    //直接根据题意采用暴力解法
    public boolean repeatedSubstringPattern(String s) {
        int loop;
        for(int i = 1; i < s.length() / 2 + 1; i++) {
            if(s.charAt(i) == s.charAt(0)) {
                loop = i;
                while(i < s.length() && s.charAt(i) == s.charAt(i % loop)) {
                    i++;
                }
                if(i == s.length() && i % loop == 0) {
                    return true;
                }else {
                    i = loop;
                }
            }
        }
        return false;
    }

    //将s根据每个因子划分子串，如果每个因子长度的子串重复可以组成s，则返回true
    public boolean repeatedSubstringPatternBetter(String s) {
        for(int i = s.length() / 2; i >= 1; i--) {
            if(s.length() % i == 0) {
                int index = s.length() / i;
                StringBuilder sb = new StringBuilder();
                for(int j = 0; j < index; j++) {
                    sb.append(s.substring(0, i));
                }
                if(sb.toString().equals(s)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean repeatedSubstringPatternBetter2(String s) {
        for(int i = s.length() / 2; i >= 1; i--) {
            if(s.length() % i == 0) {
                if(s.split(s.substring(0, i)).length == 0) {
                    return true;
                }
            }
        }
        return false;
    }

}
