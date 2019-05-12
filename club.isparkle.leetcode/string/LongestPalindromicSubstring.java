package string;

import java.util.HashMap;
import java.util.Map;

/**
 * the 5th problem in leetcode
 * Created by zjm on 2018/5/9.
 */
public class LongestPalindromicSubstring {

    /**
     * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
     * e.g.1
     * input: "babad"
     * output: "bab"
     * e.g.2
     * input: "cbbd"
     * output: "bb"
     * @param s input string
     * @return
     */
    public static String longestPalindrome(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        if(s.length()  == 1){
            return s;
        }
        int length = s.length();
        int leftIndex = 0;
        int rightIndex = 0;
        int res = 0;
        int temp;
        int left;
        int right;
        Map<Character, Integer> map = new HashMap<Character, Integer>(length * 2);
        map.put(s.charAt(0), 0);
        for(int i=1; i<length; i++){
            if(map.get(s.charAt(i)) == null){
                map.put(s.charAt(i), i);
            }else {
                if(i - map.get(s.charAt(i)) == 1){
                    temp = 0;
                    left = map.get(s.charAt(i));
                    right = i;
                    while(left >= 0 && right < length){
                        if(s.charAt(left) == s.charAt(right)){
                            temp += 2;
                            left--;
                            right++;
                        }else {
                            break;
                        }
                    }
                    //consider the condition of the elements are the same
                    while(right < length){
                        if(s.charAt(right - 1) == s.charAt(right)){
                            temp++;
                            right++;
                            i = right;
                        }else {
                            break;
                        }
                    }
                    if(temp > res){
                        res = temp;
                        leftIndex = left + 1;
                        rightIndex = right - 1;
                    }
                }else if(i - map.get(s.charAt(i)) == 2){
                    temp = 1;
                    left = map.get(s.charAt(i));
                    right = i;
                    while(left >= 0 && right < length){
                        if(s.charAt(left) == s.charAt(right)){
                            left--;
                            right++;
                            temp += 2;
                        }else {
                            break;
                        }
                    }
                    if(temp > res){
                        res = temp;
                        leftIndex = left + 1;
                        rightIndex = right - 1;
                    }

                }else {
                    map.put(s.charAt(i), i);
                }
            }
        }
        return s.substring(leftIndex, rightIndex+1);
    }

    /**
     * find the longest repeat substring
     * e.g.1
     * input: absfeadefdqo   output:absfea
     * @param s
     * @return
     */
    public static String longestRepeatrome(String s) {
        if(s == null || s.length() < 1){
            return "";
        }
        if(s.length()  == 1){
            return s;
        }
        int length = s.length();
        int res = 0;
        int left = 0;
        int right = 0;
        int repeatLeft = 0;
        int repeatRight = 0;
        int repeat;
        Map<Character, Integer> map = new HashMap<Character, Integer>(length * 2);
        for(int i=0; i<length; i++){
            if(map.get(s.charAt(i)) == null){
                map.put(s.charAt(i), i);
            }else {
                repeat = 1;
                if(i - map.get(s.charAt(i)) > res){
                    left = map.get(s.charAt(i));
                    right = i;
                    if(i - map.get(s.charAt(i)) == 1){
                        repeatLeft = map.get(s.charAt(i));
                        repeatRight = i;
                        repeat++;
                    }
                    res = right - left;
                    map.put(s.charAt(i), i);
                }else {
                    if(i - map.get(s.charAt(i)) == 1){
                        repeatLeft = map.get(s.charAt(i));
                        repeatRight = i;
                        repeat++;
                    }else {
                        repeatLeft = i;
                    }
                }

                while(i < length - 1 && s.charAt(i) == s.charAt(i + 1)){
                    i++;
                    repeat++;
                    repeatRight = i;
                }
                if(repeat > (right - left)){
                    left = repeatLeft;
                    right = repeatRight;
                }
            }
        }
        return s.substring(left, right + 1);
    }

    public static void main(String[] args) {
        String s = "abcbe";
        String ss = longestPalindrome(s);
        System.out.println(ss);
    }

}
