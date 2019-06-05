package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 54. Spiral Matrix
 *
 * Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.
 *
 * Example 1:
 *
 * Input:
 * [
 *  [ 1, 2, 3 ],
 *  [ 4, 5, 6 ],
 *  [ 7, 8, 9 ]
 * ]
 * Output: [1,2,3,6,9,8,7,4,5]
 *
 * Example 2:
 * Input:
 * [
 *  [1, 2, 3, 4],
 *  [5, 6, 7, 8],
 *  [9,10,11,12]
 * ]
 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
 *
 * Created by zjm on 2019/6/5.
 */
public class SpiralMatrix {

    //just visit matrix in clockwise
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) {
            return Collections.EMPTY_LIST;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        int m = 0;
        int n = 0;
        List<Integer> res = new ArrayList(r * c);
        while(r > 0 && c > 0) {
            //if r == 1, that means matrix has only left one row elements to visit.
            if(r == 1) {
                for(int i = 0; i < c; i++) {
                    res.add(matrix[m][n++]);
                }
                break; //do not forget break.
            }
            //if c == 1, that means matrix has only left one column elements to visit.
            if(c == 1) {
                for(int i = 0; i < r; i++) {
                    res.add(matrix[m++][n]);
                }
                break;
            }
            for(int i = 0; i < c - 1; i++) {
                res.add(matrix[m][n++]);
            }
            for(int i = 0; i < r - 1; i++) {
                res.add(matrix[m++][n]);
            }
            for(int i = 0; i < c - 1; i++) {
                res.add(matrix[m][n--]);
            }
            for(int i = 0; i < r - 1; i++) {
                res.add(matrix[m--][n]);
            }
            //each visit two rows and two columns.
            r -= 2;
            c -= 2;
            m++;
            n++;
        }
        return res;
    }
}
