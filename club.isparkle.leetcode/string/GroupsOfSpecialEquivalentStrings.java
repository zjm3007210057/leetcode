package string;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 893. Groups of Special-Equivalent Strings
 *
 * You are given an array A of strings.
 *
 * Two strings S and T are special-equivalent if after any number of moves, S == T.
 *
 * A move consists of choosing two indices i and j with i % 2 == j % 2, and swapping S[i] with S[j].
 *
 * Now, a group of special-equivalent strings from A is a non-empty subset S of A such that any string not in S is not special-equivalent with any string in S.
 *
 * Return the number of groups of special-equivalent strings from A.
 *
 * Example 1:
 *
 * Input: ["a","b","c","a","c","c"]
 * Output: 3
 * Explanation: 3 groups ["a","a"], ["b"], ["c","c","c"]
 * Example 2:
 *
 * Input: ["aa","bb","ab","ba"]
 * Output: 4
 * Explanation: 4 groups ["aa"], ["bb"], ["ab"], ["ba"]
 * Example 3:
 *
 * Input: ["abc","acb","bac","bca","cab","cba"]
 * Output: 3
 * Explanation: 3 groups ["abc","cba"], ["acb","bca"], ["bac","cab"]
 * Example 4:
 *
 * Input: ["abcd","cdab","adcb","cbad"]
 * Output: 1
 * Explanation: 1 group ["abcd","cdab","adcb","cbad"]
 *
 * Note:
 * 1 <= A.length <= 1000
 * 1 <= A[i].length <= 20
 * All A[i] have the same length.
 * All A[i] consist of only lowercase letters
 *
 * @date 2019/8/25 上午8:37
 */
public class GroupsOfSpecialEquivalentStrings {

    //分别将A中的每一个字符串对应的奇偶字符做排序，然后合并生成新的字符串
    //再将新的字符串放入set当中，最后set的大小就是结果
    //解释：题中要求字符串在交换位置时不变，且奇数位只能和奇数位交换，偶数位只能和偶数位交换，
    //所以需要将字符串分离成两个字符数组，奇数位数组和偶数位数组，然后排序，再将两数组合并成新的字符串，
    //此时新的字符串就是奇偶位都经过排序后的字符串，然后判断新的字符串是否内容相同，如果不同则可以组成不同的分组
    public int numSpecialEquivGroups(String[] A) {
        String[] arr = new String[A.length];
        int index = 0;
        for(String s : A) {
            char[] cs1 = new char[s.length() / 2];
            //偶数位数组的长度为s的长度加1然后除以二；比如字符串"123"，长度为3，偶数位数组为{'1', '3'}
            char[] cs2 = new char[(s.length() + 1) / 2];
            for(int i = 0; i < s.length(); i += 2) {
                cs2[i/2] = s.charAt(i);
            }
            for(int i = 1; i < s.length(); i += 2) {
                cs1[i/2] = s.charAt(i);
            }
            Arrays.sort(cs1);
            Arrays.sort(cs2);
            char[] cs = new char[s.length()];
            for(int i = 0; i < s.length(); i++) {
                if(i % 2 == 0) {
                    cs[i] = cs2[i/2];
                }else {
                    cs[i] = cs1[i/2];
                }
            }
            arr[index++] = new String(cs);
        }
        Set<String> set = new HashSet();
        for(String s : arr) {
            set.add(s);
        }
        return set.size();
    }

}
