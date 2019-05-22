package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 830. Positions of Large Groups
 * <p>
 * In a string S of lowercase letters, these letters form consecutive groups of the same character.
 * For example, a string like S = "abbxxxxzyy" has the groups "a", "bb", "xxxx", "z" and "yy".
 * Call a group large if it has 3 or more characters.  We would like the starting and ending positions of every large group.
 * The final answer should be in lexicographic order.
 * <p>
 * Example 1:
 * Input: "abbxxxxzzy"
 * Output: [[3,6]]
 * Explanation: "xxxx" is the single large group with starting  3 and ending positions 6.
 * <p>
 * Example 2:
 * Input: "abc"
 * Output: []
 * Explanation: We have "a","b" and "c" but no large group.
 * <p>
 * Example 3:
 * Input: "abcdddeeeeaabbbcd"
 * Output: [[3,5],[6,9],[12,14]]
 * <p>
 * Note:  1 <= S.length <= 1000
 * <p>
 * created by zjm on 2019/5/22.
 */
public class PositionsOfLargeGroups {

    public List<List<Integer>> largeGroupPositions(String S) {
        List<List<Integer>> res = new ArrayList();
        int tmp = 1;
        for (int i = 1; i < S.length(); i++) {
            if (S.charAt(i) == S.charAt(i - 1)) {
                tmp++;
            } else {
                if (tmp > 2) {
                    addToList(res, i, tmp);
                }
                tmp = 1;
            }
        }
        if (tmp > 2) {
            addToList(res, S.length(), tmp);
        }
        return res;
    }

    public void addToList(List<List<Integer>> list, int index, int num) {
        List<Integer> tmp = new ArrayList(2);
        tmp.add(index - num);
        tmp.add(index - 1);
        list.add(tmp);
    }
}
