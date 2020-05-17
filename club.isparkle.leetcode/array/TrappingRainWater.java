package array;

/**
 * 42. Trapping Rain Water
 *
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * Example:
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 *
 * Created by zjm on 2019/6/3.
 */
public class TrappingRainWater {

    public int trap(int[] arr) {
        if(arr.length < 3) {
            return 0;
        }
        int res = 0;
        int l = 0, r = arr.length - 1;
        int lMax = 0, rMax = 0;
        while(l < r) {
            lMax = Math.max(lMax, arr[l]);
            rMax = Math.max(rMax, arr[r]);
            if(lMax < rMax) {
                res += lMax - arr[l];
                l++;
            }else {
                res += rMax - arr[r];
                r--;
            }
        }
        return res;
    }

}
