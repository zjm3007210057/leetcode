package array;

/**
 * 79. Word Search
 *
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those
 * horizontally or vertically neighboring. The same letter cell may not be used more than once.
 *
 * Example:
 * board =
 * [
 *  ['A','B','C','E'],
 *  ['S','F','C','S'],
 *  ['A','D','E','E']
 * ]
 * Given word = "ABCCED", return true.
 * Given word = "SEE", return true.
 * Given word = "ABCB", return false.
 *
 * Created by zjm on 2019/6/9.
 */
public class WordSearch {

    //use Back Tracing Algorithm
    public boolean exist(char[][] board, String word) {
        char[] arr = word.toCharArray();
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < board[0].length; j++) {
                if(help(board, i, j, arr, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean help(char[][] board, int r, int c, char[] chars, int index) {
        if(index == chars.length) {
            return true;
        }
        if(r < 0 || r >= board.length || c < 0 || c >= board[0].length || board[r][c] != chars[index]) {
            return false;
        }
        //avoid board[r][c] be reduplicated
        board[r][c] ^= 128;
        boolean res = help(board, r+1, c, chars, index+1) || help(board, r, c+1, chars, index+1) || help(board, r-1, c, chars, index+1) || help(board, r, c-1, chars, index+1);
        //recover board[r][c] since res is false.
        board[r][c] ^= 128;
        return res;
    }
}
