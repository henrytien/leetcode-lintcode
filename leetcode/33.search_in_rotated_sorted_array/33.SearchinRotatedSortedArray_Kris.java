// Source : https://leetcode.com/problems/search-in-rotated-sorted-array/
// Author : Kris
// Date   : 2020-07-27

/***************************************************************************************************** 
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 * 
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * Example 1:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 * 
 * Example 2:
 * 
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 ******************************************************************************************************/

public class Solution {
    public int Search(int[] nums, int target) {
        if (nums == null || nums.Length == 0) {
            return -1;
        }
        
        int start = 0;
        int end = nums.Length - 1;
        
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            
            if (nums[start] < nums[mid]) {
                if (nums[mid] == target) {
                    end = mid; // 怎么写都行，start = mid，也可以和下面的情况合并
                } else if (nums[start] <= target && target < nums[mid]) {
                    // 保证在单调递增区间
                    end = mid;
                } else {
                    start = mid;
                }
            } else if (nums[start] > nums[mid]) {
                if (nums[mid] == target) {
                    start = mid; // 怎么写都行，end = mid，也可以和下面的情况合并
                } else if (nums[mid] < target && target <= nums[end]) {
                    // 保证在单调递增区间
                    start = mid;
                } else {
                    end = mid;
                }
            } else {
                throw new Exception("end - start >= 2, so start will never equals mid");
            } 
        }
        
        if (nums[start] == target) {
            return start;
        }
        
        if (nums[end] == target) {
            return end;
        }
        
        return -1;
    }
}