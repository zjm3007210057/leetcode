package array;

import java.util.Arrays;

/**
 * 905. Sort Array By Parity
 *
 * Given an array A of non-negative integers, return an array consisting of all the even elements of A, followed by all the odd elements of A.
 * You may return any answer array that satisfies this condition.
 *
 * Example 1:
 * Input: [3,1,2,4]
 * Output: [2,4,3,1]
 * The outputs [4,2,3,1], [2,4,1,3], and [4,2,1,3] would also be accepted.
 *
 * Note:
 * 1 <= A.length <= 5000
 * 0 <= A[i] <= 5000
 *
 * Created by zjm on 2019/5/23.
 */
public class SortArrayByParity {

    public int[] sortArrayByParity(int[] A) {
        int[] res = new int[A.length];
        int l = 0;
        int r = A.length - 1;
        int i = 0;
        while(i < A.length) {
            if(A[i] % 2 == 0) {
                res[l++] = A[i];
            }else {
                res[r--] = A[i];
            }
            i++;
        }
        return res;
    }
}
