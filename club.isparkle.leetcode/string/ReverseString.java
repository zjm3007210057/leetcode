package string;

/**
 * 344. Reverse String
 * <p>
 * Write a function that reverses a string. The input string is given as an array of characters char[].
 * <p>
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 * <p>
 * You may assume all the characters consist of printable ascii characters.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: ["h","e","l","l","o"]
 * Output: ["o","l","l","e","h"]
 * Example 2:
 * <p>
 * Input: ["H","a","n","n","a","h"]
 * Output: ["h","a","n","n","a","H"]
 * <p>
 * Created by zjm on 2019/8/6 21:50
 */
public class ReverseString {

    //首位交换
    public void reverseString(char[] s) {
        if(s.length <= 1) {
            return;
        }
        int l = 0, r = s.length - 1;
        char tmp;
        while(l < r) {
            tmp = s[l];
            s[l] = s[r];
            s[r] = tmp;
            l++;
            r--;
        }
    }
}
