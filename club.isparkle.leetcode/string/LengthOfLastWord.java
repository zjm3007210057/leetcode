package string;

/**
 * 58. Length of Last Word
 * <p>
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ', return the length of last word in the string.
 * <p>
 * If the last word does not exist, return 0.
 * <p>
 * Note: A word is defined as a character sequence consists of non-space characters only.
 * <p>
 * Example:
 * <p>
 * Input: "Hello World"
 * Output: 5
 * Created by zjm on 2019/8/5 20:36
 */
public class LengthOfLastWord {

    //直接根据题意
    public int lengthOfLastWord(String s) {
        if(s.length() == 0) {
            return 0;
        }
        int res = 0;
        int index = s.length() - 1;
        //将末尾的空字符排除，可以使用String.trim()方法
        while(index >= 0 && s.charAt(index) == ' ') {
            index--;
        }
        for(int i = index; i >= 0; i--) {
            if(s.charAt(i) != ' ') {
                res++;
            }else if(s.charAt(i) == ' '){
                break;
            }
        }
        return res;
    }

    //使用jdk String自带的方法
    public int lengthOfLastWordSimple(String s) {
        return s.trim().length()-s.trim().lastIndexOf(" ") - 1;
    }
}
