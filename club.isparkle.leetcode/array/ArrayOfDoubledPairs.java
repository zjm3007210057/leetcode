package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/**
 * 954. Array of Doubled Pairs
 *
 * Given an array of integers A with even length, return true if and only if it is possible to reorder it such that
 * A[2 * i + 1] = 2 * A[2 * i] for every 0 <= i < len(A) / 2.
 *
 * Example 1:
 * Input: [3,1,3,6]
 * Output: false
 *
 * Example 2:
 * Input: [2,1,2,6]
 * Output: false
 *
 * Example 3:
 * Input: [4,-2,2,-4]
 * Output: true
 * Explanation: We can take two groups, [-2,-4] and [2,4] to form [-2,-4,2,4] or [2,4,-2,-4].
 *
 * Example 4:
 * Input: [1,2,4,16,8,4]
 * Output: false
 *
 * Note:
 * 0 <= A.length <= 30000
 * A.length is even
 * -100000 <= A[i] <= 100000
 *
 * Created by zjm on 2019/7/18 18:31 PM
 */
public class ArrayOfDoubledPairs {

    public boolean canReorderDoubled(int[] A) {
        Arrays.sort(A);
        Map<Integer, LinkedList<Integer>> map = new HashMap();
        for(int i = 0; i < A.length; i++) {
            if(map.get(A[i]) == null) {
               map.put(A[i], new LinkedList());
            }
            map.get(A[i]).add(i);
        }
        for(int i = 0; i < A.length; i++) {
            if(A[i] < 0) {
                if(!map.containsKey(A[i] / 2) || map.get(A[i] / 2).size() < 1) {
                    return false;
                }
                A[map.get(A[i] / 2).getFirst()] = 0;
                map.get(A[i] / 2).removeFirst();
            }
            if(A[i] > 0) {
                if(!map.containsKey(A[i] * 2) || map.get(A[i] * 2).size() < 1) {
                    return false;
                }
                A[map.get(A[i] * 2).getFirst()] = 0;
                map.get(A[i] * 2).removeFirst();
            }
        }
        return true;
    }

}
