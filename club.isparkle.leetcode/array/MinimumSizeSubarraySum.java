package array;

/**
 * 209. Minimum Size Subarray Sum
 *
 * Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
 *
 * Example:
 *
 * Input: s = 7, nums = [2,3,1,2,4,3]
 * Output: 2
 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
 * Follow up:
 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
 *
 * Created by zjm on 2019/6/13 4:02 PM
 */
public class MinimumSizeSubarraySum {

    //define two pointers l and r, and move forward r make sum = nums[l] +...+ nums[r] >= s. then move forward l makes sum >= s
    //and update the res(r-l+1), if sum < s, stop move forward l and move forward r again. update res meanwhile if res larger than r-l+1.
    public int minSubArrayLen(int s, int[] nums) {
        if(nums.length < 1) {
            return 0;
        }
        int l = 0, r;
        int sum = 0;
        int res = nums.length + 1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] >= s) {
                return 1;
            }
            sum += nums[i];
            if(sum >= s) {
                r = i;
                sum -= nums[l];
                //move forward l if sum >= s
                while(sum >= s) {
                    sum -= nums[++l];
                }
                res = Math.min(res, r-l+1);
                l++;
            }
        }
        //notice the sum of all the elements is smaller than s
        return res > nums.length ? 0 : res;
    }

    public int minSubArrayLenSimple(int s, int[] nums) {
        int l = 0, r = 0;
        int sum = 0;
        int res = nums.length + 1;
        while(r < nums.length) {
            sum += nums[r];
            while(sum >= s) {
                res = Math.min(res, r - l + 1);
                sum -= nums[l++];
            }
            r++;
        }
        //notice the sum of all the elements is smaller than s
        return res > nums.length ? 0 : res;
    }
}