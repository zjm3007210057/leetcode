package array;

import java.util.List;

/**
 * 120. Triangle
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
 *
 * For example, given the following triangle
 *
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 *
 * Note:
 *
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
 *
 * Created by zjm on 2019/6/12 6:26 PM
 */
public class Triangle {

    //modify triangle itself and calculate each row minimum sum
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle.size() < 1) {
            return 0;
        }
        for(int i = 1; i < triangle.size(); i++) {
            List<Integer> pre = triangle.get(i-1);
            List<Integer> list = triangle.get(i);
            for(int j = 0 ; j < list.size(); j++) {
                if(j == 0) {
                    list.set(0, list.get(0) + pre.get(0));
                }else if(j < list.size() - 1) {
                    list.set(j, list.get(j) + Math.min(pre.get(j-1), pre.get(j)));
                }else {
                    list.set(j, list.get(j) + pre.get(j-1));
                }
            }
        }
        List<Integer> last = triangle.get(triangle.size() - 1);
        int res = last.get(0);
        for(int i = 1; i < last.size(); i++) {
            if(res > last.get(i)) {
                res = last.get(i);
            }
        }
        return res;
    }


}