package string;

import java.util.ArrayList;

/**
 * 917. Reverse Only Letters
 *
 * Given a string S, return the "reversed" string where all characters that are not a letter stay in the same place, and all letters reverse their positions.
 *
 * Example 1:
 * Input: "ab-cd"
 * Output: "dc-ba"
 *
 * Example 2:
 * Input: "a-bC-dEf-ghIj"
 * Output: "j-Ih-gfE-dCba"
 *
 * Example 3:
 * Input: "Test1ng-Leet=code-Q!"
 * Output: "Qedo1ct-eeLg=ntse-T!"
 *
 * Note:
 * S.length <= 100
 * 33 <= S[i].ASCIIcode <= 122
 * S doesn't contain \ or "
 *
 * @date 2019/8/25 上午9:13
 */
public class ReverseOnlyLetters {

    //使用两个指针，分别从S头部和尾部来进行比对和交换
    public String reverseOnlyLetters(String S) {
        int l = 0, r = S.length() - 1;
        char[] cs = S.toCharArray();
        while(l < r) {
            while(l < r && !isLetter(cs[l])){
                l++;
            }
            while(l < r && !isLetter(cs[r])) {
                r--;
            }
            char tmp = cs[l];
            cs[l++] = cs[r];
            cs[r--] = tmp;
        }
        return new String(cs);
    }

    private boolean isLetter(char c) {
        if(c - 'a' >= 0 && c - 'z' <= 0) {
            return true;
        }
        if(c - 'A' >= 0 && c - 'Z' <= 0) {
            return true;
        }
        return false;
    }
}
