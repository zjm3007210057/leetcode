package array;

import java.util.HashSet;
import java.util.Set;

/**
 * 840. Magic Squares In Grid
 * <p>
 * A 3 x 3 magic square is a 3 x 3 grid filled with distinct numbers from 1 to 9 such that each row, column, and both diagonals all have the same sum.
 * Given an grid of integers, how many 3 x 3 "magic square" subgrids are there?  (Each subgrid is contiguous).
 * <p>
 * Example 1:
 * Input: [[4,3,8,4],
 * [9,5,1,9],
 * [2,7,6,2]]
 * Output: 1
 * <p>
 * Explanation:
 * The following subgrid is a 3 x 3 magic square:
 * 438
 * 951
 * 276
 * while this one is not:
 * 384
 * 519
 * 762
 * In total, there is only one magic square inside the given grid.
 * <p>
 * Note:
 * 1 <= grid.length <= 10
 * 1 <= grid[0].length <= 10
 * 0 <= grid[i][j] <= 15
 * <p>
 * Created by zjm on 2019/5/22.
 */
public class MagicSquaresInGrid {

    public int numMagicSquaresInside(int[][] grid) {
        if (grid.length < 3 || grid[0].length < 3) {
            return 0;
        }
        int res = 0;
        for (int i = 2; i < grid.length; i++) {
            for (int j = 2; j < grid[0].length; j++) {
                if (isMagic(grid, i, j)) res++;
            }
        }
        return res;
    }

    public boolean isMagic(int[][] arr, int r, int c) {
        Set<Integer> set = new HashSet();
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (set.contains(arr[r - i][c - j]) || arr[r - i][c - j] > 9 || arr[r - i][c - j] < 1) return false;
                set.add(arr[r - i][c - j]);
            }
        }
        int m = arr[r - 2][c - 2] + arr[r - 1][c - 1] + arr[r][c];
        if (arr[r - 2][c - 2] + arr[r - 2][c - 1] + arr[r - 2][c] != m) {
            return false;
        } else if (arr[r - 1][c - 2] + arr[r - 1][c - 1] + arr[r - 1][c] != m) {
            return false;
        } else if (arr[r][c - 2] + arr[r][c - 1] + arr[r][c] != m) {
            return false;
        } else if (arr[r - 2][c] + arr[r - 1][c] + arr[r][c] != m) {
            return false;
        } else if (arr[r - 2][c - 2] + arr[r - 1][c - 2] + arr[r][c - 2] != m) {
            return false;
        } else if (arr[r - 2][c - 1] + arr[r - 1][c - 1] + arr[r][c - 1] != m) {
            return false;
        } else if (arr[r][c - 2] + arr[r - 1][c - 1] + arr[r - 2][c] != m) {
            return false;
        }
        return true;
    }
}
