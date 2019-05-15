package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 219. Contains Duplicate II
 *
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that
 * nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * Example 1:
 * Input: nums = [1,2,3,1], k = 3
 * Output: true
 *
 * Example 2:
 * Input: nums = [1,0,1,1], k = 1
 * Output: true
 *
 * Example 3:
 * Input: nums = [1,2,3,1,2,3], k = 2
 * Output: false
 *
 * Created by zjm on 2019/5/15.
 */
public class ContainsDuplicateII {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        if(null == nums || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            if(map.get(nums[i]) != null) {
                if(i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            map.put(nums[i], i);
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        if(null == nums || nums.length < 2) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i <  nums.length; i++) {
            Integer old = map.put(nums[i], i);
            if(old != null && i - old <= k) {
                return true;
            }
        }
        return false;
    }
}
