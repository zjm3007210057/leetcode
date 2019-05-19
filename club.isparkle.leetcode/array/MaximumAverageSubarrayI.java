package array;

/**
 * 643. Maximum Average Subarray I
 *
 * Given an array consisting of n integers, find the contiguous subarray of given length k that has the maximum average value.
 * And you need to output the maximum average value.
 *
 * Example 1:
 * Input: [1,12,-5,-6,50,3], k = 4
 * Output: 12.75
 * Explanation: Maximum average is (12-5-6+50)/4 = 51/4 = 12.75
 *
 * Note:
 * 1 <= k <= n <= 30,000.
 * Elements of the given array will be in the range [-10,000, 10,000].
 *
 * Created by zjm on 2019/5/19.
 */
public class MaximumAverageSubarrayI {

    //
    public double findMaxAverage(int[] nums, int k) {
        int left = 0;
        int right = k - 1;
        int tmp = 1;
        for(int i = k; i < nums.length; i++) {
            if(sum(nums, left, tmp) < sum(nums, i - tmp + 1, tmp)) {
                left = i - k + 1;
                right = i;
                tmp = 1;
            }else {
                tmp = tmp == k ? k : tmp + 1;
            }
        }
        double res = 0;
        for(int i = left; i <= right; i++) {
            res += nums[i];
        }
        return res / k;
    }

    private int sum(int[] nums, int index, int n) {
        int res = 0;
        for(int i = 0; i < n; i++) {
            res += nums[i + index];
        }
        return res;
    }

    //calculate k(from 0 to n) elements sum and store in a new array,
    //so the sum of contiguous k elements is the value of arr[n] - arr[n - k]
    public double findMaxAverageBetter(int[] nums, int k) {
        int[] arr = new int[nums.length];
        arr[0] = nums[0];
        for(int i = 1; i < nums.length; i++) {
            arr[i] = arr[i - 1] + nums[i];
        }
        double res = arr[k - 1];
        for(int i = k; i < arr.length; i++) {
            res = Math.max(res, arr[i] - arr[i - k]);
        }
        return res / k;
    }
}
