package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. Combination Sum II
 *
 * Given a collection of candidate numbers (candidates) and a target number (target), find all unique
 * combinations in candidates where the candidate numbers sums to target.
 * Each number in candidates may only be used once in the combination.
 *
 * Note:
 * All numbers (including target) will be positive integers.
 * The solution set must not contain duplicate combinations.
 *
 * Example 1:
 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
 * A solution set is:
 * [
 *  [1, 7],
 *  [1, 2, 5],
 *  [2, 6],
 *  [1, 1, 6]
 * ]
 *
 * Example 2:
 * Input: candidates = [2,5,2,1,2], target = 5,
 * A solution set is:
 * [
 *  [1,2,2],
 *  [5]
 * ]
 *
 * Created by zjm on 2019/6/2.
 */
public class CombinationSumII {

    //just like CombinationSum, but we need extra array to store the elements which has visited since we can only use element once
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList();
        Arrays.sort(candidates);
        boolean[] visited = new boolean[candidates.length];
        help(candidates, 0, target, res, list, visited);
        return res;
    }

    private void help(int[] arr, int start, int target, List<List<Integer>> res, List<Integer> list, boolean[] visited) {
        if(target == 0) {
            res.add(new ArrayList(list));
            return;
        }else if(target < 0) {
            return;
        }
        for(int i = start; i < arr.length; i++) {
            if(!visited[i]) {
                //if target is smaller than arr[i], that means target is smaller than all the right elements, so we can break it directly.
                if(target < arr[i]) {
                    break;
                }
                if(i > 0 && arr[i] == arr[i-1] && !visited[i-1]) {
                    continue;
                }
                list.add(arr[i]);
                visited[i] = true;
                help(arr, i + 1, target - arr[i], res, list, visited);
                visited[i] = false;
                list.remove(list.size() - 1);
            }
        }
    }

}
