package array;

/**
 * Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.
 *
 * Example:
 * Input: [-2,1,-3,4,-1,2,1,-5,4],
 * Output: 6
 * Explanation: [4,-1,2,1] has the largest sum = 6
 *
 * Created by zjm on 2019/5/13.
 */
public class MaximumSubarray {

    public int maxSubArray(int[] nums) {
        if(null == nums || nums.length < 1) {
            return 0;
        }
        if(nums.length == 1) {
            return nums[0];
        }
        int sum = Integer.MIN_VALUE;
        int temp = 0;
        for(int i = 0; i < nums.length; i++) {
            temp += nums[i];
            if(temp < nums[i]) {
                temp = nums[i];
            }
            if(temp > sum) {
                sum = temp;
            }
        }
        return sum;
    }
}
