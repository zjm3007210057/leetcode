package array;

/**
 * 62. Unique Paths
 *
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach
 * the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * Note: m and n will be at most 100.
 *
 * Example 1:
 * Input: m = 3, n = 2
 * Output: 3
 * Explanation:
 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
 * 1. Right -> Right -> Down
 * 2. Right -> Down -> Right
 * 3. Down -> Right -> Right
 *
 * Example 2:
 * Input: m = 7, n = 3
 * Output: 28
 *
 * Created by zjm on 2019/6/6.
 */
public class UniquePaths {

    //use dp, f(m, n) = f(m-1, n) + f(m, n-1)
    public int uniquePaths(int m, int n) {
        //f(m, n) = f(m-1, n) + f(m, n-1);
        //f(2, 1) = f(1, 2) = f(1, 1) = 1;
        if(m < 1 || n < 1) {
            return 0;
        }
        if(m == 1 || n == 1) {
            return 1;
        }
        int[][] arr = new int[m][n];
        for(int i = 0; i < n; i++) {
            arr[0][i] = 1;
        }
        for(int i = 0; i < m; i++) {
            arr[i][0] = 1;
        }
        for(int i = 1; i < m; i++) {
            for(int j = 1; j < n; j++) {
                arr[i][j] = arr[i-1][j] + arr[i][j-1];
            }
        }
        return arr[m-1][n-1];
    }

    public int uniquePathsBetter(int m, int n) {
        //select m - 1 from m + n - 2
        if(m < 1 || n < 1) {
            return 0;
        }
        if(m == 1 || n == 1) {
            return 1;
        }
        int min = Math.min(m, n);
        double factorial = 1.0;
        double tmp = 1.0;
        for(int i = 1; i < min; i++) {
            factorial *= (m + n - 1 - i);
            tmp *= i;
        }
        return (int)(factorial / tmp);
    }
}
