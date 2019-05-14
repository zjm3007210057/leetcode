package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 169. Majority Element
 *
 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
 *
 * You may assume that the array is non-empty and the majority element always exist in the array.
 *
 * Example 1:
 * Input: [3,2,3]
 * Output: 3
 *
 * Example 2:
 * Input: [2,2,1,1,1,2,2]
 * Output: 2
 *
 * Created by zjm on 2019/5/14.
 */
public class MajorityElement {

    //Time: O(n) Space: O(n)
    //use map to find the target num, if the length of nums is 1, return the first element
    public int majorityElement(int[] nums) {
        if(nums.length == 1) {
            return nums[0];
        }
        Map<Integer, Integer> map = new HashMap();
        for(int n : nums) {
            if(null == map.get(n)) {
                map.put(n, 1);
            }else {
                map.put(n, map.get(n) + 1);
                if(map.get(n) > nums.length / 2) {
                    return n;
                }
            }
        }
        return 0;
    }

    //Time: O(n)  Space: O(1)
    //use num to count the element appears in nums, if the next is the same element, then count plus 1, else count minus 1.
    //since target appears number is large than n/2, no matter how target distribute, target count must large than 1
    public int majorityElementBetter(int[] nums) {
        int target = 0;
        int num = 0;
        for(int i = 0; i < nums.length; i++) {
            if(num == 0) {
                target = nums[i];
                num = 1;
            }else {
                if(target == nums[i]) num++;
                else num--;
            }
        }
        return target;
    }

    //Time: O(nlgn)  Space: O(1)
    public int majorityElementSimple(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
}
