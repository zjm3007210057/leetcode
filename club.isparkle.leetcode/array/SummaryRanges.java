package array;

import java.util.ArrayList;
import java.util.List;

/**
 * 228. Summary Ranges
 * <p>
 * Given a sorted integer array without duplicates, return the summary of its ranges.
 * <p>
 * Example 1:
 * <p>
 * Input:  [0,1,2,4,5,7]
 * Output: ["0->2","4->5","7"]
 * Explanation: 0,1,2 form a continuous range; 4,5 form a continuous range.
 * Example 2:
 * <p>
 * Input:  [0,2,3,4,6,8,9]
 * Output: ["0","2->4","6","8->9"]
 * Explanation: 2,3,4 form a continuous range; 8,9 form a continuous range
 * Created by zjm on 2019/6/14 23:11
 */
public class SummaryRanges {

    //define a pointer and scan nums from 0 to nums.length-1, find the continuous elements and add them to list
    public List<String> summaryRanges(int[] nums) {
        List<String> res = new ArrayList();
        if(nums.length == 1) {
            res.add(String.valueOf(nums[0]));
            return res;
        }
        int index = 0;
        int tmp;
        while(index < nums.length) {
            tmp = index;
            StringBuilder sb = new StringBuilder(String.valueOf(nums[tmp]));
            while(tmp < nums.length - 1 && nums[tmp] == nums[tmp+1] - 1) {
                tmp++;
            }
            if(tmp > index) {
                sb.append("->" + nums[tmp]);
                index = tmp;
            }
            res.add(sb.toString());
            index++;
        }
        return res;
    }
}
