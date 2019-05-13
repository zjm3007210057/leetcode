package array;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 *
 * Note:
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 *
 * Example:
 * Input:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * Output: [1,2,2,3,5,6]
 *
 * Created by zjm on 2019/5/13.
 */
public class MergeSortedArray {

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int[] res = new int[m + n];
        int left1 = 0;
        int left2 = 0;
        while(left1 < m && left2 < n) {
            if(nums1[left1] < nums2[left2]) {
                res[left1 + left2] = nums1[left1];
                left1++;
            }else{
                res[left1 + left2] = nums2[left2];
                left2++;
            }
        }
        while(left1 < m) {
            res[left1 + left2] = nums1[left1];
            left1++;
        }
        while(left2 < n) {
            res[left1 + left2] = nums2[left2];
            left2++;
        }
        for(int i = 0; i < m + n; i++) {
            nums1[i] = res[i];
        }
    }

    public void mergeBetter(int[] nums1, int m, int[] nums2, int n) {
        int right1 = m - 1;
        int right2 = n - 1;
        while(right1 >= 0 && right2 >= 0) {
            if(nums1[right1] < nums2[right2]) {
                nums1[right1 + right2 + 1] = nums2[right2--];
            }else {
                nums1[right1 + right2 + 1] = nums1[right1--];
            }
        }
        //nums2 is still have elements
        while(right1 == -1 && right2 >= 0) {
            nums1[right2] = nums2[right2--];
        }
    }
}
