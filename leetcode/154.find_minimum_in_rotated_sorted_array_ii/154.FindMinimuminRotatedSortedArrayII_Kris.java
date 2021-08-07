// Source : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array-ii/
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
 * The array may contain duplicates.
 * 
 * Example 1:
 * 
 * Input: [1,3,5]
 * Output: 1
 * 
 * Example 2:
 * 
 * Input: [2,2,2,0,1]
 * Output: 0
 * 
 * Note:
 * 
 * 	This is a follow up problem to Find Minimum in Rotated Sorted Array.
 * 	Would allow duplicates affect the run-time complexity? How and why?
 * 
 ******************************************************************************************************/

class Solution {
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        var min = nums[0];
        for (int num : nums) {
            if (min > num) {
                min = num;
            }
        }
        
        return min;
    }

    public int findMin_2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        
        int target = nums[nums.length - 1];
        int start = 0;
        int end = nums.length - 1;
        while (start < end - 1) {
            int mid = start + (end - start) / 2;
            
            if (nums[mid] < target) {
                end = mid;
            } else if (nums[mid] == target) {
                if (nums[start] < target) {
                    end--;
                } else {
                    start++;
                }
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