package array;

/**
 * 795. Number of Subarrays with Bounded Maximum
 * <p>
 * We are given an array A of positive integers, and two positive integers L and R (L <= R).
 * <p>
 * Return the number of (contiguous, non-empty) subarrays such that the value of the maximum
 * array element in that subarray is at least L and at most R.
 * <p>
 * Example :
 * Input:
 * A = [2, 1, 4, 3]
 * L = 2
 * R = 3
 * Output: 3
 * Explanation: There are three subarrays that meet the requirements: [2], [2, 1], [3].
 * Note:
 * <p>
 * L, R  and A[i] will be an integer in the range [0, 10^9].
 * The length of A will be in the range of [1, 50000]
 * <p>
 * Created by zjm on 2019/7/3 19:30
 */
public class NumberOfSubarraysWithBoundedMaximum {

    //use brute force
    public static int numSubarrayBoundedMax(int[] A, int L, int R) {
        int res = 0;
        int index;
        for(int i = 0; i < A.length; i++) {
            if(A[i] > R) continue;
            if(A[i] >= L && A[i] <= R) {
                index = i + 1;
                res++;
                while(index < A.length && A[index] <= R) {
                    res++;
                    index++;
                }
            }else {
                index = i + 1;
                while(index < A.length && A[index] < L) {
                    index++;
                }
                int tmp = index;
                while(tmp < A.length && A[tmp] <= R) {
                    res += index - i;
                    tmp++;
                }
                i = index - 1;
            }
        }
        return res;
    }

    //
    public int numSubarrayBoundedMaxBetter(int[] A, int L, int R) {
        return countBlowN(A, R) - countBlowN(A, L-1);
    }

    public int countBlowN(int[] arr, int n) {
        int count = 0, tmp = 0;
        for(int a : arr) {
            if(a <= n) {
                tmp++;
                count += tmp;
            }else {
                tmp = 0;
            }
        }
        return count;
    }
}
