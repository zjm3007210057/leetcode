package array;

import java.util.Arrays;

/**
 * 825. Friends Of Appropriate Ages
 * <p>
 * Some people will make friend requests. The list of their ages is given and ages[i] is the age of the ith person.
 * <p>
 * Person A will NOT friend request person B (B != A) if any of the following conditions are true:
 * <p>
 * age[B] <= 0.5 * age[A] + 7
 * age[B] > age[A]
 * age[B] > 100 && age[A] < 100
 * Otherwise, A will friend request B.
 * <p>
 * Note that if A requests B, B does not necessarily request A.  Also, people will not friend request themselves.
 * <p>
 * How many total friend requests are made?
 * <p>
 * Example 1:
 * <p>
 * Input: [16,16]
 * Output: 2
 * Explanation: 2 people friend request each other.
 * Example 2:
 * <p>
 * Input: [16,17,18]
 * Output: 2
 * Explanation: Friend requests are made 17 -> 16, 18 -> 17.
 * Example 3:
 * <p>
 * Input: [20,30,100,110,120]
 * Output:
 * Explanation: Friend requests are made 110 -> 100, 120 -> 110, 120 -> 100.
 * <p>
 * <p>
 * Notes:
 * <p>
 * 1 <= ages.length <= 20000.
 * 1 <= ages[i] <= 120.
 * <p>
 * Created by zjm on 2019/7/4 19:07
 */
public class FriendsOfAppropriateAges {

    //brute force
    public int numFriendRequests(int[] ages) {
        Arrays.sort(ages);
        int res = 0;
        for(int i = ages.length - 1; i >= 0; i--) {
            for(int j = i-1; j >= 0; j--) {
                if(ages[j] <= ages[i] / 2 + 7) continue;
                if(ages[j] == ages[i]) res++;//A=B, A can send request to B and also B can send request to A
                res++;
            }
        }
        return res;
    }

    //since age is less than 120, so we can use an array to storage each age occur numbers,
    //age[B] <= 0.5 * age[A] + 7 means B must in (A*0.5+7, A], so A > 14.
    //so we only need find how many person's age in (A*0.5+7, A].
    //we use an array to storage the sum of each age occur numbers.
    //then sum[i] - sum[i*0.5+7] is the number which can make friend requests.
    public int numFriendRequestsBetter(int[] ages) {
        int[] arr = new int[121];
        int[] sum = new int[121];
        int res = 0;
        for(int n : ages) {
            arr[n]++;
        }
        for(int i = 15; i < 121; i++) {
            sum[i] = sum[i-1] + arr[i];
        }
        for(int i = 15; i < 121; i++) {
            if(arr[i] == 0) continue;
            int tmp = sum[i] - sum[i/2 + 7];
            res += (tmp - 1) * arr[i];//people friend request each other
        }
        return res;
    }
}
