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

    //该题的意思是要找到此时给出的数字的下一个排列，什么意思呢？就是把这个数组当成一个整数，将各位数字重新排列，
    //能获取的所有整数中和当前的数差值最新，如果当前的值已经是最大值，那么下一个排列就是最小值。
    //比如：{1, 2, 3, 4},化成整数为：1234，那么1，2，3，4全部可能组成的四位数中和1234相差最小的为:1243,即所求结果为{1, 2, 4, 3}
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
        //find the element index i which nums[i] > nums[i-1] , then we only need find the minimum element from i to nums.length and makes nums[minimum] > nums[i-1].
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
        //in case nums is sorted in desc order
        //如果当前传入的数组是按照由大到小的排列顺序，则将数组翻转
        for(int i = 0; i < (nums.length + 1) / 2; i++) {
            tmp = nums[i];
            nums[i] = nums[nums.length-1-i];
            nums[nums.length-1-i] = tmp;
        }
    }
}
