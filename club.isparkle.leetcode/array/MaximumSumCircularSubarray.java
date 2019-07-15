package array;

/**
 * 918. Maximum Sum Circular Subarray
 * <p>
 * Given a circular array C of integers represented by A, find the maximum possible sum of a non-empty subarray of C.
 * <p>
 * Here, a circular array means the end of the array connects to the beginning of the array.  (Formally, C[i] = A[i]
 * when 0 <= i < A.length, and C[i+A.length] = C[i] when i >= 0.)
 * <p>
 * Also, a subarray may only include each element of the fixed buffer A at most once.  (Formally, for a subarray
 * C[i], C[i+1], ..., C[j], there does not exist i <= k1, k2 <= j with k1 % A.length = k2 % A.length.)
 * <p>
 * Example 1:
 * Input: [1,-2,3,-2]
 * Output: 3
 * Explanation: Subarray [3] has maximum sum 3
 *
 * Example 2:
 * Input: [5,-3,5]
 * Output: 10
 * Explanation: Subarray [5,5] has maximum sum 5 + 5 = 10
 *
 * Example 3:
 * Input: [3,-1,2,-1]
 * Output: 4
 * Explanation: Subarray [2,-1,3] has maximum sum 2 + (-1) + 3 = 4
 * Example 4:
 * Input: [3,-2,2,-3]
 * Output: 3
 * Explanation: Subarray [3] and [3,-2,2] both have maximum sum 3
 *
 * Example 5:
 * Input: [-2,-3,-1]
 * Output: -1
 * Explanation: Subarray [-1] has maximum sum -1
 * Note:
 * -30000 <= A[i] <= 30000
 * 1 <= A.length <= 30000
 *
 * Created by zjm on 2019/7/15 21:08
 */
public class MaximumSumCircularSubarray {

    //two conditions, one condition is subarray in middle of A and other condition is subarray
    //contains A[0] and A[A.length-1].
    //first condition is simple and the second condition result is total of A minus the min subarray
    public int maxSubarraySumCircular(int[] A) {
        if(A.length == 1) {
            return A[0];
        }
        int maxSum = Integer.MIN_VALUE, curMax = 0, total = 0;
        int minSum = Integer.MAX_VALUE, curMin = 0;
        for(int a : A) {
            curMax = Math.max(curMax + a, a);
            maxSum = Math.max(maxSum, curMax);
            curMin = Math.min(curMin + a, a);
            minSum = Math.min(minSum, curMin);
            total += a;
        }
        return maxSum > 0 ? Math.max(maxSum, total - minSum) : maxSum;
    }

}
