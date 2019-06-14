package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 216. Combination Sum III
 *
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
 *
 * Note:
 *
 * All numbers will be positive integers.
 * The solution set must not contain duplicate combinations.
 * Example 1:
 *
 * Input: k = 3, n = 7
 * Output: [[1,2,4]]
 * Example 2:
 *
 * Input: k = 3, n = 9
 * Output: [[1,2,6], [1,3,5], [2,3,4]]
 *
 * Created by zjm on 2019/6/14 17:28 AM
 */
public class CombinationSumIII {

    //just like combinations
    public static List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> res = new ArrayList();
        List<Integer> list = new ArrayList(k);
        help(res, list, k, n, 1);
//        help(res, list, k, n, 1, 0);
        return res;
    }

    public static void help(List<List<Integer>> res, List<Integer> list, int k, int n, int index, int sum) {
        if(k < 0 || sum > n) {
            return;
        }else if(sum == n && 0 == k) {
            res.add(new ArrayList(list));
            return ;
        }
        for(int i = index; i < 10; i++) {
            if(n < sum) {
                return;
            }
            sum += i;
            list.add(i);
            help(res, list, k-1, n, i+1, sum);
            list.remove(list.size() - 1);
            sum -= i;
        }
    }

    private static void help(List<List<Integer>> res, List<Integer> list, int k, int n, int index) {
        if(n < 0) {
            return;
        }else if(n == 0 && list.size() == k) {
            res.add(new ArrayList(list));
            return;
        }
        for(int i = index; i < 10; i++) {
            list.add(i);
            help(res, list, k, n-i, i+1);
            list.remove(list.size() - 1);
        }
    }

}