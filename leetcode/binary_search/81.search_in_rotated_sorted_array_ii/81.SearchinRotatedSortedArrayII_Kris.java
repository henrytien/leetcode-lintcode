// Source : https://leetcode.com/problems/search-in-rotated-sorted-array-ii/
// Author : Kris
// Date   : 2020-07-27

/***************************************************************************************************** 
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., [0,0,1,2,2,5,6] might become [2,5,6,0,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return true, otherwise return false.
 * 
 * Example 1:
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 0
 * Output: true
 * 
 * Example 2:
 * 
 * Input: nums = [2,5,6,0,0,1,2], target = 3
 * Output: false
 * 
 * Follow up:
 * 
 * 	This is a follow up problem to Search in Rotated Sorted Array, where nums may contain 
 * duplicates.
 * 	Would this affect the run-time complexity? How and why?
 * 
 ******************************************************************************************************/

// Time complexity O(n), even binary search can't reduce it. E.g., [1,1,1,1,1,2]
class Solution {
    public boolean search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        for (var num : nums) {
            if (num == target) {
                return true;
            }
        }
        
        return false;
    }

    public boolean search_2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return false;
        }
        
        int start = 0;
        int end = nums.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            
            if (nums[start] < nums[mid]) { // 不减区间
                if (nums[start] <= target && target <= nums[mid]) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[start] == nums[mid]) { 
                // 不能忽略的edge case，[1,3,1,1,1], [1,1,1,3,1], 3
                // 无论哪种情况，start++ 都不会把结果过滤掉。
                // 但是因为这里用了遍历，最坏时间复杂度就变成了O(n)。
                // 所以这道题其实直接 for 循环就能搞定
                start++;
            } else {
                if (nums[mid] <= target && target <= nums[end]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }
        
        System.out.println("start: " + start + ", end: " + end);
        return nums[start] == target || nums[end] == target;
    }
}