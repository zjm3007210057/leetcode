package string;

/**
 * 12. Integer to Roman
 * <p>
 * Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.
 * <p>
 * Symbol       Value
 * I             1
 * V             5
 * X             10
 * L             50
 * C             100
 * D             500
 * M             1000
 * For example, two is written as II in Roman numeral, just two one's added together.
 * Twelve is written as, XII, which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral
 * for four is not IIII. Instead, the number four is written as IV. Because the one is before the
 * five we subtract it making four. The same principle applies to the number nine, which is written
 * as IX. There are six instances where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given an integer, convert it to a roman numeral. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * Input: 3
 * Output: "III"
 *
 * Example 2:
 * Input: 4
 * Output: "IV"
 *
 * Example 3:
 * Input: 9
 * Output: "IX"
 *
 * Example 4:
 * Input: 58
 * Output: "LVIII"
 * Explanation: L = 50, V = 5, III = 3.
 *
 * Example 5:
 * Input: 1994
 * Output: "MCMXCIV"
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4
 * <p>
 * Created by zjm on 2019/9/3 19:20
 */
public class IntegerToRoman {

    //将num从个位开始转换，转换后再将字符串倒顺，记得转换的过程中要将4：iV变成vi，因为后面要倒序
    public String intToRoman(int num) {
        if(num < 1 || num >= 4000) {
            return "";
        }
        String[] arr = {"I", "V", "X", "L", "C", "D", "M"};
        StringBuilder sb = new StringBuilder();
        int index = 0;
        while(num > 0) {
            int tmp = num % 10;
            if(tmp < 4 && tmp > 0) {
                for(int i = 0; i < tmp; i++) {
                    sb.append(arr[index]);
                }
            }else if(tmp == 4) {
                sb.append(arr[index+1]).append(arr[index]);
            }else if(tmp > 4 && tmp < 9) {
                for(int j = 0; j < tmp - 5; j++) {
                    sb.append(arr[index]);
                }
                sb.append(arr[index+1]);
            }else if(tmp == 9) {
                sb.append(arr[index+2]).append(arr[index]);
            }
            num /= 10;
            index += 2;
        }
        String s = sb.toString();
        char[] cs = new char[s.length()];
        for(int i = s.length() - 1; i >= 0; i--) {
            cs[s.length() - 1 - i] = s.charAt(i);
        }
        return new String(cs);
    }

    //将所有的都列出来，然后分别组合就行
    public String intToRomanFast(int num) {
        String M[] = {"", "M", "MM", "MMM"};
        String C[] = {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"};
        String X[] = {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"};
        String I[] = {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"};
        return M[num/1000] + C[(num%1000)/100] + X[(num%100)/10] + I[num%10];
    }

    public static void main(String[] args) {
        IntegerToRoman it = new IntegerToRoman();
        System.out.println(it.intToRoman(3897));
    }
}
