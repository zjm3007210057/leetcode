package editor.cn;
//给定一个数组 nums 和滑动窗口的大小 k，请找出所有滑动窗口里的最大值。
//
// 示例:
//
// 输入: nums = [1,3,-1,-3,5,3,6,7], 和 k = 3
//输出: [3,3,5,5,6,7]
//解释:
//
//  滑动窗口的位置                最大值
//---------------               -----
//[1  3  -1] -3  5  3  6  7       3
// 1 [3  -1  -3] 5  3  6  7       3
// 1  3 [-1  -3  5] 3  6  7       5
// 1  3  -1 [-3  5  3] 6  7       5
// 1  3  -1  -3 [5  3  6] 7       6
// 1  3  -1  -3  5 [3  6  7]      7
//
//
//
// 提示：
//
// 你可以假设 k 总是有效的，在输入数组不为空的情况下，1 ≤ k ≤ 输入数组的大小。
//
// 注意：本题与主站 239 题相同：https://leetcode-cn.com/problems/sliding-window-maximum/
// Related Topics 队列 Sliding Window
// 👍 164 👎 0


import java.util.LinkedList;

//leetcode submit region begin(Prohibit modification and deletion)
class Solution1 {

    //提交成功
    public int[] maxSlidingWindow(int[] nums, int k) {
        if(null == nums || nums.length < 1 || nums.length < k) {
            return new int[]{};
        }
        int[] res = new int[nums.length - k + 1];
        int index = 0;
        LinkedList<Integer> maxQ = new LinkedList();//用来存储数组nums的下标
        for(int l = 0; l < nums.length; l++) {
            //此时的值和队列最后的值做比较，如果大于，则弹出队列最后的值再循环此过程，直到此时的数小于队列末尾的数，或者队列为空，然后将此时的数加入到队列
            while(null != maxQ.peekLast() && nums[l] >= nums[maxQ.peekLast()]) {
                maxQ.pollLast();
            }
            maxQ.addLast(l);
            if(l - maxQ.peekFirst() >= k) {
                maxQ.pollFirst();
            }
            if(l + 1 >= k) {
                res[index++] = nums[maxQ.peekFirst()];
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)
