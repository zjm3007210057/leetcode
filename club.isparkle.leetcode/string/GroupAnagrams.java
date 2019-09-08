package string;

import java.util.*;

/**
 * 49. Group Anagrams
 * <p>
 * Given an array of strings, group anagrams together.
 * <p>
 * Example:
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 * ["ate","eat","tea"],
 * ["nat","tan"],
 * ["bat"]
 * ]
 * Note:
 * <p>
 * All inputs will be in lowercase.
 * The order of your output does not matter.
 * <p>
 * Created by zjm on 2019/9/8 22:22
 */
public class GroupAnagrams {

    //用map来解决问题，首先字符一样但是排列顺序不同的字符串一组，
    //可以将所有的字符串里面的字符数组先排序，变成新的字符串，然后以此新字符串作为map的key，
    //然后挨个进行新字符串的比较，相同的话就将原来的字符串放到一个list里面，作为map的value，
    //最后依次将map中的value放入新的list当中即为所求结果
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList();
        Map<String, List<String>> map = new HashMap();
        for(String str : strs) {
            char[] cs = str.toCharArray();
            Arrays.sort(cs);
            String key = new String(cs);
            if(!map.containsKey(key)) {
                map.put(key, new ArrayList());
            }
            map.get(key).add(str);
        }
        for(List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }

    //使用长度为26的数组，分别对应26个个字符，然后将每个字符串里面的字符数组放到对应的数组里面，然后再按照上面的方法继续，
    //此方法不需要进行排序，但是每次都要遍历数组，也就是26次，比上面的第一种方法要慢一点
    public static List<List<String>> groupAnagrams2(String[] strs) {
        List<List<String>> res = new ArrayList();
        Map<String, List<String>> map = new HashMap();
        int[] arr = new int[26];
        for(String str : strs) {
            for(char c : str.toCharArray()) {
                arr[c-'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int i = 0; i < 26; i++) {
                if(arr[i] > 1) {
                    sb.append(arr[i] + "" + (char)(i + 'a'));
                }else if(arr[i] == 1) {
                    sb.append((char)(i + 'a'));
                }
                arr[i] = 0;
            }
            String s = sb.toString();
            if(!map.containsKey(s)) {
                map.put(s, new ArrayList());
            }
            map.get(s).add(str);
        }
        for(List<String> list : map.values()) {
            res.add(list);
        }
        return res;
    }

}
