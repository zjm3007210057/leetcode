package array;

/**
 * 977. Squares of a Sorted Array
 *
 * Given an array of integers A sorted in non-decreasing order, return an array of the squares of each number, also in sorted non-decreasing order.
 *
 * Example 1:
 * Input: [-4,-1,0,3,10]
 * Output: [0,1,9,16,100]
 *
 * Example 2:
 * Input: [-7,-3,2,3,11]
 * Output: [4,9,9,49,121]
 *
 * Note:
 * 1 <= A.length <= 10000
 * -10000 <= A[i] <= 10000
 * A is sorted in non-decreasing order
 *
 * Created by zjm on 2019/5/24.
 */
public class SquaresOfASortedArray {

    public int[] sortedSquares(int[] A) {
        int[] res = new int[A.length];
        int tmp = 0;
        for(int i = 0; i < A.length; i++) {
            if(A[i] >= 0) {
                tmp = i;
                break;
            }
        }
        int index = tmp - 1;
        int k = 0;
        while(index >= 0 && tmp < A.length) {
            if(A[tmp] + A[index] < 0)  res[k++] = A[tmp] * A[tmp++];
            else res[k++] = A[index] * A[index--];
        }
        while(index >= 0) {
            res[k++] = A[index] * A[index--];
        }
        while(tmp < A.length) {
            res[k++] = A[tmp] * A[tmp++];
        }
        return res;
    }
}