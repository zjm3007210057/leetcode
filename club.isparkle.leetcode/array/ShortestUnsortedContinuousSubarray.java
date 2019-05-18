package array;

import java.util.Arrays;

/**
 * 581. Shortest Unsorted Continuous Subarray
 *
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 *
 * Note:
 * 1. Then length of the input array is in range [1, 10,000].
 * 2.The input array may contain duplicates, so ascending order here means <=.
 *
 * Created by zjm on 2019/5/18.
 */
public class ShortestUnsortedContinuousSubarray {

    //copy nums as backup, sort nums at first, then compare with backup, find the different values from begin and end respectively
    public int findUnsortedSubarray(int[] nums) {
        if(nums == null || nums.length < 2) {
            return 0;
        }
        int[] arr = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        int left = 0;
        int right = nums.length - 1;
        while(left < right) {
            if(nums[left] == arr[left]) {
                left++;
            }
            if(nums[right] == arr[right]) {
                right--;
            }
            if(nums[left] != arr[left] && nums[right] != arr[right]) {
                break;
            }
        }
        if(left == right) {
            return 0;
        }
        return right -left + 1;
    }

    public int findUnsortedSubarrayBetter(int[] nums) {
        if(nums == null || nums.length < 2) {
            return 0;
        }
        int l = 0;
        int r = -1;
        int min = nums[nums.length - 1];
        int max = nums[0];
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[nums.length - 1 - i]);
            if(nums[i] < max) {
                r = i;
            }
            if(nums[nums.length - 1 - i] > min) {
                l = nums.length - 1 - i;
            }
        }
        return r - l + 1;
    }

}
