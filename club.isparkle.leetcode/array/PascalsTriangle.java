package array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.
 * Example:
 * Input: 5
 * Output:
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * Created by zjm on 2019/5/13.
 */
public class PascalsTriangle {

    public List<List<Integer>> generate(int numRows) {
        if(numRows <= 0) {
            return new ArrayList();
        }
        List<List<Integer>> res = new ArrayList(numRows);
        List<Integer> one = new ArrayList(1);
        one.add(1);
        res.add(one);
        if(numRows == 1) {
            return res;
        }
        for(int i = 1; i < numRows; i++) {
            List<Integer> preList = res.get(i-1);
            List<Integer> list = new ArrayList(i + 1);
            res.add(list);
            //set the first element 1
            list.add(1);
//            list.set(0, 1);
//            list.set(i, 1);
            for(int j = 1; j < preList.size(); j++) {
                list.add(preList.get(j - 1) + preList.get(j));
            }
            //set the last element 1
            list.add(1);
        }
        return res;
    }
}
