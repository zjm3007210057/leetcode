package array;

/**
 * 81. Search in Rotated Sorted Array II
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 *
 * You are given a target value to search. If found in the array return true, otherwise return false.
 *
 * Example 1:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * Example 2:
 *
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * Follow up:
 *
 * This is a follow up problem to Search in Rotated Sorted Array, where nums may contain duplicates.
 * Would this affect the run-time complexity? How and why?
 *
 * Created by zjm on 2019/6/11 1:52 PM
 */
public class SearchInRotatedSortedArrayII {

    public boolean search(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int mid;
        while(l <= r) {
            mid = (r - l) / 2 + l;
            if(nums[mid] == target) {
                return true;
            }
            if(nums[mid] == nums[r]) {
                r--;
                while(r >= mid) {
                    if(nums[mid] == nums[r]) {
                        r--;
                    }else {
                        break;
                    }
                }
            }else if(nums[mid] < nums[r]) {
                if(nums[mid] < target && nums[r] >= target) {
                    l = mid + 1;
                }else {
                    r = mid - 1;
                }
            }else {
                if(nums[l] <= target && nums[mid] > target) {
                    r = mid - 1;
                }else {
                    l = mid + 1;
                }
            }
        }
        return false;
    }
}