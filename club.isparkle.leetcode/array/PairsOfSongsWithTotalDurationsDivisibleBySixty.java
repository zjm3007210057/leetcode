package array;

/**
 * 1010. Pairs of Songs With Total Durations Divisible by 60
 *
 * In a list of songs, the i-th song has a duration of time[i] seconds.
 * Return the number of pairs of songs for which their total duration in seconds is divisible by 60.
 * Formally, we want the number of indices i < j with (time[i] + time[j]) % 60 == 0.
 *
 * Example 1:
 * Input: [30,20,150,100,40]
 * Output: 3
 * Explanation: Three pairs have a total duration divisible by 60:
 * (time[0] = 30, time[2] = 150): total duration 180
 * (time[1] = 20, time[3] = 100): total duration 120
 * (time[1] = 20, time[4] = 40): total duration 60
 *
 * Example 2:
 * Input: [60,60,60]
 * Output: 3
 * Explanation: All three pairs have a total duration of 120, which is divisible by 60.
 *
 * Note:
 * 1 <= time.length <= 60000
 * 1 <= time[i] <= 500
 *
 * Created by zjm on 2019/5/26.
 */
public class PairsOfSongsWithTotalDurationsDivisibleBySixty {

    //bubble algorithm, time limit exceeded
    public int numPairsDivisibleBy60TimeLimit(int[] time) {
        int res = 0;
        for(int i = 0; i < time.length - 1; i++) {
            for(int j = i + 1; j < time.length; j++) {
                if((time[i] + time[j]) % 60 == 0) res++;
            }
        }
        return res;
    }

    //if (a + b) % 60 == 0, then (a % 60 + b % 60) % 60 == 0.
    //use an array which length is 60 to store the remainder of element divide 60 and the remainder corresponding with the array index.
    //so we only need to do is calculate the multiply value of two elements in array which index sum is 60 or 0.
    public int numPairsDivisibleBy60(int[] time) {
        int res = 0;
        int[] arr = new int[60];
        for(int i = 0; i < time.length; i++) {
            arr[time[i] % 60]++;
        }
        for(int i = 1; i < 30; i++) {
            res += arr[i] * arr[60-i];
        }
        res += arr[0] * (arr[0] - 1) / 2;
        res += arr[30] * (arr[30] - 1) / 2;
        return res;
    }
}
