package string;

/**
 * 38. Count and Say
 * <p>
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * <p>
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * <p>
 * Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
 * <p>
 * Note: Each term of the sequence of integers will be represented as a string.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: 1
 * Output: "1"
 * Example 2:
 * <p>
 * Input: 4
 * Output: "1211"
 * <p>
 * Created by zjm on 2019/8/1 20:46
 */
public class CountAndSay {

    //根据题意直接计算
    public String countAndSay(int n) {
        if(n == 1) {
            return "1";
        }
        StringBuilder sb = new StringBuilder("1");
        StringBuilder res = null;
        for(int i = 2; i <= n; i++) {
            res = new StringBuilder();
            for(int j = 0; j < sb.length(); j++) {
                int count = 1;
                while(j < sb.length() - 1 && sb.charAt(j) == sb.charAt(j+1)) {
                    count++;
                    j++;
                }
                res.append(count + "").append(sb.charAt(j));
            }
            sb = new StringBuilder(res);
        }
        return res.toString();
    }

}
