package string;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * 819. Most Common Word
 * <p>
 * Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.
 * It is guaranteed there is at least one word that isn't banned, and that the answer is unique.
 * <p>
 * Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not
 * case sensitive.  The answer is in lowercase.
 * <p>
 * Example:
 * <p>
 * Input:
 * paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
 * banned = ["hit"]
 * Output: "ball"
 * Explanation:
 * "hit" occurs 3 times, but it is a banned word.
 * "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph.
 * Note that words in the paragraph are not case sensitive,
 * that punctuation is ignored (even if adjacent to words, such as "ball,"),
 * and that "hit" isn't the answer even though it occurs more because it is banned.
 * <p>
 * Note:
 * <p>
 * 1 <= paragraph.length <= 1000.
 * 0 <= banned.length <= 100.
 * 1 <= banned[i].length <= 10.
 * The answer is unique, and written in lowercase (even if its occurrences in paragraph
 * may have uppercase symbols, and even if it is a proper noun.)
 * paragraph only consists of letters, spaces, or the punctuation symbols !?',;.
 * There are no hyphens or hyphenated words.
 * Words only consist of letters, never apostrophes or other punctuation symbols
 * <p>
 * Created by zjm on 2019/8/21 20:52
 */
public class MostCommonWord {

    //直接根据题意，先将banned添加到set当中，依次判断paragraph的每个字符，碰到非字母后将前面的字符串与set中的值进行比对，
    // 不在里面的话就加到map当中，最后找出map中的最大值对应的字符串即可
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> banSet = new HashSet();
        for(String ban : banned) {
            banSet.add(ban);
        }
        Map<String, Integer> map = new HashMap();
        StringBuilder sb = new StringBuilder();
        for(char c : paragraph.toCharArray()) {
            if(isCapital(c) == 0) {
                if(sb.length() > 0) {
                    String s = sb.toString();
                    if(!banSet.contains(s)) {
                        map.put(s, map.getOrDefault(s, 0) + 1);
                    }
                }
                sb = new StringBuilder();
            }else if(isCapital(c) == 1) {
                sb.append(c);
            }else {
                sb.append(toLower(c));
            }
        }
        if(sb.length() > 0) {
            String s = sb.toString();
            if(!banSet.contains(s)) {
                map.put(s, map.getOrDefault(s, 0) + 1);
            }
        }
        String res = null;
        int max = -1;
        for(Map.Entry<String, Integer> entry : map.entrySet()) {
            if(max < entry.getValue()) {
                max = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }

    //将大小字母转成小写
    private char toLower(char c) {
        return (char)(c + 'a' - 'A');
    }

    //小写字母返回1，大写字母返回2，非字母返回0
    private int isCapital(char c) {
        if(c - 'a' >= 0 && c - 'z' <= 0) {
            return 1;
        }
        if(c - 'A' >= 0 && c - 'Z' <= 0) {
            return 2;
        }
        return 0;
    }

}
