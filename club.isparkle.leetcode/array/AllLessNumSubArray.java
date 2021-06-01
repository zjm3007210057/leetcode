package array;

import java.util.Scanner;

/**
 * 给定一个数组和一个数，求这个数组内，共有多少个子数组(下标连续)，使得子数组内的最大值和最小值之差小于给定的数
 *
 * eg.
 * 输入：arr=[2, 3, 1, 5, 9, 2, 10]  n=6
 * 结果中的子数组有：
 * [2],[2,3],[2,3,1],[2,3,1,5],[3],[3,1],[3,1,5],[1],[1,5],[5],[2]
 *
 * Created by zjm on 2020/12/26 12:50
 */
public class AllLessNumSubArray {

    //暴力解法O(n^3)
    public int getNumForce(int[] arr, int num) {
        int res = 0;
        // 挑选出所有的子数组 l..l, l..l+1,  l..l+k,  l..arr.length-1
        for(int l = 0; l < arr.length; l++) {
            for(int r = l; r < arr.length; r++) {
                //挑选出所有的子数组后，从中间选出最大值和最小值出来
                int max = arr[l];
                int min = arr[l];
                for(int i = l; i <= r; i++) {
                    max = Math.max(max, arr[i]);
                    min = Math.min(min, arr[i]);
                }
                //比较是否满足条件
                if(max - min < num) {
                    res++;
                }
            }
        }
        return res;
    }

    // 最优解O(n)，解释
    // 1：给定一个子数组，如果子数组中最大值和最小值之差满足条件，则子数组中的任意子子数组也满足条件（子子数组中的最大值比子数组中的最大值肯定要小或者等于，
    // 子子数组中的最小值比子数组中的最小值肯定要大或者等于，那么两者之差肯定更小）
    // 2：如果子数组中的最大值和最小值不满足条件，则往两边扩展子数组同样不满足，因为扩展后的子数组最大值肯定要更大或者等于，而最小值肯定更小或者等于，两者
    // 差值肯定也更大或者等于
    public int getNum(int[] arr, int n) {
        int res = 0;

        return res;
    }

    public static void main(String[] args) {
        /*String s = "XSUWHQ";
        String[] arr = s.split(" ");
        System.out.println(arr[arr.length - 1].length());
        Scanner ss = new Scanner(System.in);
        char c = 'A';
        char a = 'a';
        System.out.println(c + 32 == a);*/

        Scanner sc = new Scanner(System.in);
        String line = null;
        while(sc.hasNextLine()) {
            line = sc.nextLine();
            int len = line.length();
            if(len % 8 != 0) {
                StringBuilder sb = new StringBuilder();
                for(int i = 0; i < (8 - len % 8); i++) {
                    sb.append("0");
                }
                line = line + sb.toString();
            }
            for(int i = 0; i < line.length() / 8; i++) {
                System.out.println(line.substring(i * 8, (i + 1) * 8));
            }
        }
    }
}
