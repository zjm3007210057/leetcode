package array;

/**
 * the 35th problem in leetcode
 * Created by zjm on 28/04/2018.
 */
public class SearchInsertPosition {

    /**
     * Given a sorted array and a target value, return the index if the target is found.
     * If not, return the index where it would be if it were inserted in order.
     * e.g.1:
     * Input: [1, 3, 5, 6], 5
     * Output: 2
     * e.g.2:
     * Input: [1, 3, 5, 6], 2
     * Output: 1
     */
    public int searchInsert(int[] nums, int target){
        //Null judge
        if(nums == null){
            return -1;
        }
        if(nums.length < 1 || nums[0] > target){
            return 0;
        }
        if(nums[nums.length - 1] < target){
            return nums.length;
        }
        int length = nums.length;
        int left = 0;
        int right = length - 1;
        int index;
        while (left < right){
            //use binary search
            index = left + (right - left) / 2;
            if(nums[index] < target){
                left = index + 1;
            }else if(nums[index] > target){
                right = index - 1;
            }else {
                //if existed multiple target value, return the first position of the target
                while(nums[--index] == target){
                }
                return index+1;
            }
        }
        if(nums[left] < target){
            return left + 1;
        }
        return left;
    }

}
