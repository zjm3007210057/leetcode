package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 18. 4Sum
 *
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that
 * a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
 *
 * Note:
 * The solution set must not contain duplicate quadruplets.
 *
 * Example:
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * A solution set is:
 * [
 *  [-1,  0, 0, 1],
 *  [-2, -1, 1, 2],
 *  [-2,  0, 0, 2]
 * ]
 *
 * Created by zjm on 2019/5/27.
 */
public class FourSum {

    //solution just like ThreeSum
    //先固定一个值，然后转换为3个数字的和，可以参照三个数求和的方法
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList();
        int  tmp;
        for(int i = 0; i < nums.length - 3; i++) {
            if(i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            for(int j = i + 1; j < nums.length - 2; j++) {
                if(j > i + 1 && nums[j] == nums[j-1]) {
                    continue;
                }
                int l = j + 1;
                int r = nums.length - 1;
                tmp = target - nums[i] - nums[j];
                while(l < r) {
                    if(nums[l] + nums[r] == tmp) {
                        List<Integer> list = new ArrayList(4);
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[l]);
                        list.add(nums[r]);
                        res.add(list);
                        while(l < r && nums[l] == nums[l+1]) {
                            l++;
                        }
                        while(l < r && nums[r] == nums[r-1]) {
                            r--;
                        }
                        l++;
                        r--;
                    }else if(nums[l] + nums[r] > tmp) {
                        r--;
                    }else {
                        l++;
                    }
                }
            }
        }
        return res;
    }
}
