// Source : https://leetcode.com/problems/find-first-and-last-position-of-element-in-sorted-array/
// Author : Kris
// Date   : 2020-07-27

/***************************************************************************************************** 
 *
 * Given an array of integers nums sorted in ascending order, find the starting and ending position of 
 * a given target value.
 * 
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * 
 * If the target is not found in the array, return [-1, -1].
 * 
 * Example 1:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 8
 * Output: [3,4]
 * 
 * Example 2:
 * 
 * Input: nums = [5,7,7,8,8,10], target = 6
 * Output: [-1,-1]
 * 
 * Constraints:
 * 
 * 	0 <= nums.length <= 10^5
 * 	-10^9 <= nums[i] <= 10^9
 * 	nums is a non decreasing array.
 * 	-10^9 <= target <= 10^9
 ******************************************************************************************************/

class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        int start = 0;
        int end = nums.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                end = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[start] == target) {
            result[0] = start;
        }
        else if (nums[end] == target) {
            result[0] = end;
        }
        
        
        start = 0;
        end = nums.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            if (nums[mid] == target) {
                start = mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }
        
        if (nums[end] == target) {
            result[1] = end;
        }
        else if (nums[start] == target) {
            result[1] = start;
        }
        
        return result;
    }
}