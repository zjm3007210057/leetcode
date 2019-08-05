package string;

/**
 * 67. Add Binary
 * <p>
 * Given two binary strings, return their sum (also a binary string).
 * <p>
 * The input strings are both non-empty and contains only characters 1 or 0.
 * <p>
 * Example 1:
 * <p>
 * Input: a = "11", b = "1"
 * Output: "100"
 * Example 2:
 * <p>
 * Input: a = "1010", b = "1011"
 * Output: "10101"
 *
 * Created by zjm on 2019/8/5 20:54
 */
public class AddBinary {

    public String addBinary(String a, String b) {
        int carry = 0;//进位
        StringBuilder sb = new StringBuilder();
        int aLen = a.length() - 1;
        int bLen = b.length() - 1;

        while (aLen >=0 || bLen >= 0 || carry == 1) {
            carry += aLen >= 0 ? a.charAt(aLen--) - '0' : 0;
            carry += bLen >= 0 ? b.charAt(bLen--) - '0' : 0;
            sb = sb.append(carry & 1);
            carry = carry >> 1;
        }
        StringBuilder res = new StringBuilder();
        for(int i = sb.length() - 1; i >= 0; i--) {
            res.append(sb.charAt(i));
        }
        return res.toString();
    }

}
