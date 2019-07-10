package array;

import java.util.Stack;

/**
 * 907. Sum of Subarray Minimums
 * <p>
 * Given an array of integers A, find the sum of min(B), where B ranges over every (contiguous) subarray of A.
 * <p>
 * Since the answer may be large, return the answer modulo 10^9 + 7.
 * <p>
 * Example 1:
 * Input: [3,1,2,4]
 * Output: 17
 * Explanation: Subarrays are [3], [1], [2], [4], [3,1], [1,2], [2,4], [3,1,2], [1,2,4], [3,1,2,4].
 * Minimums are 3, 1, 2, 4, 1, 1, 2, 1, 1, 1.  Sum is 17.
 * <p>
 * Note:
 * 1 <= A.length <= 30000
 * 1 <= A[i] <= 30000
 * <p>
 * Created by zjm on 2019/7/9 22:27
 */
public class SumOfSubarrayMinimums {

    //res = sum(A[i] * f(i)), f(i) is the number of subarray which minimum value is A[i].
    //so we only need to calculate the value of f(i).
    //use two arrays left and right, left[i] is the longest value from left which all A[...] is less than A[i],
    //right[i] is the longest value from right which all A[...] is large or equals to A[i].
    //f(i) = (left[i] + 1) * (right[i] + 1).
    //eg.:
    //A = [3,1,2,4];
    //left + 1 = [1, 2, 1, 1]
    //right + 1 = [1, 3, 2, 1]
    //f = [1, 6, 2, 1]
    //res = 3 * 1 + 1 * 6 + 2 * 2 + 4 * 1 = 17
    public int sumSubarrayMins(int[] A) {
        int res = 0;
        int mod = (int) 1e9 + 7;
        int[] left = new int[A.length];
        int[] right = new int[A.length];
        Stack<int[]> stack = new Stack();
        stack.push(new int[]{Integer.MIN_VALUE, -1});
        for(int i = 0; i < A.length; i++) {
            while(stack.peek()[0] > A[i])
                stack.pop();
            left[i] = i - stack.peek()[1];
            stack.push(new int[]{A[i], i});
        }
        stack.clear();
        stack.push(new int[]{Integer.MIN_VALUE, A.length});
        for(int i = A.length - 1; i >= 0; i--) {
            while(stack.peek()[0] >= A[i])
                stack.pop();
            right[i] = stack.peek()[1] - i;
            stack.push(new int[]{A[i], i});
        }
        for(int i = 0; i < A.length; i++) {
            res = (res + A[i] * left[i] * right[i]) % mod;
        }
        return res;
    }

}
