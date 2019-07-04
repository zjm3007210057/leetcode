package array;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 835. Image Overlap
 * <p>
 * Two images A and B are given, represented as binary, square matrices of the same size.  (A binary matrix has only 0s and 1s as values.)
 * <p>
 * We translate one image however we choose (sliding it left, right, up, or down any number of units),
 * and place it on top of the other image.  After, the overlap of this translation is the number of positions that have a 1 in both images.
 * <p>
 * (Note also that a translation does not include any kind of rotation.)
 * <p>
 * What is the largest possible overlap?
 * <p>
 * Example 1:
 * <p>
 * Input: A = [[1,1,0],
 * [0,1,0],
 * [0,1,0]]
 * B = [[0,0,0],
 * [0,1,1],
 * [0,0,1]]
 * Output: 3
 * Explanation: We slide A to right by 1 unit and down by 1 unit.
 * Notes:
 * <p>
 * 1 <= A.length = A[0].length = B.length = B[0].length <= 30
 * 0 <= A[i][j], B[i][j] <= 1
 * <p>
 * Created by zjm on 2019/7/4 19:56
 */
public class ImageOverlap {

    public int largestOverlap(int[][] A, int[][] B) {
        List<Pair<Integer, Integer>> alist = new ArrayList();
        List<Pair<Integer, Integer>> blist = new ArrayList();
        for(int i = 0; i < A.length; i++) {
            for(int j = 0; j < A[0].length; j++) {
                if(A[i][j] == 1) {
                    alist.add(new Pair(i, j));
                }
                if(B[i][j] == 1) {
                    blist.add(new Pair(i, j));
                }
            }
        }
        Map<Pair<Integer, Integer>, Integer> map = new HashMap();
        for(Pair<Integer, Integer> aPair : alist) {
            for(Pair<Integer, Integer> bPair : blist) {
                Pair<Integer, Integer> diff = new Pair(aPair.getKey() - bPair.getKey(), aPair.getValue() - bPair.getValue());
                map.put(diff, map.getOrDefault(diff, 0) + 1);
            }
        }
        int res = 0;
        for(int n : map.values()) {
            res = Math.max(res, n);
        }
        return res;
    }

}
