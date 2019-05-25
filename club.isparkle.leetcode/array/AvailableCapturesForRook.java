package array;

/**
 * 999. Available Captures for Rook
 *
 * On an 8 x 8 chessboard, there is one white rook.  There also may be empty squares, white bishops, and black pawns.
 * These are given as characters 'R', '.', 'B', and 'p' respectively. Uppercase characters represent white pieces,
 * and lowercase characters represent black pieces.
 *
 * The rook moves as in the rules of Chess: it chooses one of four cardinal directions (north, east, west, and south),
 * then moves in that direction until it chooses to stop, reaches the edge of the board, or captures an opposite colored pawn
 * by moving to the same square it occupies.  Also, rooks cannot move into the same square as other friendly bishops.
 * Return the number of pawns the rook can capture in one move.
 *
 * Example 1:
 * Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","R",".",".",".","p"],
 * [".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],
 * [".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation:
 * In this example the rook is able to capture all the pawns.
 *
 * Example 2:
 * Input: [[".",".",".",".",".",".",".","."],[".","p","p","p","p","p",".","."],[".","p","p","B","p","p",".","."],
 * [".","p","B","R","B","p",".","."],[".","p","p","B","p","p",".","."],[".","p","p","p","p","p",".","."],
 * [".",".",".",".",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 0
 * Explanation:
 * Bishops are blocking the rook to capture any pawn.
 *
 * Example 3:
 * Input: [[".",".",".",".",".",".",".","."],[".",".",".","p",".",".",".","."],[".",".",".","p",".",".",".","."],
 * ["p","p",".","R",".","p","B","."],[".",".",".",".",".",".",".","."],[".",".",".","B",".",".",".","."],
 * [".",".",".","p",".",".",".","."],[".",".",".",".",".",".",".","."]]
 * Output: 3
 * Explanation:
 * The rook can capture the pawns at positions b5, d6 and f5.
 *
 * Note:
 * board.length == board[i].length == 8
 * board[i][j] is either 'R', '.', 'B', or 'p'
 * There is exactly one cell with board[i][j] == 'R'
 *
 * Created by zjm on 2019/5/25.
 */
public class AvailableCapturesForRook {

    public int numRookCaptures(char[][] board) {
        int row = 0;
        int column = 0;
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++){
                if(board[i][j] == 'R') {
                    row = i;
                    column = j;
                    break;
                }
            }
        }
        int res = 0;
        for(int i = column - 1; i >= 0; i--) {
            if(board[row][i] == 'p') {
                res++;
                break;
            }else if(board[row][i] == 'B') break;
        }
        for(int i = column + 1; i < board[0].length; i++) {
            if(board[row][i] == 'p') {
                res++;
                break;
            }else if(board[row][i] == 'B') break;
        }
        for(int j = row - 1; j >= 0; j--) {
            if(board[j][column] == 'p') {
                res++;
                break;
            }else if(board[j][column] == 'B') break;
        }
        for(int j = row + 1; j < board.length; j++) {
            if(board[j][column] == 'p') {
                res++;
                break;
            }else if(board[j][column] == 'B') break;
        }
        return res;
    }
}
