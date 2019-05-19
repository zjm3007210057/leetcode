package array;

import java.util.Arrays;

/**
 * 628. Maximum Product of Three Numbers
 *
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 *
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 *
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 *
 * Note:
 * 1.The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * 2.Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 *
 * Created by zjm on 2019/5/19.
 */
public class MaximumProductOfThreeNumbers {

    //sort nums
    public int maximumProduct(int[] nums) {
        if(nums.length < 3) {
            return 0;
        }
        if(nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        Arrays.sort(nums);
        int res = nums[0] * nums[1] * nums[nums.length - 1];
        res = Math.max(res, nums[nums.length - 3] * nums[nums.length - 2] * nums[nums.length - 1]);
        return res;
    }

    public int maximumProductBetter(int[] nums) {
        if(nums.length < 3) {
            return 0;
        }
        if(nums.length == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        int max = -1001;
        int sec = -1001;
        int third = -1001;
        int min1 = 1001;
        int min2 = 1001;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= max) {
                third = sec;
                sec = max;
                max = nums[i];
            }else if(nums[i] >= sec) {
                third = sec;
                sec = nums[i];
            }else if(nums[i] > third) {
                third = nums[i];
            }

            if(nums[i] <= min1) {
                min2 = min1;
                min1 = nums[i];
            }else if(nums[i] < min2) {
                min2 = nums[i];
            }
        }
        return Math.max(max * sec * third, max * min1 * min2);
    }
}
