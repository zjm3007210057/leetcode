package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 414. Third Maximum Number
 *
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 * Output: 1
 * Explanation: The third maximum is 1.
 *
 * Example 2:
 * Input: [1, 2]
 * Output: 2
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 *
 * Example 3:
 * Input: [2, 2, 3, 1]
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 *
 * Created by zjm on 2019/5/16.
 */
public class ThirdMaximumNumber {

    //use O(1) space
    public int thirdMax(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        if(nums.length == 2) {
            return nums[0] > nums[1] ? nums[0] : nums[1];
        }
        int max = Integer.MIN_VALUE;
        int sec = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;
        Set<Integer> set = new HashSet();
        for(int num : nums) {
            //only need to add three elements to set
            if(set.size() < 3) {
                set.add(num);
            }
            if(num > max) {
                third = sec;
                sec = max;
                max = num;
            }else if(num > sec && num != max) {
                third = sec;
                sec = num;
            }else if(num > third && num != sec && num != max) {
                third = num;
            }
        }
        if(set.size() > 2) {
            return third;
        }
        return max;
    }

}
