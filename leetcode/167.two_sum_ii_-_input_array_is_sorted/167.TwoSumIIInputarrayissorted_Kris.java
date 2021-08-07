// Source : https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
// Author : Kris
// Date   : 2020-07-27

/***************************************************************************************************** 
 *
 * Given an array of integers that is already sorted in ascending order, find two numbers such that 
 * they add up to a specific target number.
 * 
 * The function twoSum should return indices of the two numbers such that they add up to the target, 
 * where index1 must be less than index2.
 * 
 * Note:
 * 
 * 	Your returned answers (both index1 and index2) are not zero-based.
 * 	You may assume that each input would have exactly one solution and you may not use the same 
 * element twice.
 * 
 * Example:
 * 
 * Input: numbers = [2,7,11,15], target = 9
 * Output: [1,2]
 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
 ******************************************************************************************************/

class Solution {
    public int[] twoSum(int[] nums, int target) {
        var result = new int[2];
        if (nums == null || nums.length < 2) {
            return result;
        }
        
        var index1 = 0;
        var index2 = nums.length - 1;
        while (index1 < index2) {
            if (nums[index1] + nums[index2] < target) {
                index1++;
            } else if (nums[index1] + nums[index2] == target) {
                result[0] = index1 + 1;
                result[1] = index2 + 1;
                break;
            } else {
                index2--;
            }
        }
        
        return result;
    }
}