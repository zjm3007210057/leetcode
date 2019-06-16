package array;

/**
 * 289. Game of Life
 * <p>
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life, is a cellular automaton
 * devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0). Each cell interacts
 * with its eight neighbors (horizontal, vertical, diagonal) using the following four rules (taken from the above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 * The next state is created by applying the above rules simultaneously to every cell in the current state,
 * where births and deaths occur simultaneously.
 * <p>
 * Example:
 * <p>
 * Input:
 * [
 * [0,1,0],
 * [0,0,1],
 * [1,1,1],
 * [0,0,0]
 * ]
 * Output:
 * [
 * [0,0,0],
 * [1,0,1],
 * [0,1,1],
 * [0,1,0]
 * ]
 * Follow up:
 * <p>
 * Could you solve it in-place? Remember that the board needs to be updated at the same time:
 * You cannot update some cells first and then use their updated values to update other cells.
 * In this question, we represent the board using a 2D array. In principle, the board is infinite,
 * which would cause problems when the active area encroaches the border of the array. How would you address these problems?
 * <p>
 * Created by zjm on 2019/6/16 22:34
 */
public class GameOfLife {

    int[] dimx = new int[]{-1, 1, 0, 0, -1, -1, 1, 1};
    int[] dimy = new int[]{0, 0, -1, 1, -1, 1, -1, 1};

    //use four numbers to record each element status
    public void gameOfLife(int[][] board) {
        int n = board.length;
        int m = board[0].length;
        if(n == 0 || m == 0) return;
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                int live = liveNeighbor(board, i, j, n, m);
                if(board[i][j] == 1 && (live == 2 || live == 3)) {
                    board[i][j] = 3;
                }else if (board[i][j] == 0 && live == 3) {
                    board[i][j] = 2;
                }
            }
        }
        //convert state back to dead or live
        for(int i = 0; i < n; i++) {
            for(int j = 0; j < m; j++) {
                board[i][j] >>= 1;
            }
        }
    }

    // count cell's live neighbors 3x3 matrix
    int liveNeighbor(int[][] board, int i, int j, int n, int m) {
        int live = 0;
        for(int k = 0; k < 8; k++) {
            int tmpi = i + dimx[k];
            int tmpj = j + dimy[k];
            if (tmpi >= 0 && tmpi < n && tmpj >= 0 && tmpj < m) {
                live += board[tmpi][tmpj] & 1;
            }
        }
        return live;
    }
}
