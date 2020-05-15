/**
 * Created by zjm on 2020/5/14 20:38
 */
public class PalindromeNumber {

    public boolean isPalindrome(int n) {
        if(n < 0) {
            return false;
        }
        int div = 1;
        while(n/div >= 10) {
            div *= 10;
        }
        while(n > 0) {
            int l = n /div;
            int r = n % 10;
            if(l != r) {
                return false;
            }
            n /= 100;
        }
        return true;
    }
}
