package array;

import java.util.*;

/**
 * 39. Combination Sum
 *
 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
 * find all unique combinations in candidates where the candidate numbers sums to target.
 * The same repeated number may be chosen from candidates unlimited number of times.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [2,3,6,7], target = 7,
 * A solution set is:
 * [
 *  [7],
 *  [2,2,3]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,3,5], target = 8,
 * A solution set is:
 * [
 *  [2,2,2,2],
 *  [2,3,3],
 *  [3,5]
 * ]
 *
 * Created by zjm on 2019/5/30.
 */
public class CombinationSum {

    //use recursion method
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList();
        Arrays.sort(candidates);
        help(candidates, 0, target, res, list);
        return res;
    }

    public void help(int[] arr, int start, int target, List<List<Integer>> res, List<Integer> list) {
        if(target < 0) {
            return;
        }else if(target == 0) {
            res.add(new ArrayList(list));
            return;
        }
        for(int i = start; i < arr.length; i++) {
            if(i > 0 && arr[i] == arr[i - 1]) {
                continue;
            }
            list.add(arr[i]);
            help(arr, i, target - arr[i], res, list);
            list.remove(list.size() - 1);
        }
    }

}
