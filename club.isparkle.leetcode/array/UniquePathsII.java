package array;

/**
 * 63. Unique Paths II
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach 
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 *
 * Note: m and n will be at most 100.
 * Example 1:
 * Input:
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * Output: 2
 * Explanation:
 * There is one obstacle in the middle of the 3x3 grid above.
 * There are two ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down -> Down
 * 2. Down -> Down -> Right -> Right
 *
 * Created by zjm on 2019/6/7.
 */
public class UniquePathsII {

    //just like UniquePaths, only need consider the vlue of obstacleGrid[i][j] is 1 or not.
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        if(obstacleGrid.length < 1) {
            return 0;
        }
        int r = obstacleGrid.length;
        int c = obstacleGrid[0].length;
        int[][] res = new int[r][c];
        for(int i = 0; i < r; i++) {
            if(obstacleGrid[i][0] == 1) {
                break;
            }
            res[i][0] = 1;
        }
        for(int i = 0; i < c; i++) {
            if(obstacleGrid[0][i] == 1) {
                break;
            }
            res[0][i] = 1;
        }
        for(int i = 1; i < r; i++) {
            for(int j = 1; j < c; j++) {
                if(obstacleGrid[i][j] != 1) {
                    res[i][j] = res[i - 1][j] + res[i][j - 1];   
                }
            }
        }
        return res[r-1][c-1];
    }
}
