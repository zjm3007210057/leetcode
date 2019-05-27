package array;

/**
 * 11. Container With Most Water
 *
 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 *
 * Note: You may not slant the container and n is at least 2.
 * The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7]. In this case,
 * the max area of water (blue section) the container can contain is 49.
 *
 * Example:
 * Input: [1,8,6,2,5,4,8,3,7]
 * Output: 49
 *
 * Created by zjm on 2019/5/27.
 */
public class ContainerWithMostWater {

    //use brute force
    public int maxAreaSlow(int[] height) {
        int max = -1;
        for (int i = 0; i < height.length - 1; i++) {
            for (int j = i + 1; j < height.length; j++) {
                max = Math.max(max, Math.min(height[i], height[j]) * (j - i));
            }
        }
        return max;
    }

    //use two pointers move from both of the ends to middle, update max area every time
    public int maxArea(int[] height) {
        int max = -1;
        int l = 0;
        int r = height.length - 1;
        while (l < r) {
            max = Math.max(max, Math.min(height[l], height[r]) * (r - l));
            if (height[l] < height[r]) l++;
            else r--;
        }
        return max;
    }

    public int maxAreaBetter(int[] height) {
        int max = -1;
        int l = 0;
        int r = height.length - 1;
        int min;
        while (l < r) {
            min = Math.min(height[l], height[r]);
            max = Math.max(max, min * (r - l));
            while (l < r && height[l] == min) l++;
            while (l < r && height[r] == min) r--;
        }
        return max;
    }
}
