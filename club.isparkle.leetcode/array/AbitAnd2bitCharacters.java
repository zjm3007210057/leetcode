package array;

import java.util.Arrays;

/**
 * 717. 1-bit and 2-bit Characters
 * <p>
 * We have two special characters. The first character can be represented by one bit 0. The second character can be represented by two bits (10 or 11).
 * Now given a string represented by several bits. Return whether the last character must be a one-bit character or not. The given string will always end with a zero.
 * <p>
 * Example 1:
 * Input:
 * bits = [1, 0, 0]
 * Output: True
 * Explanation:
 * The only way to decode it is two-bit character and one-bit character. So the last character is one-bit character.
 * <p>
 * Example 2:
 * Input:
 * bits = [1, 1, 1, 0]
 * Output: False
 * Explanation:
 * The only way to decode it is two-bit character and two-bit character. So the last character is NOT one-bit character.
 * <p>
 * Note:
 * 1 <= len(bits) <= 1000.
 * bits[i] is always 0 or 1.
 * <p>
 * Created by zjm on 2019/5/21.
 */
public class AbitAnd2bitCharacters {

    //if the pre n-1 elements can be decode, return true, else return false
    public boolean isOneBitCharacter(int[] bits) {
        int index = 0;
        while (index < bits.length - 1) {
            //if bits[index] is 0, index plus one.
            //if bits[index] is 1, that means the next element must join with it to decode two-bit character, so plus 2
            index += bits[index] + 1;
        }
        return index == bits.length - 1;
    }

    //use recursive and use extra array everytime
    public boolean isOneBitCharacterRecursive(int[] bits) {
        if (bits.length == 0) return false;
        if (bits.length == 1) return true;
        return isOneBitCharacterRecursive(Arrays.copyOfRange(bits, bits[0] + 1, bits.length));
    }

    //use recursive and no extra space
    public boolean isOneBitCharacterRecursiveBetter(int[] bits) {
        return help(bits, 0);
    }

    public boolean help(int[] bits, int index) {
        if (index == bits.length - 1) return true;
        if (index == bits.length) return false;
        return help(bits, index + bits[index] + 1);
    }
}
