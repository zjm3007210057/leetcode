package array;

/**
 * 926. Flip String to Monotone Increasing
 * <p>
 * A string of '0's and '1's is monotone increasing if it consists of some number of '0's (possibly 0),
 * followed by some number of '1's (also possibly 0.)
 * <p>
 * We are given a string S of '0's and '1's, and we may flip any '0' to a '1' or a '1' to a '0'.
 * <p>
 * Return the minimum number of flips to make S monotone increasing.
 * <p>
 * Example 1:
 * Input: "00110"
 * Output: 1
 * Explanation: We flip the last digit to get 00111.
 *
 * Example 2:
 * Input: "010110"
 * Output: 2
 * Explanation: We flip to get 011111, or alternatively 000111.
 *
 * Example 3:
 * Input: "00011000"
 * Output: 2
 * Explanation: We flip to get 00000000.
 *
 * Note:
 * 1 <= S.length <= 20000
 * S only consists of '0' and '1' characters.
 * <p>
 * Created by zjm on 2019/7/16 20:56
 */
public class FlipStringToMonotoneIncreasing {

    //there is must an point makes all the left elements are 0 and right elements are 1
    //use two arrays left and right. left[i] storage the number of element 1 in A which index from 0 to i-1.
    //right[i] storage the number of element 0 in A which index from i to A.length.
    //the result is the minimum of left[i] plus right[i].
    public int minFlipsMonoIncr(String S) {
        int[] left = new int[S.length() + 1];
        int[] right = new int[S.length() + 1];
        int leftZero = 0, rightZero = 0;
        for(int i = 0; i < S.length(); i++) {
            if(S.charAt(i) == '1') {
                left[i+1] = ++leftZero;
            }else {
                left[i+1] = leftZero;
            }
        }
        for(int i = S.length() - 1; i >= 0; i--) {
            if(S.charAt(i) == '0') {
                right[i] = ++rightZero;
            }else {
                right[i] = rightZero;
            }
        }
        int res = Integer.MAX_VALUE;
        for(int i = 0; i < left.length; i++) {
            if(res > left[i] + right[i]) {
                res = left[i] + right[i];
            }
        }
        return res;
    }

    //use only one array arr, arr[i] is the sum elements 0 in A which index from 0 to i-1.
    //the result is the minimum of arr[i] + (S.length - i - (arr[S.length] - arr[i))
    public int minFlipsMonoIncrBetter(String S) {
        int[] arr = new int[S.length()+1];
        for(int i = 1; i < arr.length; i++) {
            arr[i] = arr[i-1] + S.charAt(i-1) - '0';
        }
        int res = Integer.MAX_VALUE;
        for(int i = 1; i < arr.length; i++) {
            int left = arr[i - 1];
            int right = (S.length() - i + 1 - (arr[S.length()] - arr[i - 1]));
            if(res > left + right) {
                res = left + right;
            }
        }
        return Math.min(res, arr[S.length()]);
    }
}
