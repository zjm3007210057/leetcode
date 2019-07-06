package array;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;

/**
 * 870. Advantage Shuffle
 * <p>
 * Given two arrays A and B of equal size, the advantage of A with respect to B is the number of indices i for which A[i] > B[i].
 * <p>
 * Return any permutation of A that maximizes its advantage with respect to B.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [2,7,11,15], B = [1,10,4,11]
 * Output: [2,11,7,15]
 * Example 2:
 * <p>
 * Input: A = [12,24,8,32], B = [13,25,32,11]
 * Output: [24,32,8,12]
 * <p>
 * <p>
 * Note:
 * <p>
 * 1 <= A.length = B.length <= 10000
 * 0 <= A[i] <= 10^9
 * 0 <= B[i] <= 10^9
 * <p>
 * Created by zjm on 2019/7/5 21:30
 */
public class AdvantageShuffle {

    public int[] advantageCount(int[] A, int[] B) {
        int[] res = new int[A.length];
        TreeMap<Integer, LinkedList<Integer>> map = new TreeMap();
        for(int i = 0; i < A.length; i++) {
            LinkedList<Integer> list = map.getOrDefault(A[i], new LinkedList());
            list.add(i);
            map.putIfAbsent(A[i], list);
        }
        for(int i = 0; i < B.length; i++) {
            Integer ceil = map.ceilingKey(B[i] + 1);
            if(null == ceil) {
                ceil = map.firstKey();
            }
            res[i] = ceil;
            LinkedList<Integer> list = map.get(ceil);
            list.removeLast();
            if(list.size() < 1) {
                map.remove(ceil);
            }
        }
        return res;
    }

}
