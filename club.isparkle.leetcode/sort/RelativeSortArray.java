package sort;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1122. Relative Sort Array
 * <p>
 * Given two arrays arr1 and arr2, the elements of arr2 are distinct, and all elements in arr2 are also in arr1.
 * Sort the elements of arr1 such that the relative ordering of items in arr1 are the same as in arr2.
 * Elements that don't appear in arr2 should be placed at the end of arr1 in ascending order.
 * <p>
 * Example 1:
 * Input: arr1 = [2,3,1,3,2,4,6,7,9,2,19], arr2 = [2,1,4,3,9,6]
 * Output: [2,2,2,1,4,3,3,9,6,7,19]
 * <p>
 * Constraints:
 * arr1.length, arr2.length <= 1000
 * 0 <= arr1[i], arr2[i] <= 1000
 * Each arr2[i] is distinct.
 * Each arr2[i] is in arr1
 * <p>
 * Created by zjm on 2019/10/8 19:40
 */
public class RelativeSortArray {

    /**
     * 使用map来保存arr1中的元素，key为元素值，value为元素出现的次数。然后遍历arr2，从map里获取对应的value，
     * 重新给arr1从开始下标赋值，最后排序剩下的元素
     */
    public static int[] relativeSortArray(int[] arr1, int[] arr2) {
        Map<Integer, Integer> map = new HashMap();
        for(int n : arr1) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        int index = 0;
        for(int n : arr2) {
            int num = map.remove(n);
            for(int i = 0; i < num; i++) {
                arr1[index++] = n;
            }
        }
        int sort = index;
        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            for(int i = 0; i < entry.getValue(); i++) {
                arr1[index++] = entry.getKey();
            }
        }
        Arrays.sort(arr1, sort, index);
        return arr1;
    }

}
