package array;

import java.util.Arrays;

/**
 * 16. 3Sum Closest
 * <p>
 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
 * <p>
 * Example:
 * Given array nums = [-1, 2, 1, -4], and target = 1.
 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2)
 * <p>
 * Created by zjm on 2019/5/27.
 */
public class ThreeSumClosest {

    //the solution is just like ThreeSum
    //首先排序，然后先固定一个值，再加上两个数与target之间的差值，加上的两个数分别在固定数字的前一个和最后一个，
    //每次求的差值和之前的差值进行比较，如果小于则更新差值和结果。
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int res = nums[0] + nums[1] + nums[2];
        int diff = Math.abs(res - target);
        int tmp;
        int tmpDiff;
        for (int i = 0; i < nums.length; i++) {
            int l = i + 1;
            int r = nums.length - 1;
            while (l < r) {
                tmp = nums[i] + nums[l] + nums[r];
                tmpDiff = Math.abs(tmp - target);
                if (tmpDiff < diff) {
                    res = tmp;
                    diff = tmpDiff;
                }
                if (tmp > target) r--;
                else l++;
            }
        }
        return res;
    }
}
