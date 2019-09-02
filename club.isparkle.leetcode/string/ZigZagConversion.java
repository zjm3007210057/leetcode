package string;

/**
 * 6. ZigZag Conversion
 * <p>
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * <p>
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * <p>
 * Write the code that will take a string and make this conversion given a number of rows:
 * <p>
 * string convert(string s, int numRows);
 * Example 1:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 3
 * Output: "PAHNAPLSIIGYIR"
 * Example 2:
 * <p>
 * Input: s = "PAYPALISHIRING", numRows = 4
 * Output: "PINALSIGYAHRPI"
 * Explanation:
 * <p>
 * P     I    N
 * A   L S  I G
 * Y A   H R
 * P     I
 * <p>
 * Created by zjm on 2019/9/1 22:36
 */
public class ZigZagConversion {

    //找规律，第一行字符串s中两字符之间间隔为 numRows * 2 - 2，后面的行依次再减2，比如第二行为 numRows * 2 - 4
    public String convert(String s, int numRows) {
        //特殊情况 字符串长度小于numRows，numRows=1，直接返回s
        if(s.length() <= numRows || numRows == 1) {
            return s;
        }
        StringBuilder sb = new StringBuilder();
        int interval = numRows * 2 - 2, index;
        for(int row = 0; row < numRows; row++) {
            for(int j = row; j < s.length(); j += interval) {
                sb.append(s.charAt(j));
                index = j + interval - (2 * row);
                if(!(row == 0 || row == numRows - 1) && index < s.length()) {
                    sb.append(s.charAt(index));
                }
            }
        }
        return sb.toString();
    }
}
