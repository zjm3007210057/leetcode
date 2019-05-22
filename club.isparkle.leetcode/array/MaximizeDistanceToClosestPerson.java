package array;

/**
 * 849. Maximize Distance to Closest Person
 *
 * In a row of seats, 1 represents a person sitting in that seat, and 0 represents that the seat is empty.
 * There is at least one empty seat, and at least one person sitting.
 * Alex wants to sit in the seat such that the distance between him and the closest person to him is maximized.
 * Return that maximum distance to closest person.
 *
 * Example 1:
 * Input: [1,0,0,0,1,0,1]
 * Output: 2
 * Explanation:
 * If Alex sits in the second open seat (seats[2]), then the closest person has distance 2.
 * If Alex sits in any other open seat, the closest person has distance 1.
 * Thus, the maximum distance to the closest person is 2.
 *
 * Example 2:
 * Input: [1,0,0,0]
 * Output: 3
 * Explanation:
 * If Alex sits in the last seat, the closest person is 3 seats away.
 * This is the maximum distance possible, so the answer is 3.
 *
 * Note:
 * 1 <= seats.length <= 20000
 * seats contains only 0s or 1s, at least one 0, and at least one 1.
 *
 * Created by zjm on 2019/5/22.
 */
public class MaximizeDistanceToClosestPerson {

    //we can get result by record the maximum number of continuously 0 in seats. pay attention to the both ends of the seats,
    //the end number of continuously 0 can equivalent to the twice number of continuously 0 in middle.
    //judge seats[0] is 0 or not, use variable first to record the nums of continuously 0.
    public int maxDistToClosest(int[] seats) {
        int res = 1;
        int tmp = 1;
        int first = 0;
        for(int i = 0; i < seats.length; i++) {
            if(i == 0 && seats[i] == 0) {
                first++;
                while(seats[++i] == 0) first++;
                --i;
            }else if(seats[i] == 0) {
                while(i < seats.length - 1 && seats[++i] == 0) {
                    tmp++;
                    if(i == seats.length - 1) {
                        tmp *= 2;
                    }
                }
                res = Math.max(res, tmp);
                if(i == seats.length - 1) break;
                --i;
            }else {
                tmp = 1;
            }
        }
        if(first > 0) {
            res = Math.max(res, 2 * first);
        }
        return (res + 1) / 2;
    }
}
