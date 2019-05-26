package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 1018. Binary Prefix Divisible By 5
 *
 * Given an array A of 0s and 1s, consider N_i: the i-th subarray from A[0] to A[i] interpreted as a binary number
 * (from most-significant-bit to least-significant-bit.)
 * Return a list of booleans answer, where answer[i] is true if and only if N_i is divisible by 5.
 *
 * Example 1:
 * Input: [0,1,1]
 * Output: [true,false,false]
 * Explanation:
 * The input numbers in binary are 0, 01, 011; which are 0, 1, and 3 in base-10.  Only the first number is divisible by 5, so answer[0] is true.
 *
 * Example 2:
 * Input: [1,1,1]
 * Output: [false,false,false]
 *
 * Example 3:
 * Input: [0,1,1,1,1,1]
 * Output: [true,false,false,false,true,false]
 *
 * Example 4:
 * Input: [1,1,1,0,1]
 * Output: [false,false,false,false,false]
 *
 * Note:
 * 1 <= A.length <= 30000
 * A[i] is 0 or 1
 *
 * Created by zjm on 2019/5/26.
 */
public class BinaryPrefixDivisibleByFive {

    //not consider the length of A large than 32, since to any number: n << 32 will overflow
    public static List<Boolean> prefixesDivBy5Error(int[] A) {
        int[] arr = new int[A.length];
        arr[0] = A[0];
        for(int i = 1; i < A.length; i++) {
            arr[i] = (arr[i-1] << 1) + A[i];
        }
        List<Boolean> res = new ArrayList(A.length);
        for(int i = 0; i < A.length; i++) {
            res.add(arr[i] % 5 == 0);
        }
        return res;
    }

    //because (a * b + c) % d = ((a % d) * (b % d) + c % d) % d, so we can replace the pre-method arr[i] = (arr[i-1] << 1) + A[i] with mod = ((mod << 1) + A[i]) % 5
    public List<Boolean> prefixesDivBy5(int[] A) {
        List<Boolean> res = new ArrayList(A.length);
        int mod = 0;
        for(int i = 0; i < A.length; i++) {
            mod = ((mod << 1) + A[i]) % 5;
            res.add(mod == 0);
        }
        return res;
    }
}
