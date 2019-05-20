package array;

/**
 * 674. Longest Continuous Increasing Subsequence
 *
 * Given an unsorted array of integers, find the length of longest continuous increasing subsequence (subarray).
 *
 * Example 1:
 * Input: [1,3,5,4,7]
 * Output: 3
 * Explanation: The longest continuous increasing subsequence is [1,3,5], its length is 3.
 * Even though [1,3,5,7] is also an increasing subsequence, it's not a continuous one where 5 and 7 are separated by 4.
 *
 * Example 2:
 * Input: [2,2,2,2,2]
 * Output: 1
 * Explanation: The longest continuous increasing subsequence is [2], its length is 1.
 *
 * Note: Length of the array will not exceed 10,000.
 *
 * Created by zjm on 2019/5/20.
 */
public class LongestContinuousIncreasingSubsequence {

    //use temporary variable tmp to store the continuous increasing subsequence, and the max of them is the result
    public int findLengthOfLCIS(int[] nums) {
        if(nums.length < 2) {
            return nums.length;
        }
        int tmp = 1;
        int res = 1;
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] > nums[i-1]) {
                tmp++;
            }else {
                res = Math.max(tmp, res);
                tmp = 1;
            }
        }
        return Math.max(res, tmp);
    }
}
