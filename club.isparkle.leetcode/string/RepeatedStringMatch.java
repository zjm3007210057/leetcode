package string;

/**
 * 686. Repeated String Match
 * <p>
 * Given two strings A and B, find the minimum number of times A has to be repeated
 * such that B is a substring of it. If no such solution, return -1.
 * <p>
 * For example, with A = "abcd" and B = "cdabcdab".
 * <p>
 * Return 3, because by repeating A three times (“abcdabcdabcd”), B is a substring
 * of it; and B is not a substring of A repeated two times ("abcdabcd").
 * <p>
 * Note:
 * The length of A and B will be between 1 and 10000.
 * <p>
 * Created by zjm on 2019/8/19 21:00
 */
public class RepeatedStringMatch {

    //判断A和B的长度，如果A的长度大于B，则判断A中是否包含B，如果不包含，则再追加一个A继续判断，防止出现abc，ca这种情况，如果追加A知乎还不包含B，则返回-1
    public int repeatedStringMatch(String A, String B) {
        StringBuilder sb = new StringBuilder();
        int res = 0;
        while(sb.length() < B.length()) {
            sb.append(A);
            res++;
        }
        if(sb.toString().contains(B)) {
            return res;
        }
        if(sb.append(A).toString().contains(B)) {
            return res + 1;
        }
        return - 1;
    }
}
