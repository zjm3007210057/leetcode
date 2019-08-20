package string;

/**
 * 709. To Lower Case
 * <p>
 * Implement function ToLowerCase() that has a string parameter str, and returns the same string in lowercase.
 * <p>
 * Example 1:
 * <p>
 * Input: "Hello"
 * Output: "hello"
 * Example 2:
 * <p>
 * Input: "here"
 * Output: "here"
 * Example 3:
 * <p>
 * Input: "LOVELY"
 * Output: "lovely"
 * <p>
 * Created by zjm on 2019/8/20 20:08
 */
public class ToLowerCase {

    //直接使用字符加减法即可，注意排除字母以外的字符
    public String toLowerCase(String str) {
        char[] cs = new char[str.length()];
        for(int i = 0; i < str.length(); i++) {
            if(str.charAt(i) - 'a' >= 0 && str.charAt(i) - 'z' <= 0) {
                cs[i] = str.charAt(i);
            }else if(str.charAt(i) - 'A' >= 0 && str.charAt(i) - 'Z' <= 0){
                cs[i] = (char)(str.charAt(i) + 'a' - 'A');
            }else {
                cs[i] = str.charAt(i);
            }
        }
        return new String(cs);
    }
}
