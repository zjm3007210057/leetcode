package string;

import java.util.Arrays;
import java.util.TreeMap;

/**
 * 1170. Compare Strings by Frequency of the Smallest Character
 * <p>
 * Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s.
 * For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.
 * Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of
 * words such that f(queries[i]) < f(W), where W is a word in words.
 * <p>
 * Example 1:
 * Input: queries = ["cbd"], words = ["zaaaz"]
 * Output: [1]
 * Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
 *
 * Example 2:
 * Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
 * Output: [1,2]
 * Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").
 * <p>
 * Constraints:
 * 1 <= queries.length <= 2000
 * 1 <= words.length <= 2000
 * 1 <= queries[i].length, words[i].length <= 10
 * queries[i][j], words[i][j] are English lowercase letters
 * <p>
 * Created by zjm on 2019/8/28 20:15
 */
public class CompareStringsByFrequencyOfTheSmallestCharacter {

    //采用排序和二分法
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] q = new int[queries.length];
        for (int i = 0; i < q.length; ++i) {
            q[i] = f(queries[i]);
        }

        int[] w = new int[words.length];
        for (int i = 0; i < w.length; ++i) {
            w[i] = f(words[i]);
        }

        Arrays.sort(w);
        int[] res = new int[q.length];
        for (int i = 0; i < res.length; ++i) {
            int idx = find(w, q[i]);
            res[i] = w[idx] > q[i] ? w.length - idx : 0;
        }
        return res;
    }

    // 二分法查找大于key的第一个索引
    int find(int[] arr, int key) {
        int l = 0;
        int r = arr.length - 1;
        while (l < r) {
            int mid = (l - r) / 2 + r;
            if (arr[mid] <= key) {
                l = mid + 1;
            }else {
                r = mid;
            }
        }

        return l;
    }

    int f(String s) {
        int n = 1;
        char max = 'z';
        for(char c : s.toCharArray()) {
            if(c - max == 0) {
                n++;
            }else if(c - max < 0){
                max = c;
                n = 1;
            }
        }
        return n;
    }

}
