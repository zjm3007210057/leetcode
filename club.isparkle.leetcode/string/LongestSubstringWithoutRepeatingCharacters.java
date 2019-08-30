package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. Longest Substring Without Repeating Characters
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * Example 1:
 * Input: "abcabcbb"
 * Output: 3
 * Explanation: The answer is "abc", with the length of 3.
 *
 * Example 2:
 * Input: "bbbbb"
 * Output: 1
 * Explanation: The answer is "b", with the length of 1.
 *
 * Example 3:
 * Input: "pwwkew"
 * Output: 3
 * Explanation: The answer is "wke", with the length of 3.
 *
 * Note that the answer must be a substring, "pwke" is a subsequence and not a substring
 * <p>
 * Created by zjm on 2019/8/30 19:45
 */
public class LongestSubstringWithoutRepeatingCharacters {

    //采用双指针和map，每次往map中放入字符，判断字符是否已经存在，如果存在则更新左指针，结果为右指针和左指针之差的最大值
    public int lengthOfLongestSubstring(String s) {
        int res = 0;
        int l = 0;
        Map<Character, Integer> map = new HashMap();
        for(int i = 0; i < s.length(); i++) {
            Integer tmp = map.get(s.charAt(i));
            if(tmp != null && tmp >= l) {
                res = Math.max(res, i - l);
                l = tmp + 1;
            }else {
                res = Math.max(res, i - l + 1);
            }
            map.put(s.charAt(i), i);
        }
        return res;
    }

}
