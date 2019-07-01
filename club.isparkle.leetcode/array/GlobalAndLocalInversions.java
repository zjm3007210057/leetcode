package array;

/**
 * 775. Global and Local Inversions
 *
 * We have some permutation A of [0, 1, ..., N - 1], where N is the length of A.
 *
 * The number of (global) inversions is the number of i < j with 0 <= i < j < N and A[i] > A[j].
 *
 * The number of local inversions is the number of i with 0 <= i < N and A[i] > A[i+1].
 *
 * Return true if and only if the number of global inversions is equal to the number of local inversions.
 *
 * Example 1:
 *
 * Input: A = [1,0,2]
 * Output: true
 * Explanation: There is 1 global inversion, and 1 local inversion.
 * Example 2:
 *
 * Input: A = [1,2,0]
 * Output: false
 * Explanation: There are 2 global inversions, and 1 local inversion.
 * Note:
 *
 * A will be a permutation of [0, 1, ..., A.length - 1].
 * A will have length in range [1, 5000].
 * The time limit for this problem has been reduced.
 *
 * Created by zjm on 2019/7/1 7:13 PM
 */
public class GlobalAndLocalInversions {

    //A[0],...,A[i-2] < A[i]
    public boolean isIdealPermutation(int[] A) {
        if(A.length < 1) {
            return false;
        }
        for(int i = 2; i < A.length; i++) {
            for(int j = 0; j < i-1; j++) {
                if(A[j] > A[i]) {
                    return false;
                }
            }
        }
        return true;
    }

    //find the maximum value max in A[0],...A[i-2] and compare max with A[i]
    //if max > A[i], then return false
    public boolean isIdealPermutationBetter(int[] A) {
        if(A.length < 1) {
            return false;
        }
        int max = A[0];
        for(int i = 0; i < A.length - 2; i++) {
            max = Math.max(max, A[i]);
            if(max > A[i+2]) {
                return false;
            }
        }
        return true;
    }

    //since A contains 0,...,n-1, that means A[i] must in the index of i-1, i or i+1 in A
    public boolean isIdealPermutationFast(int[] A) {
        for(int i = 0; i < A.length; i++) {
            if(A[i] - i > 1 || i - A[i] > 1) {
                return false;
            }
        }
        return true;
    }
}
