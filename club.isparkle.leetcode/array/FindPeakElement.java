package array;

/**
 * 162. Find Peak Element
 *
 * A peak element is an element that is greater than its neighbors.
 *
 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
 *
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 *
 * You may imagine that nums[-1] = nums[n] = -∞.
 *
 * Example 1:
 *
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * Example 2:
 *
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5
 * Explanation: Your function can return either index number 1 where the peak element is 2,
 *              or index number 5 where the peak element is 6.
 * Note:
 *
 * Your solution should be in logarithmic complexity
 *
 * Created by zjm on 2019/6/13 20:05 PM
 */
public class FindPeakElement {

    //use binary search, if nums[mid] < nums[mid+1], there is a peak element in nums[mid+1] to nums[r].
    //if nums[mid] > nums[mid-1], there is a peak element in nums[l] to nums[mid-1]
    //notice the boundary condition in while loop, not l < r but l <= r.
    public int findPeakElement(int[] nums) {
        //consider the specially conditions. nums={2, 1} return 0, nums={1, 2} return 1
        if(nums.length == 1 || nums[0] > nums[1]) {
            return 0;
        }else if(nums[nums.length-1] > nums[nums.length-2]) {
            return nums.length - 1;
        }
        int l = 0, r = nums.length - 1;
        int mid;
        while(l <= r) {
            mid = (r - l) / 2 + l;
            if(mid > 0 && mid < nums.length - 1 && nums[mid] > nums[mid-1] && nums[mid] > nums[mid+1]) {
                return mid;
            }else if(nums[mid] < nums[mid+1]) {
                l = mid + 1;
            }else {
                r = mid - 1;
            }
        }
        return -1;
    }
}
