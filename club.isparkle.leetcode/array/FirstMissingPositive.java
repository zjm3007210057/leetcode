package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 41. First Missing Positive
 *
 * Given an unsorted integer array, find the smallest missing positive integer.
 *
 * Example 1:
 * Input: [1,2,0]
 * Output: 3
 *
 * Example 2:
 * Input: [3,4,-1,1]
 * Output: 2
 *
 * Example 3:
 * Input: [7,8,9,11,12]
 * Output: 1
 *
 * Note:
 * Your algorithm should run in O(n) time and uses constant extra space
 *
 * Created by zjm on 2019/6/3.
 */
public class FirstMissingPositive {

    public int firstMissingPositive(int[] nums) {
        int tmp;
        int res = nums.length;
        for(int i = 0; i < res; i++) {
            while(nums[i] > 0 && nums[i] <= res && nums[i] != nums[nums[i] - 1]) {
                tmp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = tmp;
            }
        }
        for(int i = 0; i < res; i++) {
            if(nums[i] != i+1) {
                return i + 1;
            }
        }
        return res + 1;
    }

    //use a set to store the elements of nums and judge if set contains n(0 < n <= nums.length)
    public int firstMissingPositiveWithSet(int[] nums) {
        int res = nums.length;
        Set<Integer> set = new HashSet();
        for(int i = 0; i < res; i++) {
           set.add(nums[i]);
        }
        for(int i = 1; i <= res; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return res + 1;
    }

}
