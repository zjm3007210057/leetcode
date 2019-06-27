package array;

/**
 * 670. Maximum Swap
 * <p>
 * Given a non-negative integer, you could swap two digits at most once to get the maximum valued number. Return the maximum valued number you could get.
 * <p>
 * Example 1:
 * Input: 2736
 * Output: 7236
 * Explanation: Swap the number 2 and the number 7.
 * Example 2:
 * Input: 9973
 * Output: 9973
 * Explanation: No swap.
 * Note:
 * The given number is in the range [0, 10^8]
 *
 * Created by zjm on 2019/6/26 20:17
 */
public class MaximumSwap {

    //1.compare the highest bit of the num with the remain bits
    //2.if there is a bit is bigger than the highest bit, then, find the largest bit from remain bits and
    //swap the highest bit with the largest bit and return the result.
    //else, repeat the step 1.
    public int maximumSwap(int num) {
        String s = String.valueOf(num);
        char[] chars = s.toCharArray();
        for(int i = 0; i < chars.length - 1; i++) {
            for(int j = i + 1; j < chars.length; j++) {
                if(chars[i] - chars[j] < 0) {
                    int index = j;
                    int max = chars[j];
                    for(int k = j + 1; k < chars.length; k++) {
                        //find the largest bit
                        if(chars[k] >= max) {
                            max = chars[k];
                            index = k;
                        }
                    }
                    char tmp = chars[i];
                    chars[i] = chars[index];
                    chars[index] = tmp;
                    return Integer.valueOf(new String(chars));
                }
            }
        }
        return num;
    }

}
