package sort;

import java.util.Arrays;
import java.util.Comparator;

/**
 * 1030. Matrix Cells in Distance Order
 *
 * We are given a matrix with R rows and C columns has cells with integer coordinates (r, c), where 0 <= r < R and 0 <= c < C.
 * Additionally, we are given a cell in that matrix with coordinates (r0, c0).
 * Return the coordinates of all cells in the matrix, sorted by their distance from (r0, c0) from smallest distance to largest distance.  Here, the distance between two cells (r1, c1) and (r2, c2) is the Manhattan distance, |r1 - r2| + |c1 - c2|.  (You may return the answer in any order that satisfies this condition.)
 *
 * Example 1:
 * Input: R = 1, C = 2, r0 = 0, c0 = 0
 * Output: [[0,0],[0,1]]
 * Explanation: The distances from (r0, c0) to other cells are: [0,1]
 *
 * Example 2:
 * Input: R = 2, C = 2, r0 = 0, c0 = 1
 * Output: [[0,1],[0,0],[1,1],[1,0]]
 * Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2]
 * The answer [[0,1],[1,1],[0,0],[1,0]] would also be accepted as correct.
 *
 * Example 3:
 * Input: R = 2, C = 3, r0 = 1, c0 = 2
 * Output: [[1,2],[0,2],[1,1],[0,1],[1,0],[0,0]]
 * Explanation: The distances from (r0, c0) to other cells are: [0,1,1,2,2,3]
 * There are other answers that would also be accepted as correct, such as [[1,2],[1,1],[0,2],[1,0],[0,1],[0,0]].
 *
 * Note:
 * 1 <= R <= 100
 * 1 <= C <= 100
 * 0 <= r0 < R
 * 0 <= c0 < C
 *
 * @date 2019/10/5 上午11:41
 */
public class MatrixCellsInDistanceOrder {

    //先将二维数组中的元素初始化好，再根据每个元素到到(r0,c0)的曼哈顿距离来排序数组元素。
    //我们借助Arrays的sort方法，在sort方法第二个参数里，实现Comparator接口，重写其compare方法，
    //排序规则依据两点的曼哈顿距离大小来定，最后输出排序后的数组即可
    public int[][] allCellsDistOrder(int R, int C, final int r0, final int c0) {
        int[][] res = new int[R * C][2];
        int index = 0;
        for(int i = 0; i < R; i++) {
            for(int j = 0; j < C; j++) {
                res[index][0] = i;
                res[index][1] = j;
                index++;
            }
        }
        Arrays.sort(res, new Comparator<int[]>(){
            public int compare(int[] a, int[] b) {
                int d1 = Math.abs(a[0] - r0) + Math.abs(a[1] - c0);
                int d2 = Math.abs(b[0] - r0) + Math.abs(b[1] - c0);
                return d1 - d2;
            }
        });
        return res;
    }
}
