package array;

import java.util.Arrays;

/**
 * 31. Next Permutation
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.
 * If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).
 *
 * The replacement must be in-place and use only constant extra memory.
 *
 * Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 * 1,2,3 → 1,3,2
 * 3,2,1 → 1,2,3
 * 1,1,5 → 1,5,1
 *
 * Created by zjm on 2019/5/27.
 */
public class NextPermutation {

    public void nextPermutation(int[] nums) {
        if(nums.length < 2) {
            return;
        }
        int tmp;
        if(nums.length == 2) {
            tmp = nums[0];
            nums[0] = nums[1];
            nums[1] = tmp;
            return;
        }
        //find the element index i which nums[i] > nums[i-1], then we only need find the minimum element from i to nums.length and makes nums[minimum] > nums[i-1].
        //swap nums[minimum] and nums[i-1], finally, just swap remainder elements from i to nums.length
        for(int i = nums.length - 1; i > 0; i--) {
            if(nums[i] > nums[i-1]) {
                int min = i - 1;
                int index = i;
                while(index < nums.length) {
                    if(nums[i-1] < nums[index]) {
                        min = index;
                    }
                    index++;
                }
                tmp = nums[min];
                nums[min] = nums[i-1];
                nums[i-1] = tmp;
                index = nums.length - 1;
                while(i < index) {
                    tmp = nums[i];
                    nums[i] = nums[index];
                    nums[index] = tmp;
                    i++;
                    index--;
                }
                return;
            }
        }
        for(int i = 0; i < (nums.length + 1) / 2; i++) {
            tmp = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = tmp;
        }
    }
}
