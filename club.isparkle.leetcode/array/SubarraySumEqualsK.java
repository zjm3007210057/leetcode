package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 560. Subarray Sum Equals K
 * <p>
 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
 * <p>
 * Example 1:
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * Note:
 * The length of the array is in range [1, 20,000].
 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
 *
 * Created by zjm on 2019/6/20 20:48
 */
public class SubarraySumEqualsK {

    //O(n^2) Brute Force
    public int subarraySumSimple(int[] nums, int k) {
        if(nums.length < 1) {
            return 0;
        }
        int left = 0, right = 0;
        int res = 0;
        while(left < nums.length && right < nums.length) {
            int sum = 0;
            for(int i = left; i < nums.length; i++) {
                sum += nums[i];
                if(sum == k) {
                    res++;
                }
            }
            left++;
        }
        return res;
    }

    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int res = 0;
        Map<Integer, Integer> map = new HashMap();
        map.put(0, 1);
        for (int num : nums) {
            sum += num;
            if(map.containsKey(sum - k)) {
                res += map.getOrDefault(sum - k, 0);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}
