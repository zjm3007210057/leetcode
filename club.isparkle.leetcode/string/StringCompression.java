package string;

/**
 * 443. String Compression
 * <p>
 * Given an array of characters, compress it in-place.
 * <p>
 * The length after compression must always be smaller than or equal to the original array.
 * <p>
 * Every element of the array should be a character (not int) of length 1.
 * <p>
 * After you are done modifying the input array in-place, return the new length of the array.
 * <p>
 * <p>
 * Follow up:
 * Could you solve it using only O(1) extra space?
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input:
 * ["a","a","b","b","c","c","c"]
 * <p>
 * Output:
 * Return 6, and the first 6 characters of the input array should be: ["a","2","b","2","c","3"]
 * <p>
 * Explanation:
 * "aa" is replaced by "a2". "bb" is replaced by "b2". "ccc" is replaced by "c3".
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input:
 * ["a"]
 * <p>
 * Output:
 * Return 1, and the first 1 characters of the input array should be: ["a"]
 * <p>
 * Explanation:
 * Nothing is replaced.
 * <p>
 * <p>
 * Example 3:
 * <p>
 * Input:
 * ["a","b","b","b","b","b","b","b","b","b","b","b","b"]
 * <p>
 * Output:
 * Return 4, and the first 4 characters of the input array should be: ["a","b","1","2"].
 * <p>
 * Explanation:
 * Since the character "a" does not repeat, it is not compressed. "bbbbbbbbbbbb" is replaced by "b12".
 * Notice each digit has it's own entry in the array.
 * <p>
 * <p>
 * Note:
 * <p>
 * All characters have an ASCII value in [35, 126].
 * 1 <= len(chars) <= 1000
 *
 * Created by zjm on 2019/8/9 19:26
 */
public class StringCompression {

    //采用StringBuilder，最后注意需要将原数组值替换
    public int compress(char[] chars) {
        if(chars.length <= 1) {
            return chars.length;
        }
        StringBuilder sb = new StringBuilder();
        int tmp = 1;
        int i = 0;
        for(; i < chars.length - 1; i++) {
            sb.append(chars[i]);
            while(i < chars.length - 1 && chars[i] == chars[i+1]) {
                tmp++;
                i++;
            }
            if(tmp > 1) {
                sb.append(String.valueOf(tmp));
            }
            if(i == chars.length - 2 && chars[i] != chars[i+1]) {
                sb.append(chars[i+1]);
            }
            tmp = 1;
        }
        if(i == chars.length - 2) {
            sb.append(chars[i+1]);
        }
        char[] ch = sb.toString().toCharArray();
        for(int j = 0; j < sb.length(); j++) {
            chars[j] = ch[j];
        }
        return ch.length;
    }

}
