package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 697. Degree of an Array
 * <p>
 * Given a non-empty array of non-negative integers nums, the degree of this array is defined as the maximum frequency of any one of its elements.
 * Your task is to find the smallest possible length of a (contiguous) subarray of nums, that has the same degree as nums.
 * <p>
 * Example 1:
 * Input: [1, 2, 2, 3, 1]
 * Output: 2
 * Explanation:
 * The input array has a degree of 2 because both elements 1 and 2 appear twice.
 * Of the subarrays that have the same degree:
 * [1, 2, 2, 3, 1], [1, 2, 2, 3], [2, 2, 3, 1], [1, 2, 2], [2, 2, 3], [2, 2]
 * The shortest length is 2. So return 2.
 * <p>
 * Example 2:
 * Input: [1,2,2,3,1,4,2]
 * Output: 6
 * Note:
 * nums.length will be between 1 and 50,000.
 * nums[i] will be an integer between 0 and 49,999.
 * <p>
 * Created by zjm on 2019/5/21.
 */
public class DegreeOfAnArray {

    //use two maps, one map record the element and the element occur numbers, other map record the element and the element first occur place in nums
    public int findShortestSubArray(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Map<Integer, Integer> map = new HashMap();
        Map<Integer, Integer> indexMap = new HashMap();
        int tmp = 1;
        int minGap = 1;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                map.put(nums[i], 1);
                indexMap.put(nums[i], i);
            } else {
                map.put(nums[i], map.get(nums[i]) + 1);
                if (map.get(nums[i]) > tmp) {
                    tmp = map.get(nums[i]);
                    minGap = i - indexMap.get(nums[i]) + 1;
                } else if (map.get(nums[i]) == tmp) {
                    minGap = Math.min(minGap, i - indexMap.get(nums[i]) + 1);
                }
            }
        }
        return minGap;
    }

    //use one map, key is the element in nums, value is an array which length is 2, and the array[0] is the element occur numbers,
    //array[1] is the element index in nums
    public int findShortestSubArrayBetter(int[] nums) {
        if (nums.length < 2) {
            return nums.length;
        }
        Map<Integer, Integer[]> map = new HashMap();
        int tmp = 1;
        int minGap = 1;
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == null) {
                Integer[] arr = new Integer[2];
                map.put(nums[i], arr);
                arr[0] = 1;
                arr[1] = i;
            } else {
                Integer[] arr = map.get(nums[i]);
                arr[0] += 1;
                if (arr[0] > tmp) {
                    tmp = arr[0];
                    minGap = i - arr[1] + 1;
                } else if (arr[0] == tmp) {
                    minGap = Math.min(minGap, i - arr[1] + 1);
                }
            }
        }
        return minGap;
    }
}
