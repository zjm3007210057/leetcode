package array;

import java.util.Arrays;

/**
 * 611. Valid Triangle Number
 * <p>
 * Given an array consists of non-negative integers, your task is to count the number of triplets
 * chosen from the array that can make triangles if we take them as side lengths of a triangle.
 * Example 1:
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 * Note:
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 * <p>
 * Created by zjm on 2019/6/23 09:11
 */
public class ValidTriangleNumber {

    public static int triangleNumber(int[] nums) {
        int n = nums.length;
        int res = 0;
        if(n == 0) return 0;
        Arrays.sort(nums);
        for(int i = n-1; i >= 0; i--){
            int tmp = 0;
            int index = i-1;
            while(tmp < index){
                if(nums[tmp] + nums[index] > nums[i]) {
                    res += index-tmp;
                    index--;
                }else tmp++;
            }
        }
        return res;
    }

}
