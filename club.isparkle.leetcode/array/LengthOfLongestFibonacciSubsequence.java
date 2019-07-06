package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 873. Length of Longest Fibonacci Subsequence
 * <p>
 * A sequence X_1, X_2, ..., X_n is fibonacci-like if:
 * <p>
 * n >= 3
 * X_i + X_{i+1} = X_{i+2} for all i + 2 <= n
 * Given a strictly increasing array A of positive integers forming a sequence, find the length of the longest
 * fibonacci-like subsequence of A.  If one does not exist, return 0.
 * <p>
 * (Recall that a subsequence is derived from another sequence A by deleting any number of elements (including none) from A,
 * without changing the order of the remaining elements.  For example, [3, 5, 8] is a subsequence of [3, 4, 5, 6, 7, 8].)
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: [1,2,3,4,5,6,7,8]
 * Output: 5
 * Explanation:
 * The longest subsequence that is fibonacci-like: [1,2,3,5,8].
 * Example 2:
 * <p>
 * Input: [1,3,7,11,12,14,18]
 * Output: 3
 * Explanation:
 * The longest subsequence that is fibonacci-like:
 * [1,11,12], [3,11,14] or [7,11,18].
 * <p>
 * <p>
 * Note:
 * <p>
 * 3 <= A.length <= 1000
 * 1 <= A[0] < A[1] < ... < A[A.length - 1] <= 10^9
 * (The time limit has been reduced by 50% for submissions in Java, C, and C++.)
 * <p>
 * Created by zjm on 2019/7/6 16:28
 */
public class LengthOfLongestFibonacciSubsequence {

    //brute force
    public int lenLongestFibSubseq(int[] A) {
        if(A.length < 3) {
            return 0;
        }
        Set<Integer> set = new HashSet();
        for(int n : A) {
            set.add(n);
        }
        int res = 0, count;
        for(int i = 0; i < A.length; i++) {
            for(int j = i + 1; j < A.length; j++) {
                int sum = A[i] + A[j];
                int tmp = A[j];
                int swap;
                count = 2;
                while(set.contains(sum)) {
                    count++;
                    swap = sum;
                    sum += tmp;
                    tmp = swap;
                }
                res = Math.max(res, count);
            }
        }
        return res == 2 ? 0 : res;
    }
}
