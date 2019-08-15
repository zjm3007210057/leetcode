package string;

/**
 * 557. Reverse Words in a String III
 * <p>
 * Given a string, you need to reverse the order of characters in each word within
 * a sentence while still preserving whitespace and initial word order.
 * <p>
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single
 * space and there will not be any extra space in the string.
 * <p>
 * Created by zjm on 2019/8/15 19:43
 */
public class ReverseWordsInAStringIII {

    //使用两个指针，第一个指针l指向每一段的第一个字符，r指向每一段的最后一个字符，每当s中的字符为空格时直接添加，然后依次从末尾添加每一段的字符
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int l, r;
        for(int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == ' ') {
                sb.append(' ');
            }else {
                l = i;
                while(i < s.length() && s.charAt(i) != ' ') {
                    i++;
                }
                r = --i;
                while(l <= r) {
                    sb.append(s.charAt(r));
                    r--;
                }
            }
        }
        return sb.toString();
    }
}
