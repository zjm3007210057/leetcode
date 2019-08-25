package string;

/**
 * 925. Long Pressed Name
 *
 * Your friend is typing his name into a keyboard.  Sometimes, when typing a character c, the key might get long pressed, and the character will be typed 1 or more times.
 * You examine the typed characters of the keyboard.  Return True if it is possible that it was your friends name, with some characters (possibly none) being long pressed.
 *
 * Example 1:
 * Input: name = "alex", typed = "aaleex"
 * Output: true
 * Explanation: 'a' and 'e' in 'alex' were long pressed.
 *
 * Example 2:
 * Input: name = "saeed", typed = "ssaaedd"
 * Output: false
 * Explanation: 'e' must have been pressed twice, but it wasn't in the typed output.
 *
 * Example 3:
 * Input: name = "leelee", typed = "lleeelee"
 * Output: true
 *
 * Example 4:
 * Input: name = "laiden", typed = "laiden"
 * Output: true
 * Explanation: It's not necessary to long press any character
 *
 * @date 2019/8/25 上午9:46
 */
public class LongPressedName {

    //typed使用一个指针来指示已经判断的位置，循环遍历name，如果遇到对应typed[index]不等于name[i]，则typed[index]必须等于name[i-1]，
    //表示输入的时候重复了name[i-1]，然后继续判断
    public boolean isLongPressedName(String name, String typed) {
        if(typed.length() < name.length()) {
            return false;
        }
        int index = 0;
        char pre = name.charAt(0);
        for(int i = 0; i < name.length(); i++) {
            if(i > 0) {
                pre = name.charAt(i-1);
            }
            if(index < typed.length() && typed.charAt(index) == name.charAt(i)) {
                index++;
            }else if(index < typed.length() && typed.charAt(index) != name.charAt(i)) {
                while(index < typed.length() && typed.charAt(index) == pre) {
                    index++;
                }
                if(index >= typed.length() || typed.charAt(index) != name.charAt(i)) {
                    return false;
                }
                index++;
            }else {
                return false;
            }
        }
        //防止最后typed还有没有比较的字符，如果有，则后面所有的字符必须都等于name[name.length-1]
        if(index < typed.length()) {
            for(int i = index; i < typed.length(); i++) {
                if(typed.charAt(i) != name.charAt(name.length() - 1)) {
                    return false;
                }
            }
        }
        return true;
    }
}
