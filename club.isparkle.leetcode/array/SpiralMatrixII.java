package array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 59. Spiral Matrix II
 *
 * Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 *
 * Example 1:
 *
 * Input: 3
 * Output:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 *
 * Created by zjm on 2019/6/6.
 */
public class SpiralMatrixII {

    //just visit matrix in clockwise
    public int[][] generateMatrix(int n) {
        int r = 0;
        int c = 0;
        int m = n;
        int[][] res = new int[n][n];
        int count = 1;
        while(m > 0 && n > 0) {
            if(m == 1) {
                for(int i = 0; i < n; i++) {
                    res[r][c++] = count++;
                }
            }else if(n == 1) {
                for(int i = 0; i < m; i++) {
                    res[r++][c] = count++;
                }
            }
            for(int i = 0; i < m - 1; i++) {
                res[r][c++] = count++;
            }
            for(int i = 0; i < n - 1; i++) {
                res[r++][c] = count++;
            }
            for(int i = 0; i < m - 1; i++) {
                res[r][c--] = count++;
            }
            for(int i = 0; i < n - 1; i++) {
                res[r--][c] = count++;
            }
            m -= 2;
            n -= 2;
            r++;
            c++;
        }
        return res;
    }
}
