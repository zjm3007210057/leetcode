package array;

/**
 * 33. Search in Rotated Sorted Array
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * You may assume no duplicate exists in the array.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 *
 * Created by zjm on 2019/5/28.
 */
public class SearchInRotatedSortedArray {

    //simple method O(n)
    public int search(int[] nums, int target) {
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == target) {
                return i;
            }
        }
        return -1;
    }

    //use binary search
    public static int searchByBinary(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while(l <= r) {
            mid = (r - l) / 2 + l;
            if(nums[mid] == target) {
                return mid;
            }
            if(nums[mid] < nums[r]) {
                if(nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }else {
                if(nums[mid] > target && nums[l] <= target) {
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
        }
        return -1;
    }

}
