package array;

/**
 * 915. Partition Array into Disjoint Intervals
 * <p>
 * Given an array A, partition it into two (contiguous) subarrays left and right so that:
 * <p>
 * Every element in left is less than or equal to every element in right.
 * left and right are non-empty.
 * left has the smallest possible size.
 * Return the length of left after such a partitioning.  It is guaranteed that such a partitioning exists.
 * <p>
 * Example 1:
 * <p>
 * Input: [5,0,3,8,6]
 * Output: 3
 * Explanation: left = [5,0,3], right = [8,6]
 * Example 2:
 * <p>
 * Input: [1,1,1,0,6,12]
 * Output: 4
 * Explanation: left = [1,1,1,0], right = [6,12]
 * <p>
 * Note:
 * 2 <= A.length <= 30000
 * 0 <= A[i] <= 10^6
 * It is guaranteed there is at least one way to partition A as described
 *
 * Created by zjm on 2019/7/11 21:26
 */
public class PartitionArrayIntoDisjointIntervals {

    /**
     * since len(left) > 0, so max(left) >= A[0]. scan A from left, set leftMax as the maximum value of the left array, set
     * res as the value of the right border, set curMax as the maximum value of the current. To the next element A[i]: if
     * A[i] < leftMax, A[i] must in left array, so we need update res = i and leftMax = curMax(because left is contiguous, so
     * the maximum value of current must in left array). if leftMax <= A[i] <= curMax, just jump, if A[i] > curMax, update
     * curMax = A[i]. the result is res + 1.
     */
    public int partitionDisjoint(int[] A) {
        int res = 0;
        int leftMax = A[0], curMax = A[0];
        for(int i = 1; i < A.length; i++) {
            if(A[i] > curMax) {
                curMax = A[i];
            }else if(A[i] < leftMax) {
                res = i;
                leftMax = curMax;
            }
        }
        return res + 1;
    }

    //use two extra arrays max and min. max[i] = max(A[0],...,A[i]), min[i] = min(A[i],...,A[A.length-1]).
    //then find max[i] <= min[i+1] and i+1 is the result.
    public int partitionDisjoint2(int[] A) {
        int max[] = new int[A.length], min[] = new int[A.length];
        for(int i = 0; i < A.length; i++) {
            if(i == 0 || A[i] > max[i-1]) {
                max[i] = A[i];
            }else {
                max[i] = max[i-1];
            }
        }
        for(int i = A.length - 1; i >= 0; i--) {
            if(i == A.length - 1 || A[i] < min[i+1]) {
                min[i] = A[i];
            }else {
                min[i] = min[i+1];
            }
        }
        for(int i = 0; i < A.length; i++) {
            if(max[i] <= min[i+1]) {
                return i + 1;
            }
        }
        return -1;
    }
}
