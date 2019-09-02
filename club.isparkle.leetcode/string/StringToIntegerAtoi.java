package string;

/**
 * 8. String to Integer (atoi)
 * <p>
 * Implement atoi which converts a string to an integer.
 * <p>
 * The function first discards as many whitespace characters as necessary until the first non-whitespace
 * character is found. Then, starting from this character, takes an optional initial plus or minus sign
 * followed by as many numerical digits as possible, and interprets them as a numerical value.
 * <p>
 * The string can contain additional characters after those that form the integral number, which are
 * ignored and have no effect on the behavior of this function.
 * <p>
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or if no
 * such sequence exists because either str is empty or it contains only whitespace characters,
 * no conversion is performed.
 * <p>
 * If no valid conversion could be performed, a zero value is returned.
 * <p>
 * Note:
 * <p>
 * Only the space character ' ' is considered as whitespace character.
 * Assume we are dealing with an environment which could only store integers within the 32-bit signed
 * integer range:[−231,  231 − 1]. If the numerical value is out of the range of representable values,
 * INT_MAX (231 − 1) or INT_MIN (−231) is returned.
 *
 * Example 1:
 * Input: "42"
 * Output: 42
 *
 * Example 2:
 * Input: "   -42"
 * Output: -42
 * Explanation: The first non-whitespace character is '-', which is the minus sign.
 * Then take as many numerical digits as possible, which gets 42.
 *
 * Example 3:
 * Input: "4193 with words"
 * Output: 4193
 * Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
 *
 * Example 4:
 * Input: "words and 987"
 * Output: 0
 * Explanation: The first non-whitespace character is 'w', which is not a numerical
 * digit or a +/- sign. Therefore no valid conversion could be performed.
 *
 * Example 5:
 * Input: "-91283472332"
 * Output: -2147483648
 * Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
 * Thefore INT_MIN (−231) is returned
 * <p>
 * Created by zjm on 2019/9/2 20:41
 */
public class StringToIntegerAtoi {

    //考虑符号和特殊值就行
    public int myAtoi(String str) {
        str = str.trim();
        if(str.length() < 1) {
            return 0;
        }
        boolean flag = true;
        int index = 0;
        if(str.charAt(0) == '-') {
            flag = false;
            index++;
        }else if(str.charAt(0) == '+') {
            index++;
        }
        int res = 0;
        while(index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            //如果Integer.MAX_VALUE / 10 < res表明下一次乘积之后res的值将大于Integer>MAX_VALUE
            if(Integer.MAX_VALUE / 10 < res) {
                return flag ? Integer.MAX_VALUE : Integer.MIN_VALUE;
            }
            res = res * 10 + (str.charAt(index) - '0');
            index++;
        }
        //res=Integer.MAX_VALUE+1，2时（res最后的个位数大于Integer.MAX_VALUE），此时res会变成一个负数
        if(flag && res < 0) {
            return Integer.MAX_VALUE;
        }
        if(!flag) {
            //res=Integer.MIN_VALUE-1时（res最后的个位数大于Integer.MAX_VALUE），此时res会变成一个负数
            if(res < 0) {
                return Integer.MIN_VALUE;
            }
            return -res;
        }
        return res;
    }

}
