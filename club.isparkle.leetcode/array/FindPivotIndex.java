package array;

/**
 * 724. Find Pivot Index
 * <p>
 * Given an array of integers nums, write a method that returns the "pivot" index of this array.
 * We define the pivot index as the index where the sum of the numbers to the left of the index is equal to the sum of the numbers to the right of the index.
 * If no such index exists, we should return -1. If there are multiple pivot indexes, you should return the left-most pivot index.
 * <p>
 * Example 1:
 * Input:
 * nums = [1, 7, 3, 6, 5, 6]
 * Output: 3
 * Explanation:
 * The sum of the numbers to the left of index 3 (nums[3] = 6) is equal to the sum of numbers to the right of index 3.
 * Also, 3 is the first index where this occurs.
 * <p>
 * Example 2:
 * Input:
 * nums = [1, 2, 3]
 * Output: -1
 * Explanation:
 * There is no index that satisfies the conditions in the problem statement.
 * <p>
 * Note:
 * The length of nums will be in the range [0, 10000].
 * Each element nums[i] will be an integer in the range [-1000, 1000].
 * <p>
 * Created by zjm on 2019/5/21.
 */
public class FindPivotIndex {

    //use extra space O(n)
    public int pivotIndex(int[] nums) {
        if (nums.length < 1) {
            return -1;
        }
        int[] sum = new int[nums.length + 2];
        sum[0] = 0;
        for (int i = 1; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
        }
        sum[nums.length + 1] = sum[nums.length];
        for (int i = 1; i < sum.length - 1; i++) {
            if (sum[i - 1] == sum[sum.length - 1] - sum[i]) {
                return i - 1;
            }
        }
        return -1;
    }

    public int pivotIndexSimple(int[] nums) {
        if (nums.length < 1) {
            return -1;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        int tmp = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum - nums[i] == 2 * tmp) return i;
            tmp += nums[i];
        }
        return -1;
    }
}
