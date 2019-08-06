package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 345. Reverse Vowels of a String
 * <p>
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * <p>
 * Example 1:
 * <p>
 * Input: "hello"
 * Output: "holle"
 * Example 2:
 * <p>
 * Input: "leetcode"
 * Output: "leotcede"
 * Note:
 * The vowels does not include the letter "y"
 * <p>
 * Created by zjm on 2019/8/6 22:26
 */
public class ReverseVowelsOfAString {

    //和翻转字符数组类似，只是排除非元音字符而已
    public String reverseVowels(String s) {
        if(s.length() <= 1) {
            return s;
        }
        Set<Character> set = new HashSet();
        set.add('a');
        set.add('o');
        set.add('e');
        set.add('i');
        set.add('u');
        set.add('A');
        set.add('O');
        set.add('E');
        set.add('I');
        set.add('U');
        int l = 0, r = s.length() - 1;
        char[] chars = s.toCharArray();
        while(l < r) {
            while(l < r && !set.contains(chars[l])) {
                l++;
            }
            while(r > l && !set.contains(chars[r])) {
                r--;
            }
            char c = chars[l];
            chars[l] = chars[r];
            chars[r] = c;
            l++;
            r--;
        }
        return new String(chars);
    }
}
