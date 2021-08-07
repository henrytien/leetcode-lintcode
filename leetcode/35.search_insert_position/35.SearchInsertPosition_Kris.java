// Source : https://leetcode.com/problems/search-insert-position/
// Author : Kris
// Date   : 2020-07-28

/***************************************************************************************************** 
 *
 * Given a sorted array and a target value, return the index if the target is found. If not, return 
 * the index where it would be if it were inserted in order.
 * 
 * You may assume no duplicates in the array.
 * 
 * Example 1:
 * 
 * Input: [1,3,5,6], 5
 * Output: 2
 * 
 * Example 2:
 * 
 * Input: [1,3,5,6], 2
 * Output: 1
 * 
 * Example 3:
 * 
 * Input: [1,3,5,6], 7
 * Output: 4
 * 
 * Example 4:
 * 
 * Input: [1,3,5,6], 0
 * Output: 0
 * 
 ******************************************************************************************************/

class Solution {
    public int searchInsert(int[] nums, int target) {
        if (nums == null) {
            return -1;
        }
        
        if (nums.length == 0) {
            return 0;
        }
        
        if (nums.length == 1) {
            return nums[0] < target ? 1 : 0;
        }
        
        int start = 0;
        int end = nums.length - 1;
        
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
        
        if (target <= nums[start]) {
            return start;
        }
        if (target <= nums[end]) {
            return end;
        }
        if (nums[end] < target) {
            return end + 1;
        }
        
        return -1;
    }
}