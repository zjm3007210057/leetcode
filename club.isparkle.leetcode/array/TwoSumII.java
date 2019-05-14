package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 167. Two Sum II - Input array is sorted
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
 *
 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
 * Note:
 *
 * Your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 * Example:
 *
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 *
 * Created by zjm on 2019/5/14.
 */
public class TwoSumII {

    //consider each input may not have one solution
    public int[] twoSum(int[] numbers, int target) {
        if(null == numbers || numbers.length < 2 || target < numbers[0] || target > (numbers[numbers.length - 2] + numbers[numbers.length - 1])) {
            return new int[]{};
        }
        int[] res = new int[2];
        Map<Integer, Integer> map = new HashMap(numbers.length * 2);
        for(int i = 0; i < numbers.length; i++) {
            if(map.containsKey(target - numbers[i])) {
                res[0] = map.get(target - numbers[i]) + 1;
                res[1] = i + 1;
            }
            map.put(numbers[i], i);
        }
        return res;
    }

    //in condition of each input would have exactly one solution
    //use two index from left and right respect
    public int[] twoSumBetter(int[] numbers, int target) {
        if(numbers.length == 2) {
            return new int[]{1, 2};
        }
        int l = 0;
        int r = numbers.length - 1;
        while(l < r) {
            if(numbers[l] + numbers[r] > target) {
                r--;
            }else if(numbers[l] + numbers[r] < target) {
                l++;
            }else {
                break;
            }
        }
        return new int[]{l + 1, r + 1};
    }

    //consider each input may not have one solution
    //use two index from left and right respect
    public int[] twoSumBetterConsider(int[] numbers, int target) {
        if(null == numbers || numbers.length < 2) {
            return null;
        }
        int l = 0;
        int r = numbers.length - 1;
        boolean isExist = false;
        while(l < r) {
            if(numbers[l] + numbers[r] > target) {
                r--;
            }else if(numbers[l] + numbers[r] < target) {
                l++;
            }else {
                isExist = true;
                break;
            }
        }
        if(isExist) {
            return new int[]{l + 1, r + 1};
        }
        return null;
    }
}
