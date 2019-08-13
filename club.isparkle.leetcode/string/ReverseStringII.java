package string;

/**
 * 541. Reverse String II
 * <p>
 * Given a string and an integer k, you need to reverse the first k characters for every
 * 2k characters counting from the start of the string. If there are less than k characters
 * left, reverse all of them. If there are less than 2k but greater than or equal to k
 * characters, then reverse the first k characters and left the other as original.
 *
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 *
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 * <p>
 * Created by zjm on 2019/8/13 20:16
 */
public class ReverseStringII {

    //每2k个字符来遍历原字符串s，然后进行翻转，翻转的结尾位置取i+k和末尾位置之间的较小值
    public String reverseStr(String s, int k) {
        if(s.length() <= k) {
            return new StringBuilder(s).reverse().toString();
        }
        char[] chars = s.toCharArray();
        for(int i = 0; i < s.length(); i += 2 * k) {
            int l = i;
            int r = Math.min(i + k - 1, s.length() - 1);
            while(l < r) {
                char tmp = chars[l];
                chars[l] = chars[r];
                chars[r] = tmp;
                l++;
                r--;
            }
        }
        return new String(chars);
    }

}
