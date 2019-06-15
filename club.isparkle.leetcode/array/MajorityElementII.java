package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 229. Majority Element II
 * Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
 * <p>
 * Note: The algorithm should run in linear time and in O(1) space.
 * <p>
 * Example 1:
 * <p>
 * Input: [3,2,3]
 * Output: [3]
 * Example 2:
 * <p>
 * Input: [1,1,1,3,3,2,2,2]
 * Output: [1,2]
 *
 * Created by zjm on 2019/6/15 10:22
 */
public class MajorityElementII {

    //use Boyer-Moore Majority Vote Algorithm solve this problem
    public List<Integer> majorityElement(int[] nums) {
        List<Integer> res = new ArrayList();
        if(nums.length < 1) {
            return res;
        }else if(nums.length == 1) {
            res.add(nums[0]);
            return res;
        }
        int n1 = 0, n2 = 0, c1 = 0, c2 = 0;
        for(int n : nums) {
            if(n1 == n) c1++;
            else if(n2 == n) c2++;
            else if(c1 < 1) {
                c1 = 1;
                n1 = n;
            }else if(c2 < 1) {
                c2 = 1;
                n2 = n;
            }else {
                c1--;
                c2--;
            }
        }
        c1 = c2 = 0;
        for(int n : nums) {
            if(n1 == n) c1++;
            else if(n2 == n) c2++;
        }
        if(c1 > nums.length / 3) res.add(n1);
        if(c2 > nums.length / 3) res.add(n2);
        return res;
    }
}
