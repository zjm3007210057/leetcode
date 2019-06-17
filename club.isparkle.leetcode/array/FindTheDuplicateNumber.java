package array;

/**
 * 287. Find the Duplicate Number
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one.
 *
 * Example 1:
 *
 * Input: [1,3,4,2,2]
 * Output: 2
 * Example 2:
 *
 * Input: [3,1,3,4,2]
 * Output: 3
 * Note:
 *
 * You must not modify the array (assume the array is read only).
 * You must use only constant, O(1) extra space.
 * Your runtime complexity should be less than O(n2).
 * There is only one duplicate number in the array, but it could be repeated more than once.
 *
 * @author zjm
 * @date 2019/6/15 下午2:33
 */
public class FindTheDuplicateNumber {

    //narrow the range of the duplicate number with binary search(O(nlgn))
    public int findDuplicate(int[] nums) {
        int l = 0, r = nums.length;
        int m;
        while(l < r) {
            m = (r - l) / 2 + l;
            int count = 0;
            for(int n : nums) {
                if(n <= m) {
                    count++;
                }
            }
            if(count <= m) {
                l = m + 1;
            }else {
                r = m;
            }
        }
        return r;
    }

    public int findDuplicateBetter(int[] nums) {
        int slow = 0, fast = 0;
        while(true) {
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast) break;
        }
        fast = 0;
        while(true) {
            slow = nums[slow];
            fast = nums[fast];
            if(slow == fast) break;
        }
        return slow;
    }

}
