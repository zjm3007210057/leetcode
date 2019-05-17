package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 485. Max Consecutive Ones
 * <p>
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * <p>
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * <p>
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 * <p>
 * Note:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * <p>
 * Created by zjm on 2019/5/16.
 */
public class MaxConsecutiveOnes {

    //mark every 0 place, the number of consecutive 1s value is the gap between the two 0s.
    public int findMaxConsecutiveOnes(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        if (nums.length == 1) {
            if (nums[0] == 1) {
                return 1;
            }
            return 0;
        }
        List<Integer> zeros = new ArrayList();
        zeros.add(0);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeros.add(i);
            }
        }
        zeros.add(nums.length - 1);
        if (zeros.size() == 2) {
            return nums.length;
        } else {
            int res = Math.max(zeros.get(1) - zeros.get(0), zeros.get(zeros.size() - 1) - zeros.get(zeros.size() - 2));
            for (int i = 2; i < zeros.size() - 1; i++) {
                res = Math.max(res, zeros.get(i) - zeros.get(i - 1) - 1);
            }
            return res;
        }
    }

    //use a temporary variable tmp to store the number of consecutive 1s,
    //result is the max value of result and tmp.
    public int findMaxConsecutiveOnesBetter(int[] nums) {
        if (nums.length < 1) {
            return 0;
        }
        int res = 0;
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                tmp++;
            } else {
                res = Math.max(res, tmp);
                tmp = 0;
            }
        }
        return Math.max(res, tmp);
    }

}
