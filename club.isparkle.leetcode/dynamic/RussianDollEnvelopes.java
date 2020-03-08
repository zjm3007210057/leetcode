package dynamic;

import java.util.*;

/**
 * 354. Russian Doll Envelopes
 * <p>
 * You have a number of envelopes with widths and heights given as a pair of integers (w, h). One envelope can fit into another if and only if both the width and height of one envelope is greater than the width and height of the other envelope.
 * What is the maximum number of envelopes can you Russian doll? (put one inside other)
 * <p>
 * Note:
 * Rotation is not allowed.
 * <p>
 * Example:
 * Input: [[5,4],[6,4],[6,7],[2,3]]
 * Output: 3
 * Explanation: The maximum number of envelopes you can Russian doll is 3 ([2,3] => [5,4] => [6,7]).
 *
 * Created by zjm on 2020/3/7 17:17
 */
public class RussianDollEnvelopes {

    public int maxEnvelopes(int[][] envelopes) {
        if(envelopes.length <= 1) {
            return envelopes.length;
        }
        List<Envelop> list = new ArrayList(envelopes.length);
        for(int i = 0; i < envelopes.length; i++) {
            Envelop envelop = new Envelop(envelopes[i][0], envelopes[i][1]);
            list.add(envelop);
        }
        Collections.sort(list, new Comparator<Envelop>() {
            public int compare(Envelop o1, Envelop o2) {
                if(o1.width != o2.width) {
                    return o1.width - o2.width;
                }
                return o1.height - o2.height;
            }
        });
        int[] dp = new int[envelopes.length];
        Arrays.fill(dp, 1);
        int max = 1;
        for(int i = 1; i < dp.length; i++) {
            for(int j = 0; j < i; j++) {
                if(list.get(j).width < list.get(i).width && list.get(j).height < list.get(i).height) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
                max = Math.max(max, dp[i]);
            }
        }
        return max;
    }

    private class Envelop {
        private int width;

        private int height;

        public Envelop(int width, int height) {
            this.width = width;
            this.height = height;
        }
    }

    //有错误
    public int maxEnvelopes1(int[][] envelopes) {
        Arrays.sort(envelopes, new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                if(a[0] != b[0]) {
                    return a[0] - b[0];
                }
                return a[1] - b[1];
            }
        });
        int[] dp = new int[envelopes.length];
        int res = 1;
        for(int[] e : envelopes) {
            int l = 0;
            int r = envelopes.length - 1;
            int m;
            //不正确
            while(l <= r) {
                m = (r - l) / 2 + l;
                if(dp[m] < e[1]) {
                    l = m + 1;
                }else {
                    r = m - 1;
                }
            }
            dp[l] = e[1];
            if (l == res) res++;
        }
        return res;
    }
}
