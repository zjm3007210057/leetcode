package string;

import java.util.HashMap;
import java.util.Map;

/**
 * 13. Roman to Integer
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
 * For example, two is written as II in Roman numeral, just two one's added together. Twelve is written as, XII,
 * which is simply X + II. The number twenty seven is written as XXVII, which is XX + V + II.
 * <p>
 * Roman numerals are usually written largest to smallest from left to right. However, the numeral for four
 * is not IIII. Instead, the number four is written as IV. Because the one is before the five we subtract it
 * making four. The same principle applies to the number nine, which is written as IX. There are six instances
 * where subtraction is used:
 * <p>
 * I can be placed before V (5) and X (10) to make 4 and 9.
 * X can be placed before L (50) and C (100) to make 40 and 90.
 * C can be placed before D (500) and M (1000) to make 400 and 900.
 * Given a roman numeral, convert it to an integer. Input is guaranteed to be within the range from 1 to 3999.
 * <p>
 * Example 1:
 * <p>
 * Input: "III"
 * Output: 3
 * Example 2:
 * <p>
 * Input: "IV"
 * Output: 4
 * Example 3:
 * <p>
 * Input: "IX"
 * Output: 9
 * Example 4:
 * <p>
 * Input: "LVIII"
 * Output: 58
 * Explanation: L = 50, V= 5, III = 3.
 * Example 5:
 * <p>
 * Input: "MCMXCIV"
 * Output: 1994
 * Explanation: M = 1000, CM = 900, XC = 90 and IV = 4
 * <p>
 * Created by zjm on 2019/7/24 21:20
 */
public class RomanToInteger {

    //IV表示4，VI表示6，XIX表示19，XXI表示21。可以找到规律，如果左边的字母表示的数字小于右边的字母，则用右边的数字减去左边的数字；反之，则需要进行加法。
    //s转成字符数组，每一个字符换成对应的数字，结果就是从最后一位一直累加到第一位的和，但是注意，如果上一位的值比目前的小，比如：s[2]=5，s[3]=10,
    //则需要将前一位的值取反
    public int romanToInt(String s) {
        Map<Character, Integer> map = new HashMap();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        int res = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(i > 0 && map.get(s.charAt(i)) > map.get(s.charAt(i-1))) {
                map.put(s.charAt(i-1), -map.get(s.charAt(i-1)));
            }
            res += map.get(s.charAt(i));
        }
        switch (map.get('V')) {
            case 100 : {
                break;
            }
            default: {

            }
        }
        return res;
    }

    //使用数组来实现
    public int romanToIntBetter(String s) {
        int[] arr = new int[s.length()];
        for(int i = 0; i < s.length(); i++) {
            switch(s.charAt(i)) {
                case 'M' : {
                    arr[i] = 1000;
                    break;
                }
                case 'D' : {
                    arr[i] = 500;
                    break;
                }
                case 'C' : {
                    arr[i] = 100;
                    break;
                }
                case 'L' : {
                    arr[i] = 50;
                    break;
                }
                case 'X' : {
                    arr[i] = 10;
                    break;
                }
                case 'V' : {
                    arr[i] = 5;
                    break;
                }
                case 'I' : {
                    arr[i] = 1;
                    break;
                }
                default : {
                    break;
                }
            }
        }
        int res = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            if(i > 0 && arr[i] > arr[i-1]) {
                arr[i-1] = -arr[i-1];
            }
            res += arr[i];
        }
        return res;
    }

}
