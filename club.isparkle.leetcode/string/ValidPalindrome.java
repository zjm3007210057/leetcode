package string;

/**
 * 125. Valid Palindrome
 * <p>
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * <p>
 * Note: For the purpose of this problem, we define empty string as valid palindrome.
 * <p>
 * Example 1:
 * <p>
 * Input: "A man, a plan, a canal: Panama"
 * Output: true
 * Example 2:
 * <p>
 * Input: "race a car"
 * Output: false
 * <p>
 * Created by zjm on 2019/8/6 21:21
 */
public class ValidPalindrome {

    //使用两个指针，分别从串头和串尾进行遍历，如果不是字母和数字则跳过，是的话则进行比较，一旦不同直接返回false
    public boolean isPalindrome(String s) {
        if (s.length() == 0) {
            return true;
        }
        int l = 0, r = s.length() - 1;
        while (l < r) {
            while (l < r && !isCharactersOrNum(s.charAt(l))) {
                l++;
            }
            while (r > l && !isCharactersOrNum(s.charAt(r))) {
                r--;
            }
            if (toLower(s.charAt(l)) != toLower(s.charAt(r))) {
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    //判断字符是否是字母和数字
    private boolean isCharactersOrNum(char c) {
        if (c - '0' < 0 || c - 'z' > 0) {
            return false;
        }
        if (c - 'Z' > 0 && c - 'a' < 0) {
            return false;
        }
        if (c - '9' > 0 && c - 'A' < 0) {
            return false;
        }
        return true;
    }

    //将字符变成小写
    private char toLower(char c) {
        if (c - 'Z' <= 0 && c - 'A' >= 0) {
            c = (char) (c + 'a' - 'A');
        }
        return c;
    }

}
