package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 73. Set Matrix Zeroes
 *
 * Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.
 * Example 1:
 * Input:
 * [
 *   [1,1,1],
 *   [1,0,1],
 *   [1,1,1]
 * ]
 * Output:
 * [
 *   [1,0,1],
 *   [0,0,0],
 *   [1,0,1]
 * ]
 *
 * Example 2:
 * Input:
 * [
 *   [0,1,2,0],
 *   [3,4,5,2],
 *   [1,3,1,5]
 * ]
 * Output:
 * [
 *  [0,0,0,0],
 *  [0,4,5,0],
 *  [0,3,1,0]
 * ]
 * Follow up:
 * A straight forward solution using O(mn) space is probably a bad idea.
 * A simple improvement uses O(m + n) space, but still not the best solution.
 * Could you devise a constant space solution?
 *
 * Created by zjm on 2019/6/7.
 */

 public class SetMatrixZeroes {

    //use two Set to remember the row and col of the element in matrix which value is 0, respectively
    public void setZeroes(int[][] matrix) {
        if(matrix.length < 1) {
            return;
        }
        int r = matrix.length;
        int c = matrix[0].length;
        Set<Integer> rSet = new HashSet();
        Set<Integer> cSet = new HashSet();
        for(int i = 0; i < r; i++) {
            for(int j = 0; j < c; j++) {
                if(matrix[i][j] == 0) {
                    rSet.add(i);
                    cSet.add(j);
                }
            }
        }
        if(rSet.size() > 0) {
            for(int n : rSet) {
                for(int i = 0; i < c; i++) {
                    matrix[n][i] = 0;
                }
            }
        }
        if(cSet.size() > 0) {
            for(int n : cSet) {
                for(int i = 0; i < r; i++) {
                    matrix[i][n] = 0;
                }
            }
        }
    }

    //use the first element of each row and col to remember the row and col of the element in matrix which value is 0, respectively
    public void setZeroesBetter(int[][] matrix) {
        if(matrix.length < 1) {
            return;
        }
        boolean isFirstRowHasZero = false;
        boolean isFirstColumnHasZero = false;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                if(matrix[i][j] == 0) {
                    if(i == 0) isFirstRowHasZero = true;
                    if(j == 0) isFirstColumnHasZero = true;
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        for(int i = 1; i < matrix.length; i++) {
            for(int j = 1; j < matrix[0].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }
        if(isFirstRowHasZero) {
            for(int i = 0; i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if(isFirstColumnHasZero) {
            for(int i = 0; i < matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }
    }
 }


