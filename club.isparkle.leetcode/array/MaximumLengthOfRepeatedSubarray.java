package array;

/**
 * 718. Maximum Length of Repeated Subarray
 * <p>
 * Given two integer arrays A and B, return the maximum length of an subarray that appears in both arrays.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * A: [1,2,3,2,1]
 * B: [3,2,1,4,7]
 * Output: 3
 * Explanation:
 * The repeated subarray with maximum length is [3, 2, 1].
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= len(A), len(B) <= 1000
 * 0 <= A[i], B[i] < 100
 * <p>
 * Created by zjm on 2019/6/29 13:14
 */
public class MaximumLengthOfRepeatedSubarray {

    //use dps
    public int findLength(int[] A, int[] B) {
        if(A.length < 1 || B.length < 1) {
            return 0;
        }
        int[][] res = new int[A.length + 1][B.length + 1];
        int max = 0;
        for(int i = 1; i < res.length; i++) {
            for(int j = 1; j < res[0].length; j++) {
                res[i][j] = A[i-1] == B[j-1] ? (res[i-1][j-1] + 1) : 0;
                max = Math.max(max, res[i][j]);
            }
        }
        return max;
    }
}
