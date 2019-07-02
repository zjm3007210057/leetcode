package array;

import java.util.ArrayList;

/**
 * 792. Number of Matching Subsequences
 * <p>
 * Given string S and a dictionary of words words, find the number of words[i] that is a subsequence of S.
 * <p>
 * Example :
 * Input:
 * S = "abcde"
 * words = ["a", "bb", "acd", "ace"]
 * Output: 3
 * Explanation: There are three words in words that are a subsequence of S: "a", "acd", "ace".
 * Note:
 * <p>
 * All words in words and S will only consists of lowercase letters.
 * The length of S will be in the range of [1, 50000].
 * The length of words will be in the range of [1, 5000].
 * The length of words[i] will be in the range of [1, 50]
 * <p>
 * Created by zjm on 2019/7/2 21:53
 */
public class NumberOfMatchingSubsequences {

    public int numMatchingSubseq(String S, String[] words) {
        char[] chars = S.toCharArray();
        ArrayList<Integer>[] arr = new ArrayList[26];
        for(int i = 0; i < 26; i++) {
            arr[i] = new ArrayList();
        }
        for(int i = 0; i < chars.length; i++) {
            arr[chars[i] - 'a'].add(i);
        }
        int res = 0;
        for(String w : words) {
            if(contains(arr, w)) {
                res++;
            }
        }
        return res;
    }

    private boolean contains(ArrayList<Integer>[] arr, String w) {
        int tmp = -1;
        for(char c : w.toCharArray()) {
            tmp = find(arr[c-'a'], c, tmp + 1);
            if(tmp == -1) {
                return false;
            }
        }
        return true;
    }

    private int find(ArrayList<Integer> list, char c, int index) {
        if(list.size() < 1) {
            return -1;
        }
        int l = 0;
        int r = list.size() - 1;
        int mid;
        while(l < r) {
            mid = (r - l) / 2 + l;
            int midPos = list.get(mid);
            if (midPos == index) return index;
            if (midPos < index) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }
        if (list.get(r) >= index ) return list.get(r);
        return -1;
    }
}
