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

    //采用暴力算法
    public static String longestPalindromeForce(String s) {
        char[] chars = s.toCharArray();
        char[] tmp = new char[chars.length * 2 + 1];
        int len = tmp.length;
        int start = 0;
        int end = 0;
        for(int i = 1; i < len; i+=2) {
            tmp[i] = chars[i/2];
        }
        for(int i = 0; i < len; i++) {
            int f = i;
            int l = i;
            while(f >= 0 && l < len && tmp[f--] == tmp[l++]);
            if(l - f - 2 > end - start) {
                start = f + 1;
                end = l - 1;
            }
            /*if(end - start > len / 2) {
                break;
            }*/
        }
        StringBuilder sb = new StringBuilder();
        for(int i = (start + 1) / 2; i < end / 2; i ++) {
            sb.append(chars[i]);
        }
        return sb.toString();
    }

    public static int longestPalindromeManacher(String s) {
        if(s == null || s.length() < 1) {
            return 0;
        }
        char[] arr = s.toCharArray();
        char[] chars = str2Manacher(arr);
        int len = chars.length;
        int[] pArr = new int[len]; //回文数组
        pArr[0] = 1;
        int last = 0; //回文半径最右边界
        int center = 0; //回文半径中心
        for(int i = 1; i < len; i++) {
            int right = last;
            if(i <= last) {
                pArr[i] = pArr[2 * center - i];
                if(pArr[2 * center - i] >= last - i) {
                    while(chars[right + 1] == chars[2 * i - right - 1]) {
                        pArr[i]++;
                        right++;
                    }
                }
            }else {
                for(int j = i + 1; j < len; j++) {
                    right = j;
                    if(2 * i > 0 &&  chars[j] != chars[2 * i - j]) {
                        break;
                    }
                }
                pArr[i] = right - center;
            }
            if(right - i > last - center) {
                last = right;
                center = i;
            }
        }
        return last - center - 1;
    }

    private static char[] str2Manacher(char[] arr) {
        char[] res = new char[arr.length * 2 + 1];
        for(int i = 0; i < res.length; i++) {
            if(i % 2 == 0) {
                res[i] = '#';
            }else {
                res[i] = arr[i / 2];
            }
        }
        return res;
    }

    public String help(char[] arr, int l, int r) {
        if(l == r) {
            return arr[l] + "";
        }
        return null;
    }

    public static void main(String[] args) {
        String s = "accc";
        String ss = longestPalindrome(s);
        System.out.println(longestPalindromeForce(s));
        System.out.println(ss);
        char[] chars = new char[5];
        System.out.println(chars[0]);
    }

}
