package array;

/**
 * the 66th problem in leetcode
 * Created by zjm on 28/04/2018.
 */
public class PlusOne {

    /**
     * Given a non-empty array of digits representing a non-negative integer, plus one to the integer.
     * The digits are stored such that the most significant digit is at the head of the list,
     * and each element in the array contain a single digit.
     * You may assume the integer does not contain any leading zero, except the number 0 itself.
     * e.g.1:
     *  Input: [1,2,3]
     *  Output: [1,2,4]
     * e.g.2:
     *  Input: [4,3,2,1]
     *  Output: [4,3,2,2]
     */
    public int[] plusOne(int[] digits) {
        if(digits == null || digits.length < 1){
            return new int[]{};
        }
        int index = digits.length - 1;
        //plus one at the last index of the digits
        digits[index]++;
        while(index > 0){
            //compare with nine
            if(digits[index] > 9){
                digits[index] = 0;
                digits[index - 1]++;
            }else {
                return digits;
            }
            index--;
        }
        //judge index is 0
        if(index == 0){
            if (digits[0] > 9) {
                int[] arr = new int[digits.length + 1];
                arr[0] = 1;
                digits = arr;
            }
        }
        return digits;
    }

    public int[] plusOneMoreGood(int[] digits) {
        for(int i = digits.length - 1; i >= 0; i--) {
            if(digits[i] < 9) {
                digits[i] += 1;
                return digits;
            }
            if(i > 0) {
                digits[i] = 0;
            }else {
                int[] arr = new int[digits.length + 1];
                arr[0] = 1;
                return arr;
            }
        }
        return null;
    }
}
