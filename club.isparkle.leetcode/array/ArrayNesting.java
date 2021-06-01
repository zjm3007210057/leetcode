package array;

import java.util.HashMap;
import java.util.Map;

/**
 * 565. Array Nesting
 * <p>
 * A zero-indexed array A of length N contains all integers from 0 to N-1.
 * Find and return the longest length of set S, where S[i] = {A[i], A[A[i]],
 * A[A[A[i]]], ... } subjected to the rule below.
 * <p>
 * Suppose the first element in S starts with the selection of element A[i]
 * of index = i, the next element in S should be A[A[i]], and then A[A[A[i]]]…
 * By that analogy, we stop adding right before a duplicate element occurs in S.
 * <p>
 * <p>
 * <p>
 * Example 1:
 * <p>
 * Input: A = [5,4,0,3,1,6,2]
 * Output: 4
 * Explanation:
 * A[0] = 5, A[1] = 4, A[2] = 0, A[3] = 3, A[4] = 1, A[5] = 6, A[6] = 2.
 * <p>
 * One of the longest S[K]:
 * S[0] = {A[0], A[5], A[6], A[2]} = {5, 6, 2, 0}
 * <p>
 * <p>
 * Note:
 * <p>
 * N is an integer within the range [1, 20,000].
 * The elements of A are all distinct.
 * Each element of A is an integer within the range [0, N-1].
 * <p>
 * Created by zjm on 2019/6/22 22:38
 */
public class ArrayNesting {

    public int arrayNesting(int[] nums) {
        int max = 0, count, index, tmp;
        Map<Integer, Integer> map = new HashMap();
        for(int i = 0; i < nums.length; i++) {
            count = 0;
            index = i;
            while(nums[index] != -1 && index != -1) {
                tmp = index;
                count++;
                map.put(index, count);
                index = nums[index];
                nums[tmp] = -1;
            }
            if(map.containsKey(index)) {
                max = Math.max(max, count - map.get(index) + 1);
            }
            map.clear();
        }
        return max;
    }

    public int arrayNestingBetter(int[] nums) {
        int max = 0, count, index, tmp;
        for(int i = 0; i < nums.length; i++) {
            count = 0;
            index = i;
            while(nums[index] != -1) {
                tmp = index;
                count++;
                index = nums[index];
                nums[tmp] = -1;
            }
            max = Math.max(max, count);
        }
        return max;
    }

}
