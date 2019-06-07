package array;

/**
 * 63. Unique Paths II
 *
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * Example:
 * Input:
 * [
 *  [1,3,1],
 *  [1,5,1],
 *  [4,2,1]
 * ]
 * Output: 7
 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
 *
 * Created by zjm on 2019/6/7.
 */
 public class MinimumPathSum {
    
      //just like UniquePaths
      public int minPathSum(int[][] grid) {
        if(grid.length < 1) {
            return 0;
        }
        int r = grid.length;
        int c = grid[0].length;
        int[][] res = new int[r][c];
        for(int i = 0; i < c; i++) {
            res[0][i] = i == 0 ? grid[0][0] : res[0][i - 1] + grid[0][i];
        }
        for(int i = 1; i < r; i++) {
            res[i][0] = res[i - 1][0] + grid[i][0];
        }
        for(int i = 1; i < r; i++) {
            for(int j = 1 ; j < c; j++) {
                res[i][j] = Math.min(res[i-1][j], res[i][j-1]) + grid[i][j];
            }
        }
        return res[r- 1][c - 1];
    }
 }
