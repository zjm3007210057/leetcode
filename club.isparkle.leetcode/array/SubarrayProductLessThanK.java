package array;

/**
 * 713. Subarray Product Less Than K
 * <p>
 * Your are given an array of positive integers nums.
 * <p>
 * Count and print the number of (contiguous) subarrays where the product of all the elements in the subarray is less than k.
 * <p>
 * Example 1:
 * Input: nums = [10, 5, 2, 6], k = 100
 * Output: 8
 * Explanation: The 8 subarrays that have product less than 100 are: [10], [5], [2], [6], [10, 5], [5, 2], [2, 6], [5, 2, 6].
 * Note that [10, 5, 2] is not included as the product of 100 is not strictly less than k.
 * Note:
 * <p>
 * 0 < nums.length <= 50000.
 * 0 < nums[i] < 1000.
 * 0 <= k < 10^6.
 *
 * Created by zjm on 2019/6/27 21:56
 */
public class SubarrayProductLessThanK {

    //O(n^2)
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int res = 0, left = 0, right = 1;
        while(left < nums.length) {
            if(nums[left] < k) {
                res++;
                while(right < nums.length && nums[left] * nums[right] < k) {
                    nums[left] *= nums[right];
                    res++;
                    right++;
                }
            }
            left++;
            right = left + 1;
        }
        return res;
    }

    //use sliding-window, when add a number from right, eg. [5, 2] < 100, then,
    //add a number 6 from right the array become [5, 2, 6],
    //the res will add [6], [2, 6], [5, 2, 6] three subarrays, just equals the length of [5, 2, 6]
    public int numSubarrayProductLessThanKBetter(int[] nums, int k) {
        if(k < 2) {
            return 0;
        }
        int res = 0, left = 0, prod = 1;
        for(int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            while(prod >= k) {
                prod /= nums[left++];
            }
            res += i + 1 - left;
        }
        return res;
    }

}
