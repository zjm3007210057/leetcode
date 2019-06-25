package array;

import java.util.Arrays;

/**
 * 621. Task Scheduler
 *
 * Given a char array representing tasks CPU need to do. It contains capital letters A to Z where different letters represent different tasks.
 * Tasks could be done without original order. Each task could be done in one interval. For each interval, CPU could finish one task or just be idle.
 *
 * However, there is a non-negative cooling interval n that means between two same tasks, there must be at least n
 * intervals that CPU are doing different tasks or just be idle.
 * You need to return the least number of intervals the CPU will take to finish all the given tasks.
 *
 * Example:
 * Input: tasks = ["A","A","A","B","B","B"], n = 2
 * Output: 8
 * Explanation: A -> B -> idle -> A -> B -> idle -> A -> B.
 *
 * Note:
 * The number of tasks is in the range [1, 10000].
 * The integer n is in the range [0, 100].
 *
 * Created by zjm on 2019/6/25 11:04 AM
 */
public class TaskScheduler {

    //use an array chars to storage the occur numbers of char in the tasks,
    //find the largest number in chars, eg. H is the char occurs most, then
    //the leastInterval sequence must is H....H....H, every H interval is n,
    //if there is another char X which occurs number equals to H, the sequence
    //will become HX...HX...HX, every HX interval also is n, so we only need to
    //find the largest numbers from chars
    public int leastInterval(char[] tasks, int n) {
        int count = 0;
        int[] chars = new int[26];
        for(char c : tasks) {
            chars[c - 'A']++;
        }
        Arrays.sort(chars);
        for(int i = 25; i > 0; i--) {
            //find if there are more than two chars occur the same time
            if(chars[i] == chars[i-1]) {
                count++;
            }else {
                break;
            }
        }
        //do not forget compare with the length of tasks
        return Math.max(chars[25] * (n + 1) - (n - count), tasks.length);
    }
}