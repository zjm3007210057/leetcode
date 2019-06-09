package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. Subsets
 *
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * Note: The solution set must not contain duplicate subsets.
 *
 * Example:
 * Input: nums = [1,2,3]
 * Output:
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 *
 * Created by zjm on 2019/6/9.
 */
public class Subsets {

    //use DP
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        res.add(new ArrayList());
        if(nums.length == 1) {
            List<Integer> list = new ArrayList(1);
            list.add(nums[0]);
            res.add(list);
            return res;
        }
        help(res, 0, nums);
        return res;
    }

    public void help(List<List<Integer>> res, int n, int[] arr) {
        if(n >= arr.length) {
            return;
        }
        int len = res.size();
        for(int i = 0; i < len; i++) {
            List<Integer> tmp = new ArrayList(res.get(i));
            tmp.add(arr[n]);
            res.add(tmp);
        }
        help(res, n + 1, arr);
    }

    //the result has 2^nums.length subsets
    public List<List<Integer>> subsetsSlow(int[] nums) {
        List<List<Integer>> res = new ArrayList();
        if(nums.length < 1) {
            return res;
        }
        int total = 1 << nums.length;
        int tmp;
        int com;
        for(int i = 0; i < total; i++) {
            List<Integer> list = new ArrayList();
            tmp = 1;
            for(int j = 0; j < nums.length; j++) {
                com = tmp & i;
                if(com > 0) {
                    list.add(nums[j]);
                }
                tmp <<= 1;
            }
            res.add(list);
        }
        return res;
    }
}
