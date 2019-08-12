package string;

/**
 * 520. Detect Capital
 * <p>
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * <p>
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * <p>
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: "USA"
 * Output: True
 * <p>
 * <p>
 * Example 2:
 * <p>
 * Input: "FlaG"
 * Output: False
 * <p>
 * <p>
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 * <p>
 * Created by zjm on 2019/8/12 22:33
 */
public class DetectCapital {

    //根据题意直接判断，注意特殊情况：fF，FFFf
    public boolean detectCapitalUse(String word) {
        if(word.length() < 2) {
            return true;
        }
        //判断第一个字母是大写还是小写
        boolean first;
        if(word.charAt(0) - 'a' >= 0) {
            first = false;
        }else {
            first = true;
        }
        boolean low = false;
        boolean upper = false;
        for(int i = 1; i < word.length(); i++) {
            //如果第一个字母大写，则后面的字母要么都是大写，要么都是小写
            //如果第一个字母是小写，则后面的字母都必须是小写
            if(first) {
                if(word.charAt(i) - 'a' >= 0) {
                    low = true;
                }else {
                    upper = true;
                }
            }else {
                if(word.charAt(i) - 'a' < 0) {
                    return false;
                }
            }
            if(low && upper) {
                return false;
            }
        }
        return true;
    }
}
