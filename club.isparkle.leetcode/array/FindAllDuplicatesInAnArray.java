package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 442. Find All Duplicates in an Array
 * <p>
 * Given an array of integers, 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * <p>
 * Find all the elements that appear twice in this array.
 * <p>
 * Could you do it without extra space and in O(n) runtime?
 * <p>
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * <p>
 * Output:
 * [2,3]
 * Created by zjm on 2019/6/17 21:41
 */
public class FindAllDuplicatesInAnArray {

    //because elements are range in 1 to n, so if nums[i] != i+1, nums[i] must duplicate
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList();
        int tmp;
        for(int i = 0; i < nums.length; i++) {
            //
            while(nums[i] != nums[nums[i] - 1]) {
                tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] != i + 1) {
                res.add(nums[i]);
            }
        }
        return res;
    }

    //invert nums[nums[i] - 1], if the value is already negative, that means nums[nums[i] - 1] must duplicate
    public List<Integer> findDuplicatesSimple(int[] nums) {
        List<Integer> res = new ArrayList();
        int tmp;
        for(int i = 0; i < nums.length; i++) {
            tmp = Math.abs(nums[i]) - 1;
            if(nums[tmp] < 0) {
                res.add(tmp + 1);
            }
            nums[tmp] = -nums[tmp];
        }
        return res;
    }

}
