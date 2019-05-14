package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 119. Pascal's Triangle II
 * Given a non-negative index k where k ≤ 33, return the kth index row of the Pascal's triangle.
 * Note that the row index starts from 0.
 *
 * [
 *      [1],
 *     [1,1],
 *    [1,2,1],
 *   [1,3,3,1],
 *  [1,4,6,4,1]
 * ]
 * Example:
 * Input: 3
 * Output: [1,3,3,1]
 *
 * Created by zjm on 2019/5/14.
 */
public class PascalsTriangleII {

    public List<Integer> getRow(int rowIndex) {
        List<Integer> res = new ArrayList(1);
        res.add(1);
        if(rowIndex < 1) {
            return res;
        }
        int index = 1;
        //use iteration
        while(index <= rowIndex) {
            List<Integer> list = getList(res);
            res = list;
            index++;
        }
        return res;
    }

    public List<Integer> getList(List<Integer> list) {
        List<Integer> res = new ArrayList(list.size() + 1);
        res.add(1);
        for(int j = 1; j < list.size(); j++) {
            res.add(list.get(j) + list.get(j-1));
        }
        res.add(1);
        return res;
    }

    //use DP
    public List<Integer> getRowBetter(int rowIndex) {
        Integer[] res = new Integer[rowIndex + 1];
        for(int i = 0; i <= rowIndex; i++) {
            for(int j = i; j >= 0; j--) {
                if(j == 0 || j == i)
                    res[j] = 1;
                else
                    res[j] += res[j - 1];
            }
        }
		return Arrays.asList(res);
    }
}
