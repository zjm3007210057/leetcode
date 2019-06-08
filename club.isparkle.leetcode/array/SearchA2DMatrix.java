package array;

/**
 * 74. Search a 2D Matrix
 *
 * Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:
 *
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 * Example 1:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 3
 * Output: true
 * Example 2:
 *
 * Input:
 * matrix = [
 *   [1,   3,  5,  7],
 *   [10, 11, 16, 20],
 *   [23, 30, 34, 50]
 * ]
 * target = 13
 * Output: false
 *
 * Created by zjm on 2019/6/8.
 */
public class SearchA2DMatrix {

    //use binary search
    public boolean searchMatrix(int[][] matrix, int target) {
        if(matrix.length < 1) {
            return false;
        }else if(matrix.length == 1 && matrix[0].length == 1) {
            return matrix[0][0] == target;
        }
        int cs = 0;
        int ce = matrix[0].length - 1;
        int rs = 0;
        int re = matrix.length - 1;
        int cmid;
        int rmid;
        while(rs < re) {
            if(matrix[rs][ce] == target || matrix[rs][cs] == target) {
                return true;
            }else if(matrix[re][ce] == target || matrix[re][cs] == target) {
                return true;
            }
            rmid = (re - rs) / 2 + rs;
            if(matrix[rmid][ce] == target) {
                return true;
            }else if(matrix[rmid][ce] < target) {
                rs = rmid + 1;
            }else if(matrix[rmid][ce] > target && matrix[rmid][cs] > target){
                re = rmid - 1;
            }else {
                rs = rmid;
                break;
            }
        }
        while(cs < ce) {
            cmid = (ce - cs) / 2 + cs;
            if(matrix[rs][cs] == target) {
                return true;
            }else if(matrix[rs][ce] == target) {
                return true;
            }
            if(matrix[rs][cmid] == target) {
                return true;
            }else if(matrix[rs][cmid] < target) {
                cs = cmid + 1;
            }else {
                ce = cmid - 1;
            }
        }
        return false;
    }

    public boolean searchMatrixSimple(int[][] matrix, int target) {
        if(matrix.length < 1 || matrix[0].length < 1) {
            return false;
        }
        int r = 0;
        //find target in which row
        while (r < matrix.length) {
            if(matrix[r][matrix[0].length - 1] < target) {
                r++;
            }else if(matrix[r][matrix[0].length - 1] == target){
                return true;
            }else {
                break;
            }
        }
        if(r >= matrix.length) {
            return false;
        }
        int s = 0;
        int e = matrix[0].length - 1;
        int mid;
        while(s < e) {
            if(matrix[r][s] == target) {
                return true;
            }else if(matrix[r][e] == target) {
                return true;
            }
            mid = (e - s) / 2 + s;
            if(matrix[r][mid] == target) {
                return true;
            }else if(matrix[r][mid] < target) {
                s = mid + 1;
            }else {
                e = mid - 1;
            }
        }
        return false;
    }
}
