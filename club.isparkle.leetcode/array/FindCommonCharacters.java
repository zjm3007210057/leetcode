package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 1002. Find Common Characters
 *
 * Given an array A of strings made only from lowercase letters, return a list of all characters that show up in all
 * strings within the list (including duplicates).  For example, if a character occurs 3 times in all strings but not 4 times,
 * you need to include that character three times in the final answer.
 * You may return the answer in any order.
 *
 * Example 1:
 * Input: ["bella","label","roller"]
 * Output: ["e","l","l"]
 *
 * Example 2:
 * Input: ["cool","lock","cook"]
 * Output: ["c","o"]
 *
 * Note:
 * 1 <= A.length <= 100
 * 1 <= A[i].length <= 100
 * A[i][j] is a lowercase letter
 *
 * Created by zjm on 2019/5/25.
 */
public class FindCommonCharacters {

    //all letters in A are lowercase, so we can use an integer array which length is 26 to store it
    public List<String> commonChars(String[] A) {
        int[][] arr = new int[A.length][26];
        for(int i = 0; i < A.length; i++) {
            for(char ca : A[i].toCharArray()) {
                arr[i][ca-'a']++;
            }
        }
        List<String> res = new ArrayList();
        for(int i = 0; i < arr[0].length; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < arr.length; j++) {
                min = Math.min(min, arr[j][i]);
            }
            for(int k = 0; k < min; k++) {
                res.add(((char)('a' + i)) + "");
            }
        }
        return res;
    }

}
