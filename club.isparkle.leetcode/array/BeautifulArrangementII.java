package array;

/**
 * 667. Beautiful Arrangement II
 * <p>
 * Given two integers n and k, you need to construct a list which contains n different
 * positive integers ranging from 1 to n and obeys the following requirement:
 * Suppose this list is [a1, a2, a3, ... , an], then the list [|a1 - a2|, |a2 - a3|,
 * |a3 - a4|, ... , |an-1 - an|] has exactly k distinct integers.
 * <p>
 * If there are multiple answers, print any of them.
 * <p>
 * Example 1:
 * Input: n = 3, k = 1
 * Output: [1, 2, 3]
 * Explanation: The [1, 2, 3] has three different positive integers ranging from 1 to 3,
 * and the [1, 1] has exactly 1 distinct integer: 1.
 * Example 2:
 * Input: n = 3, k = 2
 * Output: [1, 3, 2]
 * Explanation: The [1, 3, 2] has three different positive integers ranging from 1 to 3,
 * and the [2, 1] has exactly 2 distinct integers: 1 and 2.
 * Note:
 * The n and k are in the range 1 <= k < n <= 104
 *
 * Created by zjm on 2019/6/25 23:03
 */
public class BeautifulArrangementII {

    //find the rule of the sequence, if k = 10 and n is a number bigger than 10,
    //then the sequence is 1 11 2 10 3 9 4 8 5 7 6 12....
    //sequence satisfy a1=1, a2-a1=10, a2-a3=9, a4-a3=8....
    public int[] constructArray(int n, int k) {
        int[] res = new int[n];
        if(k >= n) {
            return new int[]{};
        }
        for(int i = 0; i <= k; i++) {
            if(i % 2 == 0) {
                res[i] = (i + 2) / 2;
            }else {
                res[i] = (k + 2) - (i + 1) / 2;
            }
        }
        for(int i = k + 1; i < n; i++) {
            res[i] = i + 1;
        }
        return res;
    }

}
