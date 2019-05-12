package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 1. Two Sum
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9, return [0, 1].
 *
 * Created by zjm on 2019/5/12.
 */
public class TwoNum {

    //consider target maybe a negative number
    public int[] twoSum(int[] nums, int target) {
        if(null == nums || nums.length <= 1) {
            return null;
        }
        //use map to store the elements of array,
        //if there are two elements the same, judge the element multiple 2 is equal to target,
        //return indices of the two elements if the result is equal.
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) == null) {
                map.put(nums[i], i);
            }else if(nums[i] * 2 == target) {
                return new int[]{map.get(nums[i]), i};
            }
        }
        //judge the target minus element of the map is also in the map
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if(map.containsKey(target - entry.getKey())) {
                int l = entry.getValue();
                int r = map.get(target - entry.getKey());
                if(l < r) {
                    return new int[]{l, r};
                }else {
                    return new int[]{r, l};
                }
            }
        }
        return null;
    }

    public int[] twoSumMoreFast(int[] nums, int target) {
        if(null == nums || nums.length <= 1) {
            return null;
        }
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(map.containsKey(target - nums[i])) {
                return new int[] {map.get(target - nums[i]), i};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}
