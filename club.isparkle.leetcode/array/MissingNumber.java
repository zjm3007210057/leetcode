package array;

/**
 * 268. Missing Number
 *
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 *
 * Example 1:
 * Input: [3,0,1]
 * Output: 2
 *
 * Example 2:
 * Input: [9,6,4,2,3,5,7,0,1]
 * Output: 8
 *
 * Note:Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 * Created by zjm on 2019/5/15.
 */
public class MissingNumber {

    //use sum from 1 to n minus nums
    public int missingNumber(int[] nums) {
        int res = nums.length;
        for(int i = 0; i < nums.length; i++) {
            res += i - nums[i];
        }
        return res;
    }

    //use xor: 1 ^ 1 = 0, 1 ^ 0 = 1
    public int missingNumberGreat(int[] nums) {
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

}
