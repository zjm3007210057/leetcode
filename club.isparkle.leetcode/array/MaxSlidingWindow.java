package array;

import java.util.LinkedList;

/**
 * 239. 滑动窗口最大值
 *
 * 给你一个整数数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 * 返回滑动窗口中的最大值。
 *
 * 示例 1：
 *
 * 输入：nums = [1,3,-1,-3,5,3,6,7], k = 3
 * 输出：[3,3,5,5,6,7]
 * 解释：
 * 滑动窗口的位置                最大值
 * ---------------               -----
 * [1  3  -1] -3  5  3  6  7       3
 *  1 [3  -1  -3] 5  3  6  7       3
 *  1  3 [-1  -3  5] 3  6  7       5
 *  1  3  -1 [-3  5  3] 6  7       5
 *  1  3  -1  -3 [5  3  6] 7       6
 *  1  3  -1  -3  5 [3  6  7]      7
 * 示例 2：
 *
 * 输入：nums = [1], k = 1
 * 输出：[1]
 * 示例 3：
 *
 * 输入：nums = [1,-1], k = 1
 * 输出：[1,-1]
 * 示例 4：
 *
 * 输入：nums = [9,11], k = 2
 * 输出：[11]
 * 示例 5：
 *
 * 输入：nums = [4,-2], k = 2
 * 输出：[4]
 *
 * 提示：
 *
 * 1 <= nums.length <= 10^5
 * -10^4<= nums[i] <= 10^4
 * 1 <= k <= nums.length
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/sliding-window-maximum
 *
 * Created by zjm on 2020/12/25 21:51
 */
public class MaxSlidingWindow {

    //使用双端队列方法，队列记下每次进入的下标
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(nums == null || nums.length < k || k < 1) {
            return null;
        }
        //放置的是数组nums的下标，数据从尾部进去，里面下标对应的数据从大到小排列，如果新加进去的数大于队列前位置中的数，则弹出
        LinkedList<Integer> maxQ = new LinkedList();
        //记录结果
        int[] res = new int[nums.length - k + 1];
        int index = 0;//记录结果数组的下标
        for(int i = 0; i < nums.length; i++) {//当前让i -> [i]进窗口
            //i->值可以放在比他大的数后面，或者队列已经空了，直接放
            while(!maxQ.isEmpty() && nums[maxQ.peekLast()] <= nums[i]) {
                maxQ.pollLast();
            }
            maxQ.addLast(i);//将下标存入窗口
            //这时数进来了，如果窗口没有k的长度，窗口不弹出数字
            //i-k是过期下标，如果头部下标等于过期下标则弹出，如果不等于，则啥都不做
            if(maxQ.peekFirst() == i - k) {
                maxQ.pollFirst();
            }
            //以上将窗口更新全部做完

            //窗口没有达到k之前不收集答案，窗口等于的时候才收集答案，答案是窗口头部的值（窗口最大值）
            if(i >= k - 1) {
                res[index++] = nums[maxQ.peekFirst()];
            }
        }
        return res;
    }
}
