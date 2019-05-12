package array;

/**
 * 26. Remove Duplicates from Sorted Array
 *
 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
 *
 * Example 1:
 * Given nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the returned length.
 *
 * Example 2:
 * Given nums = [0,0,1,1,1,2,2,3,3,4],
 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
 * It doesn't matter what values are set beyond the returned length.
 *
 * Created by zjm on 2019/5/12.
 */
public class RemoveDuplicatesFromSortedArray {

    public int removeDuplicates(int[] nums) {
        if(null == nums || nums.length < 1) {
            return 0;
        }
        if(nums.length == 1) {
            return 1;
        }
        int res = nums.length;
        //set judge as a fixed number, this number to be used in judge
        int judge = nums[0];
        //if the element equal to the next element, then set the element value judge - 1
        for(int i = 1; i < nums.length; i++) {
            if(nums[i] == nums[i-1]) {
                res--;
                nums[i - 1] = judge - 1;
            }
        }
        if(res == nums.length) {
            return res;
        }
        int j = 0;
        //judge the elements of the array is large than (judge - 1), if the element value large than (judge - 1),
        //it means the element is a useful element in result of return
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > (judge - 1)) {
                nums[j++] = nums[i];
            }
        }
        return res;
    }

    public int removeDuplicatesMoreFast(int[] nums) {
        if(null == nums || nums.length < 1) {
            return 0;
        }
        int res = 0;
        //set the first element of the nums at first,
        //then judge the next element in array is large than the value that has set in nums or not
        for(int num : nums) {
            if(res == 0 || num > nums[res - 1]) {
                nums[res++] = num;
            }
        }
        return res;
    }

}
