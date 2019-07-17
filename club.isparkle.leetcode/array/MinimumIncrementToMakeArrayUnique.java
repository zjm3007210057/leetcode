package array;

import java.util.Arrays;

/**
 * 945. Minimum Increment to Make Array Unique
 *
 * Given an array of integers A, a move consists of choosing any A[i], and incrementing it by 1.
 * Return the least number of moves to make every value in A unique.
 *
 * Example 1:
 * Input: [1,2,2]
 * Output: 1
 * Explanation:  After 1 move, the array could be [1, 2, 3].
 *
 * Example 2:
 * Input: [3,2,1,2,1,7]
 * Output: 6
 * Explanation:  After 6 moves, the array could be [3, 4, 1, 2, 5, 7].
 * It can be shown with 5 or less moves that it is impossible for the array to have all unique values.
 *
 * Note:
 * 0 <= A.length <= 40000
 * 0 <= A[i] < 40000
 *
 * Created by zjm on 2019/7/17 20:47 PM
 */
public class MinimumIncrementToMakeArrayUnique {

    //sort A at first, the minimum incrementing sequence of A must be {..i, i+1,...n, n+1...}
    public int minIncrementForUnique(int[] A) {
        Arrays.sort(A);
        int res = 0;
        for(int i = 1; i < A.length; i++) {
            if(A[i] <= A[i-1]) {
                res += A[i-1] + 1 - A[i];
                A[i] = A[i-1] + 1;
            }
        }
        return res;
    }

    public int minIncrementForUnique2(int[] A) {
        int[] arr = new int[80000];
        int res = 0;
        for(int n : A) {
            if(arr[n] < 1) {
                arr[n] = 1;
            }else {
                int tmp = n;
                while(arr[tmp] == 1) {
                    tmp++;
                }
                res += tmp - n;
                arr[tmp] = 1;
            }
        }
        return res;
    }

}