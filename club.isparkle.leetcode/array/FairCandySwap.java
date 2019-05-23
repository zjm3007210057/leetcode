package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 888. Fair Candy Swap
 *
 * Alice and Bob have candy bars of different sizes: A[i] is the size of the i-th bar of candy that Alice has, and B[j] is the size of the j-th bar of candy that Bob has.
 * Since they are friends, they would like to exchange one candy bar each so that after the exchange, they both have the same total amount of candy.  (The total amount of candy a person has is the sum of the sizes of candy bars they have.)
 * Return an integer array ans where ans[0] is the size of the candy bar that Alice must exchange, and ans[1] is the size of the candy bar that Bob must exchange.
 * If there are multiple answers, you may return any one of them.  It is guaranteed an answer exists.
 *
 * Example 1:
 * Input: A = [1,1], B = [2,2]
 * Output: [1,2]
 *
 * Example 2:
 * Input: A = [1,2], B = [2,3]
 * Output: [1,2]
 *
 * Example 3:
 * Input: A = [2], B = [1,3]
 * Output: [2,3]
 *
 * Example 4:
 * Input: A = [1,2,5], B = [2,4]
 * Output: [5,4]
 *
 * Note:
 * 1 <= A.length <= 10000
 * 1 <= B.length <= 10000
 * 1 <= A[i] <= 100000
 * 1 <= B[i] <= 100000
 * It is guaranteed that Alice and Bob have different total amounts of candy.
 * It is guaranteed there exists an answer.
 *
 * Created by zjm on 2019/5/23.
 */
public class FairCandySwap {

    //first, calculate the sum of A and B, respectively. Temporary variable tmp is sumA - sumB, if the element b in B plus
    // (sumA-sumB) / 2 equals the element a in A, then a and b is the result.
    public int[] fairCandySwap(int[] A, int[] B) {
        int[] res = new int[2];
        int tmp = 0;
        Set<Integer> set = new HashSet();
        if(A.length <= B.length) {
           for(int i = 0; i < A.length; i++) {
                tmp += A[i] - B[i];
                set.add(A[i]);
            }
            for(int j = A.length; j < B.length; j++) {
                tmp -= B[j];
            }
        }else {
            for(int i = 0; i < B.length; i++) {
                set.add(A[i]);
                tmp += A[i] - B[i];
            }
            for(int j = B.length; j < A.length; j++) {
                set.add(A[j]);
                tmp += A[j];
            }
        }
        for(int i = 0; i < B.length; i++) {
            if(set.contains(B[i] + tmp / 2)) {
                res[0] = B[i] + tmp / 2;
                res[1] = B[i];
                break;
            }
        }
        return res;
    }
}
