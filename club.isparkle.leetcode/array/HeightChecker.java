package array;

import java.util.Arrays;

/**
 * 1051. Height Checker
 * <p>
 * Students are asked to stand in non-decreasing order of heights for an annual photo.
 * Return the minimum number of students not standing in the right positions.  (This is the number of students that must move in order for all students to be standing in non-decreasing order of height.)
 * <p>
 * Example 1:
 * Input: [1,1,4,2,1,3]
 * Output: 3
 * Explanation:
 * Students with heights 4, 3 and the last 1 are not standing in the right positions.
 * <p>
 * Note:
 * 1 <= heights.length <= 100
 * 1 <= heights[i] <= 100
 * <p>
 * Created by zjm on 2019/5/27.
 */
public class HeightChecker {

    public int heightChecker(int[] heights) {
        int res = 0;
        int[] arr = Arrays.copyOfRange(heights, 0, heights.length);
        Arrays.sort(arr);
        for (int i = 0; i < heights.length; i++) {
            if (arr[i] != heights[i]) res++;
        }
        return res;
    }

}
