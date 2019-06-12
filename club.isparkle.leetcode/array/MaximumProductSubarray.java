package array;

/**
 * 152. Maximum Product Subarray
 * <p>
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.
 * <p>
 * Example 1:
 * <p>
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * Example 2:
 * <p>
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray
 *
 * Created by zjm on 2019/6/12 21:28
 */
public class MaximumProductSubarray {

    //use max keeping track of the largest product and also use min to keep track of the smallest product.
    //because the smallest product may the largest negative and it can be largest when it multiplied a negative number.
    //use res as the result and it is the larger number in max and res
    public int maxProduct(int[] nums) {
        if(nums.length < 1) {
            return 0;
        }
        int max = nums[0], min = nums[0], res = nums[0];
        for(int i = 1; i < nums.length; i++) {
            int mx = max, mn = min;
            max = Math.max(Math.max(nums[i], mx * nums[i]), mn * nums[i]);
            min = Math.min(Math.min(nums[i], mx * nums[i]), mn * nums[i]);
            res = Math.max(max, res);
        }
        return res;
    }
}
