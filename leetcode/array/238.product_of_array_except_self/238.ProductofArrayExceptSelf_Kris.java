// Source : https://leetcode.com/problems/product-of-array-except-self/
// Author : Kris
// Date   : 2020-10-08

/***************************************************************************************************** 
 *
 * Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal 
 * to the product of all the elements of nums except nums[i].
 * 
 * Example:
 * 
 * Input:  [1,2,3,4]
 * Output: [24,12,8,6]
 * 
 * Constraint: It's guaranteed that the product of the elements of any prefix or suffix of the array 
 * (including the whole array) fits in a 32 bit integer.
 * 
 * Note: Please solve it without division and in O(n).
 * 
 * Follow up:
 * Could you solve it with constant space complexity? (The output array does not count as extra space 
 * for the purpose of space complexity analysis.)
 ******************************************************************************************************/

class Solution {
    // Space O(1)
    public int[] productExceptSelf(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        var n = nums.length;
        var result = new int[n];
        result[0] = 1;
        
        // calculate left array first, and store it in result
        for (var i = 1; i < n; i++) {
            result[i] = result[i - 1] * nums[i - 1];
        }
        
        var right = 1;
        for (var i = n - 1; i >= 0; i--) {
            result[i] = result[i] * right;
            right = right * nums[i];
        }
        
        return result;
    }
    
    // Space O(N)
    public int[] productExceptSelf_oN(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        
        var n = nums.length;
        var result = new int[n];
        var left = new int[n];
        var right = new int[n];
        
        left[0] = 1;
        for (var i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i - 1];
        }
        
        right[n - 1] = 1;
        for (var i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i + 1];
        }
        
        for (var i = 0; i < n; i++) {
            result[i] = left[i] * right[i];
        }
        
        return result;
    }
}