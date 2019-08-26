package string;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 937. Reorder Log Files
 * <p>
 * You have an array of logs.  Each log is a space delimited string of words.
 * <p>
 * For each log, the first word in each log is an alphanumeric identifier.  Then, either:
 * <p>
 * Each word after the identifier will consist only of lowercase letters, or;
 * Each word after the identifier will consist only of digits.
 * We will call these two varieties of logs letter-logs and digit-logs.
 * It is guaranteed that each log has at least one word after its identifier.
 * <p>
 * Reorder the logs so that all of the letter-logs come before any digit-log.
 * The letter-logs are ordered lexicographically ignoring identifier, with the identifier used in case of ties.
 * The digit-logs should be put in their original order.
 * <p>
 * Return the final order of the logs.
 * <p>
 * Example 1:
 * Input: ["a1 9 2 3 1","g1 act car","zo4 4 7","ab1 off key dog","a8 act zoo"]
 * Output: ["g1 act car","a8 act zoo","ab1 off key dog","a1 9 2 3 1","zo4 4 7"]
 * <p>
 * Note:
 * 0 <= logs.length <= 100
 * 3 <= logs[i].length <= 100
 * logs[i] is guaranteed to have an identifier, and a word after the identifier
 * <p>
 * Created by zjm on 2019/8/26 21:40
 */
public class ReorderLogFiles {

    //首先将logs的元素按照最后一个字符是否是字母来判断，如果是字母，该字符串放在新数组前，否则往新数组尾部放
    //然后将新数组前面的字母字符串根据id和content放入对象中，并根据content排序，然后再将对象重新放入最开始的新数组当中
    public String[] reorderLogFiles(String[] logs) {
        String[] arr = new String[logs.length];
        int l = 0, r = logs.length-1, index = r;
        while(l <= r) {
            if(isLetter(logs[index].charAt(logs[index].length() - 1))) {
                arr[l++] = logs[index];
            }else {
                arr[r--] = logs[index];
            }
            index--;
        }
        List<Log> letters = new ArrayList(l);
        for(String s : arr) {
            letters.add(new Log(s.substring(0, s.indexOf(" ")), s.substring(s.indexOf(" ") + 1)));
            if(letters.size() >= l) {
                break;
            }
        }
        Collections.sort(letters);
        index = 0;
        for(Log log : letters) {
            arr[index++] = log.id + " " + log.content;
        }
        return arr;
    }

    private boolean isLetter(char c) {
        if(c - 'a' >= 0 && c - 'z' <= 0) {
            return true;
        }
        if(c - 'A' >= 0 && c - 'Z' <= 0) {
            return true;
        }
        return false;
    }

    class Log implements Comparable<Log>{
		String id;
		String content;
		public Log(String i, String c) {
			id = i;
			content = c;
		}
		public int compareTo(Log o) {
			if(content.equals(o.content)) {
                return id.compareTo(o.id);
            }
			return content.compareTo(o.content);
		}
	}

}
