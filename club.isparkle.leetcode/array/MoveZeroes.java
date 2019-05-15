package array;

/**
 * 283. Move Zeroes
 *
 * Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.
 *
 * Example:
 * Input: [0,1,0,3,12]
 * Output: [1,3,12,0,0]
 *
 * Note:
 * You must do this in-place without making a copy of the array.
 * Minimize the total number of operations.
 *
 * Created by zjm on 2019/5/15.
 */
public class MoveZeroes {

    public void moveZeroes(int[] nums) {
        if(null == nums || nums.length == 0) {
            return ;
        }
        int index = -1;
        boolean flag = true;
        for(int i = 0; i < nums.length; i++) {
            if(flag && nums[i] == 0) {
                index = i;
                flag = false;
            }else if(!flag && nums[i] != 0) {
                nums[index++] = nums[i];
            }
        }
        if(index != -1) {
            for(int i = index; i < nums.length; i++) {
                nums[i] = 0;
            }
        }
    }

    //just fill nums with non-zero element one after another, set the last index elements 0
    public void moveZeroesBetter(int[] nums) {
        if(null == nums || nums.length == 0) {
            return ;
        }
        int index = 0;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != 0) nums[index++] = nums[i];
        }
        for(int i = index; i < nums.length; i++) {
            nums[i] = 0;
        }
    }
}
