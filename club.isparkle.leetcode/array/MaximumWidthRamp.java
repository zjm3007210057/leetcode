package array;

import java.util.Stack;

/**
 * 962. Maximum Width Ramp
 *
 * Given an array A of integers, a ramp is a tuple (i, j) for which i < j and A[i] <= A[j].
 * The width of such a ramp is j - i.
 * Find the maximum width of a ramp in A.  If one doesn't exist, return 0.
 *
 * Example 1:
 * Input: [6,0,8,2,1,5]
 * Output: 4
 * Explanation:
 * The maximum width ramp is achieved at (i, j) = (1, 5): A[1] = 0 and A[5] = 5.
 *
 * Example 2:
 * Input: [9,8,1,0,1,9,4,0,4,1]
 * Output: 7
 * Explanation:
 * The maximum width ramp is achieved at (i, j) = (2, 9): A[2] = 1 and A[9] = 1.
 *
 * Note:
 * 2 <= A.length <= 50000
 * 0 <= A[i] <= 50000
 *
 * Created by zjm on 2019/7/19 20:17 PM
 */
public class MaximumWidthRamp {

    public int maxWidthRamp(int[] A) {
        int res = 0;
        for(int i = 0; i < A.length; i++) {
            for(int j = A.length - 1; j >= i; j--) {
                if(A[i] <= A[j] && j - i > res) {
                    res = j - i;
                    if(res == A.length - 1) {
                        return res;
                    }
                }
            }
        }
        return res;
    }

    /**
     * Keep a decreasing stack.
     * For each number,
     * binary search the first smaller number in the stack.
     * When the number is smaller the the last,
     * push it into the stack.
     */
    public int maxWidthRampBetter(int[] A) {
        Stack<Integer> stack = new Stack();
        for(int i = 0; i < A.length; i++) {
            if(stack.isEmpty() || A[stack.peek()] > A[i]) {
                stack.add(i);
            }
        }
        int res = 0;
        for(int i = A.length - 1; i >= 0; i--) {
            while(!stack.isEmpty() && A[stack.peek()] <= A[i]) {
                res = Math.max(res, i - stack.pop());
            }
        }
        return res;
    }
}
