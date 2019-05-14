package array;

/**
 * 189. Rotate Array
 *
 * Given an array, rotate the array to the right by k steps, where k is non-negative.
 *
 * Example 1:
 * Input: [1,2,3,4,5,6,7] and k = 3
 * Output: [5,6,7,1,2,3,4]
 * Explanation:
 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
 *
 * Example 2:
 * Input: [-1,-100,3,99] and k = 2
 * Output: [3,99,-1,-100]
 * Explanation:
 * rotate 1 steps to the right: [99,-1,-100,3]
 * rotate 2 steps to the right: [3,99,-1,-100]
 *
 * Created by zjm on 2019/5/14.
 */
public class RotateArray {

    //use extra space, consider k is large than nums.length
    public void rotate(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k % nums.length == 0){
            return;
        }
        int[] arr = new int[k % nums.length];
        for(int i = k % nums.length - 1; i >= 0; i--) {
            arr[i] = nums[nums.length - k % nums.length + i];
        }
        for(int i = nums.length - 1 - k % nums.length; i>=0 ; i--) {
            nums[i + k % nums.length] = nums[i];
        }
        for(int i = 0; i < k % nums.length; i++) {
            nums[i] = arr[i];
        }
    }

    //first step : rotate nums pre k % nums.length elements
    //second step : rotate the last nums.length - k % nums.length elements
    //third step : rotate nums
    public void rotateWithoutExtraSpace(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k % nums.length == 0){
            return;
        }
        reverse(nums, 0, nums.length - k % nums.length - 1);
        reverse(nums, nums.length - k % nums.length, nums.length - 1);
        reverse(nums, 0, nums.length - 1);
    }

    public void reverse(int[] nums, int start, int end) {
        int tmp;
        while(start < end) {
            tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++;
            end--;
        }
    }

    public void rotateWorse(int[] nums, int k) {
        if(nums == null || nums.length < 2 || k % nums.length == 0){
            return;
        }
        int tmp;
        while(k % nums.length > 0) {
            tmp = nums[nums.length - 1];
            for(int i = nums.length - 2; i >= 0; i--) {
                nums[i + 1] = nums[i];
            }
            nums[0] = tmp;
            k--;
        }
    }
}

