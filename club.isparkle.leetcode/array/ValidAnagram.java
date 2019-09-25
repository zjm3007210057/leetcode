package array;

import java.util.Arrays;

/**
 * 242. Valid Anagram
 * <p>
 * Given two strings s and t , write a function to determine if t is an anagram of s.
 * <p>
 * Example 1:
 * Input: s = "anagram", t = "nagaram"
 * Output: true
 *
 * Example 2:
 * Input: s = "rat", t = "car"
 * Output: false
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * <p>
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * <p>
 * Created by zjm on 2019/9/25 20:21
 */
public class ValidAnagram {

    /**
     * 先给两个字符数组排序，然后判断字符数组里的字符是否都相等
     */
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        char[] s1 = s.toCharArray();
        char[] t1 = t.toCharArray();
        Arrays.sort(s1);
        Arrays.sort(t1);
        for(int i = 0; i < s.length(); i++) {
            if(s1[i] != t1[i]) {
                return false;
            }
        }
        return true;
    }

    //使用整型数组来存储，因为都是小写字母，所以用长度位26个整型数组就行
    public boolean isAnagram2(String s, String t) {
        if(s.length() != t.length()) {
            return false;
        }
        int[] s1 = new int[26];
        int[] t1 = new int[26];
        for(int i = 0; i < s.length(); i++) {
            s1[s.charAt(i) - 'a']++;
            t1[t.charAt(i) - 'a']++;
        }
        for(int i = 0; i < 26; i++) {
            if(s1[i] != t1[i]) {
                return false;
            }
        }
        return true;
    }

}
