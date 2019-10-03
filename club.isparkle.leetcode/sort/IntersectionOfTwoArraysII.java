package sort;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 350. Intersection of Two Arrays II
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2,2]
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [4,9]
 * Note:
 *
 * Each element in the result should appear as many times as it shows in both arrays.
 * The result can be in any order.
 * Follow up:
 *
 * What if the given array is already sorted? How would you optimize your algorithm?
 * What if nums1's size is small compared to nums2's size? Which algorithm is better?
 * What if elements of nums2 are stored on disk, and the memory is limited such that you cannot load all elements into the memory at once?
 *
 * @date 2019/10/3 上午10:40
 */
public class IntersectionOfTwoArraysII {

    //使用map来保存第一个数组中的数字以及出现的次数，然后遍历第二个数组，判断是否在map中出现，
    //如果出现，则将数字添加到list当中，并判断map中该数字出现的次数是否大于1，大于的话则次数减一，
    //否则从map中删除对应的键值
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Integer> map = new HashMap();
        List<Integer> list = new ArrayList();
        for(int n : nums1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        for(int n : nums2) {
            if(map.containsKey(n)) {
                list.add(n);
                if(map.get(n) <= 1) {
                    map.remove(n);
                }else {
                    map.put(n, map.get(n) - 1);
                }
            }
        }
        int[] res = new int[list.size()];
        for(int i = 0; i < list.size(); i++) {
            res[i] = list.get(i);
        }
        return res;
    }
}
