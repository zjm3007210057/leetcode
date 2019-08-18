package string;

/**
 * 680. Valid Palindrome II
 *
 * Given a non-empty string s, you may delete at most one character. Judge whether you can make it a palindrome.
 *
 * Example 1:
 * Input: "aba"
 * Output: True
 * Example 2:
 * Input: "abca"
 * Output: True
 * Explanation: You could delete the character 'c'.
 *
 * Note:
 * The string will only contain lowercase characters a-z. The maximum length of the string is 50000.
 *
 * @date 2019/8/18 AM 9:35
 */
public class ValidPalindromeII {

    //使用两个指针分别从两端进行判断，如果遇到字符不等，则删除其中的一个字符，分两种情况再判断剩下的字符是否满足条件
    public boolean validPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                StringBuilder sb1 = new StringBuilder();
                sb1.append(s.substring(0, l));
                sb1.append(s.substring(l+1, s.length()));
                StringBuilder sb2 = new StringBuilder();
                sb2.append(s.substring(0, r));
                sb2.append(s.substring(r+1, s.length()));
                if(isPalindrome(sb1.toString(), 0, s.length() - 2) || isPalindrome(sb2.toString(), 0, s.length() - 2)) {
                    return true;
                }else {
                    return false;
                }
            }
            l++;
            r--;
        }
        return true;
    }

    //在前一种方法上优化，不使用StringBuilder，直接使用原字符串s和对应的位置来做判断
    public boolean validPalindromeBetter(String s) {
        int l = 0;
        int r = s.length() - 1;
        while(l < r) {
            if(s.charAt(l) != s.charAt(r)) {
                if(isPalindrome(s, l, r-1) || isPalindrome(s, l+1, r)) {
                    return true;
                }
                return false;
            }
            l++;
            r--;
        }
        return true;
    }

    private boolean isPalindrome(String s, int l, int r) {
        while(l < r) {
            if(s.charAt(l++) != s.charAt(r--)) {
                return false;
            }
        }
        return true;
    }

}
