package string;

/**
 * 788. Rotated Digits
 * <p>
 * X is a good number if after rotating each digit individually by 180 degrees, we get a valid number
 * that is different from X.  Each digit must be rotated - we cannot choose to leave it alone.
 * <p>
 * A number is valid if each digit remains a digit after rotation. 0, 1, and 8 rotate to themselves;
 * 2 and 5 rotate to each other; 6 and 9 rotate to each other, and the rest of the numbers do not rotate
 * to any other number and become invalid.
 * <p>
 * Now given a positive number N, how many numbers X from 1 to N are good?
 * <p>
 * Example:
 * Input: 10
 * Output: 4
 * Explanation:
 * There are four good numbers in the range [1, 10] : 2, 5, 6, 9.
 * Note that 1 and 10 are not good numbers, since they remain unchanged after rotating.
 * Note:
 * <p>
 * N  will be in range [1, 10000]
 * <p>
 * Created by zjm on 2019/8/20 20:16
 */
public class RotatedDigits {

    //从题意中可以得知good number不能包含3、4、7中的任何一个，且必须包含2、5、6、9中的一个数
    //使用字符串来判断
    public int rotatedDigits(int N) {
        int res = 0;
        for(int i = 1; i <= N; i++) {
            if(isValid(String.valueOf(i))) {
                res++;
            }
        }
        return res;
    }

    private boolean isValid(String s) {
        boolean flag = false;
        for(char c : s.toCharArray()) {
            if(c == '3' || c == '4' || c == '7') return false;
            if(c == '2' || c == '5' || c == '6' || c == '9') flag = true;
        }
        return flag;
    }

    //使用数字来判断，比字符快
    public int rotatedDigitsBetter(int N) {
        int res = 0;
        for(int i = 1; i <= N; i++) {
            res += isValid(i) ? 1 : 0;
        }
        return res;
    }

    private boolean isValid(int n) {
        boolean flag = false;
        while(n > 0) {
            switch(n%10){
                case 3: case 4: case 7: return false;
                case 1: case 0: case 8: break;
                default: flag = true;
            }
            n = n/10;
        }
        return flag;
    }
}
