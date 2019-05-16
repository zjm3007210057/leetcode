package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 448. Find All Numbers Disappeared in an Array
 *
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 *
 * Created by zjm on 2019/5/16.
 */
public class FindAllNumbersDisappearedInArray {

    //use swap method
    public List<Integer> findDisappearedNumbers(int[] nums) {
        if(null == nums || nums.length < 1) {
            return new ArrayList();
        }
        for(int i = 0; i < nums.length; i++) {
            swap(nums, i);
        }
        List<Integer> list = new ArrayList();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                list.add(i+1);
            }
        }
        return list;
    }

    public void swap(int[] nums, int i) {
        while(nums[i] != i + 1 && nums[nums[i] - 1] != nums[i]) {
            int tmp = nums[nums[i] - 1];
            nums[nums[i] -1] = nums[i];
            nums[i] = tmp;
        }
    }

    //use positive and negative flags to distinguish between appearing and non-existing elements
    public List<Integer> findDisappearedNumbers2(int[] nums) {
        if(null == nums || nums.length < 1) {
            return new ArrayList();
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[Math.abs(nums[i]) - 1] > 0) {
                nums[Math.abs(nums[i]) - 1] = -nums[Math.abs(nums[i]) - 1];
            }
        }
        List<Integer> list = new ArrayList();

        for(int i = 0; i < nums.length; i++) {
            if(nums[i] > 0) {
                list.add(i+1);
            }
        }
        return list;
    }


    public static void main(String[] args) {

        System.out.println(Math.abs(-1));
    }
}
