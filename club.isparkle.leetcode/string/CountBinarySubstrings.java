package string;

/**
 * 696. Count Binary Substrings
 * <p>
 * Give a string s, count the number of non-empty (contiguous) substrings that have the same number of 0's and 1's,
 * and all the 0's and all the 1's in these substrings are grouped consecutively.
 * <p>
 * Substrings that occur multiple times are counted the number of times they occur.
 * <p>
 * Example 1:
 * Input: "00110011"
 * Output: 6
 * Explanation: There are 6 substrings that have equal number of consecutive 1's and 0's: "0011", "01", "1100", "10", "0011", and "01".
 * <p>
 * Notice that some of these substrings repeat and are counted the number of times they occur.
 * <p>
 * Also, "00110011" is not a valid substring because all the 0's (and 1's) are not grouped together.
 * Example 2:
 * Input: "10101"
 * Output: 4
 * Explanation: There are 4 substrings: "10", "01", "10", "01" that have equal number of consecutive 1's and 0's.
 * Note:
 * <p>
 * s.length will be between 1 and 50,000.
 * s will only consist of "0" or "1" characters
 * <p>
 * Created by zjm on 2019/8/19 21:07
 */
public class CountBinarySubstrings {

    public int countBinarySubstrings(String s) {
        int index = 0, res = 0, pre = -1;
        while(index < s.length()) {
            int tmp = index;
            char c = s.charAt(index);
            //统计相同字符的个数
            while(index < s.length() && s.charAt(index) == c) {
                index++;
            }
            int cur = index - tmp;
            if(pre != -1) {
                //对相邻连续子串的较小值进行求和
                res += Math.min(pre, cur);
            }
            pre = cur;
        }
        return res;
    }

    //上一种方法的改进，省去了内部循环计数的操作，而直接遍历一次通过交换两个相邻连续子串长度的方法，每次res只加1，而不是加相邻计数的较小值
    public int countBinarySubstringsBetter(String s) {
        int pre = 0, cur = 1, res = 0;
        for(int i = 1; i < s.length(); i++) {
            if(s.charAt(i) == s.charAt(i-1)) {
                cur++;
            }else {
                pre = cur;
                cur = 1;
            }
            if(pre >= cur) {
                res++;
            }
        }
        return res;
    }
}
