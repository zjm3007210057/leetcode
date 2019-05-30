package array;

/**
 * 34. Find First and Last Position of Element in Sorted Array
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * If the target is not found in the array, return [-1, -1].
 * Example 1:
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 *
 * Example 2:
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 *
 * Created by zjm on 2019/5/30.
 */
public class FindFirstAndLastPositionOfElementInSortedArray {

    //use binary search
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[]{-1, -1};
        int l = 0;
        int r = nums.length - 1;
        while(l <= r) {
            int mid = (r - l) / 2 + l;
            if(nums[mid] == target) {
                //find the left index and right index, respectively
                res[0] = help(nums, l, mid, true);
                res[1] = help(nums, mid, r, false);
                return res;
            }
            if(nums[mid] > target) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return res;
    }

    public int help(int[] nums, int l, int r, boolean asc) {
        int mid;
        if(asc) {
            while(l < r) {
                if(nums[l] == nums[r]) {
                    return l;
                }
                mid = (r - l) / 2 + l;
                if(nums[mid] == nums[r]) {
                    r = mid;
                }else {
                    l = mid + 1;
                }
            }
        }else {
            while(l < r) {
                if(nums[l] == nums[r]) {
                    return r;
                }
                mid = (r - l) / 2 + l;
                if(nums[mid] == nums[l]) {
                    if(mid == l) {
                        return l;
                    }
                    l = mid;
                }else {
                    r = mid - 1;
                }
            }
        }
        return r;
    }

    //use binary search, first find the left index, then, find the end index
    public int[] searchRangeSimple(int[] nums, int target) {
        int l = 0;
        int r = nums.length - 1;
        int begin = -1;
        int end = -1;
        while(l <= r) {
            int mid = (r - l) / 2 + l;
            if(nums[mid] == target) {
                begin = mid;
                r = mid - 1;
            }else if(nums[mid] > target) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        //r has changed, makes r equals nums.length - 1 again
        r = nums.length - 1;
        while(l <= r) {
            int mid = (r - l) / 2 + l;
            if(nums[mid] == target) {
                end = mid;
                l = mid + 1;
            }else if(nums[mid] > target) {
                r = mid - 1;
            }else {
                l = mid + 1;
            }
        }
        return new int[]{begin, end};
    }
}
