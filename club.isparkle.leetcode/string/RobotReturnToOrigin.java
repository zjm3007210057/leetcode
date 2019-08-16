package string;

/**
 * 657. Robot Return to Origin
 * <p>
 * There is a robot starting at position (0, 0), the origin, on a 2D plane.
 * Given a sequence of its moves, judge if this robot ends up at (0, 0) after
 * it completes its moves.
 * <p>
 * The move sequence is represented by a string, and the character moves[i]
 * represents its ith move. Valid moves are R (right), L (left), U (up), and D (down).
 * If the robot returns to the origin after it finishes all of its moves, return true.
 * Otherwise, return false.
 * <p>
 * Note: The way that the robot is "facing" is irrelevant. "R" will always make the robot
 * move to the right once, "L" will always make it move left, etc. Also, assume that
 * the magnitude of the robot's movement is the same for each move.
 * <p>
 * Example 1:
 * <p>
 * Input: "UD"
 * Output: true
 * Explanation: The robot moves up once, and then down once. All moves have the same magnitude,
 * so it ended up at the origin where it started. Therefore, we return true.
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: "LL"
 * Output: false
 * Explanation: The robot moves left twice. It ends up two "moves" to the left of the origin.
 * We return false because it is not at the origin at the end of its moves.
 * <p>
 * Created by zjm on 2019/8/16 21:06
 */
public class RobotReturnToOrigin {

    //设4个变量分别代表四个方向，最后如果左右，上下两两相等则返回true，否则返回false
    public boolean judgeCircle(String moves) {
        int r = 0, l = 0, u = 0, d = 0;
        for(char c : moves.toCharArray()) {
            if(c == 'R') {
                r++;
            }else if(c == 'L') {
                l++;
            }else if(c == 'U') {
                u++;
            }else if(c == 'D') {
                d++;
            }
        }
        return r == l && u == d;
    }
}
