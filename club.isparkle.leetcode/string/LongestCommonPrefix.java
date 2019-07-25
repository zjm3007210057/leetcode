package string;

/**
 * 14. Longest Common Prefix
 * <p>
 * Write a function to find the longest common prefix string amongst an array of strings.
 * If there is no common prefix, return an empty string "".
 * <p>
 * Example 1:
 * <p>
 * Input: ["flower","flow","flight"]
 * Output: "fl"
 * Example 2:
 * <p>
 * Input: ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 *
 * Note:
 * All given inputs are in lowercase letters a-z.
 * <p>
 * Created by zjm on 2019/7/25 19:46
 */
public class LongestCommonPrefix {

    //根据题意直接判断就行，注意隐藏的特殊条件
    public String longestCommonPrefix(String[] strs) {
        //数组长度为0
        if(strs.length == 0) {
            return "";
        }
        //数组长度为1
        if(strs.length == 1) {
            return strs[0];
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs[0].length() && i < strs[1].length(); i++) {
            if(strs[0].charAt(i) == strs[1].charAt(i)) {
                sb.append(strs[0].charAt(i));
            }else {
                break;
            }
        }
        if(sb.length() < 1) {
            return "";
        }
        for(int i = 2; i < strs.length; i++) {
            if(strs[i].length() < 1) {
                return "";
            }
            //防止出现["abc", "abc", "ab"]这种情况
            if(strs[i].length() < sb.length()) {
                sb.delete(strs[i].length(), sb.length());
            }
            for(int j = 0; j < sb.length() && j < strs[i].length(); j++) {
                if(strs[i].charAt(j) != sb.charAt(j)) {
                    sb.delete(j, sb.length());
                }
            }
        }
        return sb.toString();
    }

}
