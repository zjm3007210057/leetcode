package array;

/**
 * 238. Product of Array Except Self
 * <p>
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].
 * <p>
 * Example:
 * <p>
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * Note: Please solve it without division and in O(n).
 * <p>
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space for the purpose of space complexity analysis.)
 *
 * @author zjm
 * @date 2019/6/15 下午2:04
 */
public class ProductOfArrayExceptSelf {

    //consider nums[i] equals 0
    public int[] productExceptSelf(int[] nums) {
        int mul = 1;
        int zeroIndex = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 && zeroIndex != -1) {
                return new int[nums.length];
            }else if(nums[i] == 0) {
                zeroIndex = i;
            }else {
                mul *= nums[i];
            }
        }
        if(zeroIndex != -1) {
            int[] res = new int[nums.length];
            res[zeroIndex] = mul;
            return res;
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = mul / nums[i];
        }
        return nums;
    }

    //without extra space
    public int[] productExceptSelf2(int[] nums) {
        int mul = 1;
        int zeroIndex = -1;
        for(int i = 0; i < nums.length; i++) {
            if(nums[i] == 0 && zeroIndex != -1) {
                for(int j = 0; j < nums.length; j++) {
                    nums[j] = 0;
                }
                return nums;
            }else if(nums[i] == 0) {
                zeroIndex = i;
            }else {
                mul *= nums[i];
            }
        }
        if(zeroIndex != -1) {
            for(int i = 0; i < nums.length; i++) {
                if(i != zeroIndex) {
                    nums[i] = 0;
                }else {
                    nums[i] = mul;
                }
            }
            return nums;
        }
        for(int i = 0; i < nums.length; i++) {
            nums[i] = mul / nums[i];
        }
        return nums;
    }
}
