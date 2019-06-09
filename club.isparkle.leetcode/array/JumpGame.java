package array;

/**
 * 55. Jump Game
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
 * Each element in the array represents your maximum jump length at that position.
 * Determine if you are able to reach the last index.
 *
 * Example 1:
 * Input: [2,3,1,1,4]
 * Output: true
 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Example 2:
 * Input: [3,2,1,0,4]
 * Output: false
 * Explanation: You will always arrive at index 3 no matter what. Its maximum
 * jump length is 0, which makes it impossible to reach the last index.
 *
 * Created by zjm on 2019/6/5.
 */
public class JumpGame {

    public boolean canJump(int[] nums) {
        int max = 0;
        for(int i = 0; i < nums.length; i++) {
            max = Math.max(nums[i] + i, max);
            //when max < i, that means it can not jump to i. If max == i, that means it can only jump to i, if i is not the last index of nums, return false
            if(max < i || (max == i && i < nums.length - 1)) {
                return false;
            }
        }
        return true;
    }
}