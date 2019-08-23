package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 859. Buddy Strings
 * <p>
 * Given two strings A and B of lowercase letters, return true if
 * and only if we can swap two letters in A so that the result equals B.
 * <p>
 * Example 1:
 * <p>
 * Input: A = "ab", B = "ba"
 * Output: true
 * Example 2:
 * <p>
 * Input: A = "ab", B = "ab"
 * Output: false
 * Example 3:
 * <p>
 * Input: A = "aa", B = "aa"
 * Output: true
 * Example 4:
 * <p>
 * Input: A = "aaaaaaabc", B = "aaaaaaacb"
 * Output: true
 * Example 5:
 * <p>
 * Input: A = "", B = "aa"
 * Output: false
 * <p>
 * Note:
 * <p>
 * 0 <= A.length <= 20000
 * 0 <= B.length <= 20000
 * A and B consist only of lowercase letters
 * <p>
 * Created by zjm on 2019/8/23 22:18
 */
public class BuddyStrings {

    //分情况，一种A和B完全相等，这时只要A中有相同的字符即可。如果不相等，
    //则记录它们字符不相等的索引位置，如果不相等的字符的个数为2个而且满足交叉相等，则这样的字符串就是满足条件的
    public boolean buddyStrings(String A, String B) {
        if(A.length() != B.length() || A.length() < 2) {
            return false;
        }
        int dif = 0, n1 = -1, n2 = -1;
        for(int i = 0; i < A.length(); i++) {
            if(A.charAt(i) != B.charAt(i)) {
                dif++;
                if(n1 == -1) {
                    n1 = i;
                }else {
                    n2 = i;
                }
            }
            if(dif > 2) {
                return false;
            }
        }
        if(dif == 1) {
            return false;
        }else if(dif == 0) {
            return isTwoCharSame(A);
        }
        return A.charAt(n1) == B.charAt(n2) && A.charAt(n2) == B.charAt(n1);
    }

    private boolean isTwoCharSame(String s) {
        Set<Character> set = new HashSet();
        for(char c : s.toCharArray()) {
            if(set.contains(c)) {
                return true;
            }
            set.add(c);
        }
        return false;
    }
}
