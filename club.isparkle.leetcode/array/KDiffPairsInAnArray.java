package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 532. K-diff Pairs in an Array
 *
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
 * Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and their absolute difference is k.
 *
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 *
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 *
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 *
 * Note:
 * The pairs (i, j) and (j, i) count as the same pair.
 * The length of the array won't exceed 10,000.
 * All the integers in the given input belong to the range: [-1e7, 1e7].
 *
 * Created by zjm on 2019/5/17.
 */
public class KDiffPairsInAnArray {

    //use hashMap, if the element in nums has repeat, set hashMap value true, or else false
    //if k = 0, just calculate the number of hashMap which value is true
    //if k != 0, just increase the res value when key + k is also in hashMap.
    public int findPairs(int[] nums, int k) {
        if(null == nums || nums.length < 2 || k < 0) {
            return 0;
        }
        Map<Integer, Boolean> map = new HashMap();
        for(int num : nums) {
            if(map.get(num) == null) {
                map.put(num, false);
            }else {
                map.put(num, true);
            }
        }
        int res = 0;
        if(k == 0) {
            for(boolean f : map.values()) {
                if(f) {
                   res++;
                }
            }
        }else {
            for(Map.Entry<Integer, Boolean> entry : map.entrySet()) {
                if(map.containsKey(entry.getKey() + k)) {
                    res++;
                }
            }
        }
        return res;
    }
}
