// Source : https://leetcode.com/problems/single-number/
// Author : Kris
// Date   : 2020-08-15

/***************************************************************************************************** 
 *
 * Given a non-empty array of integers, every element appears twice except for one. Find that single 
 * one.
 * 
 * Note:
 * 
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra 
 * memory?
 * 
 * Example 1:
 * 
 * Input: [2,2,1]
 * Output: 1
 * 
 * Example 2:
 * 
 * Input: [4,1,2,1,2]
 * Output: 4
 * 
 ******************************************************************************************************/

class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null || nums.length % 2 == 0) {
            return -1;
        }
        
        var result = 0;
        for (var i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        
        return result;
    }
}