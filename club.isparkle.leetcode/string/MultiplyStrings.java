package string;

/**
 * 43. Multiply Strings
 * <p>
 * Given two non-negative integers num1 and num2 represented as strings, return the product of num1 and num2, also represented as a string.
 * <p>
 * Example 1:
 * <p>
 * Input: num1 = "2", num2 = "3"
 * Output: "6"
 * Example 2:
 * <p>
 * Input: num1 = "123", num2 = "456"
 * Output: "56088"
 * Note:
 * <p>
 * The length of both num1 and num2 is < 110.
 * Both num1 and num2 contain only digits 0-9.
 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * <p>
 * Created by zjm on 2019/9/6 20:26
 */
public class MultiplyStrings {

    //按位分别乘积，然后再按位求和，最后倒序，因为从最低位开始计算，注意类型转换
    public String multiply(String num1, String num2) {
        if(num1.length() < 1 || num2.length() < 1) {
            return "";
        }
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        char[] ch1 = num1.toCharArray();
        char[] ch2 = num2.toCharArray();
        char[] cs = new char[ch1.length + ch2.length];
        for(int i = ch2.length - 1; i >= 0; i--) {
            for(int j = ch1.length - 1; j >= 0; j--) {
                int tmp = (ch2[i] - '0') * (ch1[j] - '0');
                int mod;
                if(cs[ch1.length+ch2.length-i-j-2] == '\u0000') {
                    cs[ch1.length+ch2.length-i-j-2] = (char)(tmp % 10 + '0');
                    if(cs[ch1.length+ch2.length-i-j-1] == '\u0000' && tmp > 9) {
                        cs[ch1.length+ch2.length-i-j-1] = (char)(tmp / 10 + '0');
                    }else {
                        cs[ch1.length+ch2.length-i-j-1] = (char)((tmp / 10 + (cs[ch1.length+ch2.length-i-j-1] - '0') + '0'));
                    }
                }else {
                    mod = tmp % 10 + (cs[ch1.length+ch2.length-i-j-2] - '0');
                    if(cs[ch1.length+ch2.length-i-j-1] == '\u0000' && (tmp > 9 || mod > 9)) {
                        cs[ch1.length+ch2.length-i-j-1] = (char)(tmp / 10 + mod / 10 + '0');
                    }else {
                        cs[ch1.length+ch2.length-i-j-1] = (char)((tmp / 10 + mod / 10 + (cs[ch1.length+ch2.length-i-j-1] - '0') + '0'));
                    }
                    cs[ch1.length+ch2.length-i-j-2] = (char)(mod % 10 + '0');
                }
            }
        }
        int left = 0, right = ch1.length + ch2.length - 1, tmp = right;
        for(int i = ch1.length + ch2.length - 1; i >= 0; i--) {
            if(cs[i] != '\u0000') {
                right = i;
                tmp = i;
                break;
            }
        }
        while(left <= right) {
            char c = cs[left];
            cs[left] = cs[right];
            cs[right] = c;
            left++;
            right--;
        }
        return new String(cs).substring(0, tmp + 1);
    }

    //上面方法的优化，先用整数数组来存放，最后再转成字符
    public String multiplyBetter(String num1, String num2) {
        if(num1.length() < 1 || num2.length() < 1) {
            return "";
        }
        if(num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        int m = num1.length(), n = num2.length();
        int[] res = new int[m+n];
        for(int i = m-1; i >= 0; i--) {
            int digit1 = num1.charAt(i) - '0';
            for(int j = n-1; j >= 0; j--) {
                int digit2 = num2.charAt(j)-'0';
                res[i+j+1] += digit1 * digit2;
                res[i+j] += res[i+j+1] / 10;
                res[i+j+1] = res[i+j+1] % 10;
            }
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < res.length; i++) {
            if(sb.length() == 0 && res[i] == 0) continue;
            sb.append(res[i]);
        }

        if(sb.length() == 0) {
            sb.append(0);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        MultiplyStrings ms = new MultiplyStrings();
        System.out.println(ms.multiply("9102908", "7602608"));
        System.out.println(9102908l * 7602608l);
        char[] cs = new char[1];
        System.out.println(cs[0]);
    }
}
