package string;

/**
 * 1071. Greatest Common Divisor of Strings
 * <p>
 * For strings S and T, we say "T divides S" if and only if S = T + ... + T
 * (T concatenated with itself 1 or more times)
 * <p>
 * Return the largest string X such that X divides str1 and X divides str2.
 * <p>
 * Example 1:
 * Input: str1 = "ABCABC", str2 = "ABC"
 * Output: "ABC"
 *
 * Example 2:
 * Input: str1 = "ABABAB", str2 = "ABAB"
 * Output: "AB"
 *
 * Example 3:
 * Input: str1 = "LEET", str2 = "CODE"
 * Output: ""
 * <p>
 * Note:
 * 1 <= str1.length <= 1000
 * 1 <= str2.length <= 1000
 * str1[i] and str2[i] are English uppercase letters
 * <p>
 * Created by zjm on 2019/8/27 20:10
 */
public class GreatestCommonDivisorOfStrings {

    /**
     * 假设：str1.length > str2.length
     * 因为是公共子串，所以str2一定可以和str1前面一部分匹配上，否则不存在公共子串。
     * 所以比较str2和str1的0~str2.length()-1部分,若不同，则直接返回””，不存在公共子串。
     * 若相同，继续比较str2和str1的剩下部分，这里就是递归了，调用原函数gcd(str2, str1.substring(str2.length))
     */
    public String gcdOfStrings(String str1, String str2) {
        return GCD(str1, str2);
    }

    private String GCD(String a, String b) {
        if (a.length() > b.length()) {
            for (int i = 0; i < b.length(); i++) {
                if (b.charAt(i) != a.charAt(i)) {
                    return "";
                }
            }
            String temp = a.substring(b.length());
            return GCD(temp, b);
        } else if (b.length() > a.length()) {
            return GCD(b, a);
        }
        else {
            return a.equals(b) ? a : "";
        }
    }
}
