package sort;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 349. Intersection of Two Arrays
 * <p>
 * Given two arrays, write a function to compute their intersection.
 * <p>
 * Example 1:
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Example 2:
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 *
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 * <p>
 * Created by zjm on 2019/9/26 22:33
 */
public class IntersectionOfTwoArrays {

    //使用两个set，一个用来存放数组元素，一个用来判断另外的数组元素是否在第一个set中，如果在的话则加入到第二个set
    //第二个使用set的原因是因为数组中的元素会重复
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set = new HashSet();
        Set<Integer> s = new HashSet();
        for(int n : nums1) {
            set.add(n);
        }
        for(int n : nums2) {
            if(set.contains(n)) {
                s.add(n);
            }
        }
        int[] res = new int[s.size()];
        int index = 0;
        for(int n : s) {
            res[index++] = n;
        }
        return res;
    }

}
