package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. Subsets II
 *
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets (the power set).
 *
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 *
 * Input: [1,2,2]
 * Output:
 * [
 *   [2],
 *   [1],
 *   [1,2,2],
 *   [2,2],
 *   [1,2],
 *   []
 * ]
 *
 * Created by zjm on 2019/6/11 19:16 PM
 */
public class SubsetsII {

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());
        if(nums.length < 1) {
            return res;
        }
        Arrays.sort(nums);
        help(res, nums, 0, 1);
        return res;
    }

    public void help(List<List<Integer>> res, int[] nums, int n, int size) {
        if(n >= nums.length) {
            return;
        }
        int len = res.size();
        if(n > 0 && nums[n] == nums[n-1]) {
            for(int i = size; i < len; i++) {
                List<Integer> list = new ArrayList(res.get(i));
                list.add(nums[n]);
                res.add(list);
            }
        }else {
            for(int i = 0; i < len; i++) {
                List<Integer> list = new ArrayList(res.get(i));
                list.add(nums[n]);
                res.add(list);
            }
        }
        help(res, nums, n+1, len);
    }
}