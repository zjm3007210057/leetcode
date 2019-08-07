package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 383. Ransom Note
 * <p>
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 * otherwise, it will return false.
 * <p>
 * Each letter in the magazine string can only be used once in your ransom note.
 * <p>
 * Note:
 * You may assume that both strings contain only lowercase letters.
 * <p>
 * canConstruct("a", "b") -> false
 * canConstruct("aa", "ab") -> false
 * canConstruct("aa", "aab") -> true
 * <p>
 * Created by zjm on 2019/8/7 22:51
 */
public class RansomNote {

    //用一个map来存ransomNote里面的每个字符，以重复的次数为value，然后依次删除magazine中的元素，如果最后map为空，则表示magazine可以构造ransomNote
    //因为ransomNote里面的每一个字符都能在magazine里面找到
    public boolean canConstruct(String ransomNote, String magazine) {
        if(magazine.length() < ransomNote.length()) {
            return false;
        }
        Map<Character, Integer> map = new HashMap();
        for(char c : ransomNote.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char c : magazine.toCharArray()) {
            Integer n = map.get(c);
            if(n != null && n > 1) {
                map.put(c, n - 1);
            }else {
                map.remove(c);
            }
        }
        if(map.size() > 0) {
            return false;
        }
        return true;
    }
}
