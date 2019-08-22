package string;

import java.util.HashSet;
import java.util.Set;

/**
 * 824. Goat Latin
 * <p>
 * A sentence S is given, composed of words separated by spaces. Each word consists of lowercase and uppercase letters only.
 * <p>
 * We would like to convert the sentence to "Goat Latin" (a made-up language similar to Pig Latin.)
 * <p>
 * The rules of Goat Latin are as follows:
 * <p>
 * If a word begins with a vowel (a, e, i, o, or u), append "ma" to the end of the word.
 * For example, the word 'apple' becomes 'applema'.
 * <p>
 * If a word begins with a consonant (i.e. not a vowel), remove the first letter and append it to the end, then add "ma".
 * For example, the word "goat" becomes "oatgma".
 * <p>
 * Add one letter 'a' to the end of each word per its word index in the sentence, starting with 1.
 * For example, the first word gets "a" added to the end, the second word gets "aa" added to the end and so on.
 * Return the final sentence representing the conversion from S to Goat Latin.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "I speak Goat Latin"
 * Output: "Imaa peaksmaaa oatGmaaaa atinLmaaaaa"
 * Example 2:
 * <p>
 * Input: "The quick brown fox jumped over the lazy dog"
 * Output: "heTmaa uickqmaaa rownbmaaaa oxfmaaaaa umpedjmaaaaaa overmaaaaaaa hetmaaaaaaaa azylmaaaaaaaaa ogdmaaaaaaaaaa"
 * <p>
 * <p>
 * Notes:
 * <p>
 * S contains only uppercase, lowercase and spaces. Exactly one space between each word.
 * 1 <= S.length <= 150
 * <p>
 * Created by zjm on 2019/8/22 22:44
 */
public class GoatLatin {

    //使用char数组，总共256个字符
    public String toGoatLatin(String S) {
        StringBuilder sb = new StringBuilder();
        String[] words = S.split(" ");
        char[] map = new char[256];
        map['A'] = map['E'] = map['I'] = map['O'] = map['U'] =  1;
        map['a'] = map['e'] = map['i'] = map['o'] = map['u'] =  1;
        StringBuilder as = new StringBuilder("a");
        for (int i = 0; i < words.length; ++i) {
            if (map[words[i].charAt(0)] == 1) {
                sb.append(words[i]).append("ma");
            } else {
                sb.append(words[i].substring(1)).append(words[i].charAt(0)).append("ma");
            }
            sb.append(as);
            as.append("a");
            if (i != words.length - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

}
