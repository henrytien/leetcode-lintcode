// Source : https://leetcode.com/problems/find-peak-element/
// Author : Kris
// Date   : 2020-07-27

/***************************************************************************************************** 
 *
 * A peak element is an element that is greater than its neighbors.
 * 
 * Given an input array nums, where nums[i] &ne; nums[i+1], find a peak element and return its index.
 * 
 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
 * 
 * You may imagine that nums[-1] = nums[n] = -&infin;.
 * 
 * Example 1:
 * 
 * Input: nums = [1,2,3,1]
 * Output: 2
 * Explanation: 3 is a peak element and your function should return the index number 2.
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,1,3,5,6,4]
 * Output: 1 or 5 
 * Explanation: Your function can return either index number 1 where the peak element is 2, 
 *              or index number 5 where the peak element is 6.
 * 
 * Follow up: Your solution should be in logarithmic complexity.
 ******************************************************************************************************/

class Solution {
    public int findPeakElement(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        if (nums.length == 1) {
            return 0;
        }
        
        // 处理2个元素的场景
        if (nums[0] > nums[1]) {
            return 0;
        }
        if (nums[nums.length - 2] < nums[nums.length - 1]) {
            return nums.length - 1;
        }
        
        // 3个元素或以上，才能继续进行
        int start = 1;
        int end = nums.length - 2;
        
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (nums[mid - 1] < nums[mid] && nums[mid] > nums[mid + 1]) {
                start = mid; // 极大值，随便取哪边，也可以直接返回mid
            } else if (nums[mid - 1] > nums[mid] && nums[mid] < nums[mid + 1]) {
                start = mid; // 极小值，随便取哪边
            } else if (nums[mid - 1] < nums[mid] && nums[mid] < nums[mid + 1]) {
                start = mid; // 单调增，取右边
            } else {
                end = mid; // 单调减，取左边
            }
        }
        
        if (nums[start - 1] < nums[start] && nums[start] > nums[start + 1]) {
            return start;
        }
        
        if (nums[end - 1] < nums[end] && nums[end] > nums[end + 1]) {
            return end;
        }
        
        return -1;
    }
}