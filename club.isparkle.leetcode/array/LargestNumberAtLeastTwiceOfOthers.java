package array;

/**
 * 747. Largest Number At Least Twice of Others
 * <p>
 * In a given integer array nums, there is always exactly one largest element.
 * Find whether the largest element in the array is at least twice as much as every other number in the array.
 * If it is, return the index of the largest element, otherwise return -1.
 * <p>
 * Example 1:
 * Input: nums = [3, 6, 1, 0]
 * Output: 1
 * Explanation: 6 is the largest integer, and for every other number in the array x,
 * 6 is more than twice as big as x.  The index of value 6 is 1, so we return 1.
 * <p>
 * Example 2:
 * Input: nums = [1, 2, 3, 4]
 * Output: -1
 * Explanation: 4 isn't at least as big as twice the value of 3, so we return -1.
 * <p>
 * Note:
 * nums will have a length in the range [1, 50].
 * Every nums[i] will be an integer in the range [0, 99].
 * <p>
 * Created by zjm on 2019/5/21.
 */
public class LargestNumberAtLeastTwiceOfOthers {

    //find the largest element as max and the second largest element as sec, if max >= 2 * sec return the max index, else return -1.
    public int dominantIndex(int[] nums) {
        if (nums.length < 2) {
            return 0;
        }
        int max = nums[0] > nums[1] ? 0 : 1;
        int sec = nums[0] > nums[1] ? 1 : 0;
        for (int i = 2; i < nums.length; i++) {
            if (nums[i] > nums[max]) {
                sec = max;
                max = i;
            } else if (nums[i] < nums[max] && nums[i] > nums[sec]) {
                sec = i;
            }
        }
        if (nums[max] >= (nums[sec] << 1)) {
            return max;
        }
        return -1;
    }
}
