package array;

/**
 * 941. Valid Mountain Array
 *
 * Given an array A of integers, return true if and only if it is a valid mountain array.
 * Recall that A is a mountain array if and only if:
 * A.length >= 3
 * There exists some i with 0 < i < A.length - 1 such that:
 * A[0] < A[1] < ... A[i-1] < A[i]
 * A[i] > A[i+1] > ... > A[B.length - 1]
 *
 * Example 1:
 * Input: [2,1]
 * Output: false
 *
 * Example 2:
 * Input: [3,5,5]
 * Output: false
 *
 * Example 3:
 * Input: [0,3,2,1]
 * Output: true
 *
 * Note:
 * 0 <= A.length <= 10000
 * 0 <= A[i] <= 10000
 *
 * Created by zjm on 2019/5/24.
 */
public class ValidMountainArray {

    //be attention to both of the end elements
    public boolean validMountainArray(int[] A) {
        if(A.length < 3)  {
            return false;
        }
        if(A[0] > A[1]) return false;
        if(A[A.length-1] > A[A.length-2]) return false;
        int tmp = 0;
        for(int i = 1; i < A.length; i++) {
            if(A[i] < A[i-1]) {
                tmp = i;
                break;
            }else if(A[i] == A[i-1]) return false;
        }
        for(int i = tmp; i < A.length - 1; i++) {
            if(A[i] <= A[i+1]) return false;
        }
        return true;
    }
}
