package string;

/**
 * 415. Add Strings
 * <p>
 * Given two non-negative integers num1 and num2 represented as string, return the sum of num1 and num2.
 * <p>
 * Note:
 * <p>
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * Created by zjm on 2019/8/8 21:52
 */
public class AddStrings {

    //根据题意直接的出
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int len1 = num1.length() - 1;
        int len2 = num2.length() - 1;
        int carry = 0;
        while(len1 >= 0 || len2 >= 0 || carry == 1) {
            int sum = carry + (len1 >= 0 ? (num1.charAt(len1) - '0') : 0) + (len2 >= 0 ? (num2.charAt(len2) - '0') : 0);
            if(sum > 9) {
                sum %= 10;
                carry = 1;
            }else {
                carry = 0;
            }
            sb.append(sum + "");
            len1--;
            len2--;
        }
        StringBuilder res = new StringBuilder();
        for(int i = sb.length() - 1; i >= 0; i--) {
            res.append(sb.charAt(i));
        }
        return res.toString();
    }

}
