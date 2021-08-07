// Source : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Author : Kris
// Date   : 2020-07-27

/***************************************************************************************************** 
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Example 1:
 * 
 * Input: [3,4,5,1,2] 
 * Output: 1
 * 
 * Example 2:
 * 
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 * 
 ******************************************************************************************************/

class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int target = nums[nums.length - 1];
        int start = 0;
        int end = nums.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] <= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (nums[start] < target) {
            return nums[start];
        }
        
        if (nums[end] < target) {
            return nums[end];
        }
            
        return target;
    }
}