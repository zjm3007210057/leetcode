package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 387. First Unique Character in a String
 * <p>
 * Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
 * <p>
 * Examples:
 * <p>
 * s = "leetcode"
 * return 0.
 * <p>
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 * <p>
 * Created by zjm on 2019/8/8 20:36
 */
public class FirstUniqueCharacterInAString {

    //使用map存放s每个字符出现的次数，然后遍历找到第一个出现一次的字符即可
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap();
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(int i = 0; i < s.length(); i++) {
            if(map.get(s.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;
    }

    //分别获取字符a到z在s中的第一个索引和最后一个索引，如果第一个索引等于最后一个索引并且不等于-1，则表示该字符在s中只出现一次
    public int firstUniqCharBetter(String s) {
        if(s == null || s.isEmpty()) return -1;
        int min = Integer.MAX_VALUE;

        for(char c = 'a'; c <= 'z'; c++) {
            int first = s.indexOf(c);
            int last = s.lastIndexOf(c);

            if(first != -1 && first == last) {
                min = Math.min(min, first);
            }
        }
        return min == Integer.MAX_VALUE ? -1 : min;
    }

}
