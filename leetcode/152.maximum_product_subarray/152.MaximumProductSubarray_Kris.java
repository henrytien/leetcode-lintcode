// Source : https://leetcode.com/problems/maximum-product-subarray/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * Given an integer array nums, find the contiguous subarray within an array (containing at least one 
 * number) which has the largest product.
 * 
 * Example 1:
 * 
 * Input: [2,3,-2,4]
 * Output: 6
 * Explanation: [2,3] has the largest product 6.
 * 
 * Example 2:
 * 
 * Input: [-2,0,-1]
 * Output: 0
 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
 ******************************************************************************************************/

class Solution {
    public int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // dp = new int[nums.length][2], [2] 用来记录包含当前值的最大 正、负 数
        // 当然有时候，到 i 时不可能有 正/负 数乘积，那我们只能记录当前值 nums[i] 了
        // E.g., [2,3], dp[0][1] 就是 2，dp[1][1] 也只能是 3，没有负数乘积
        var dp = new int[2][2];
        dp[0][0] = nums[0];
        dp[0][1] = nums[0];
        
        var max = nums[0];
        for (var i = 1; i < nums.length; i++) {
            if (nums[i] > 0) {
                dp[i % 2][0] = dp[(i - 1) % 2][0] > 0 ? dp[(i - 1) % 2][0] * nums[i] : nums[i];
                dp[i % 2][1] = dp[(i - 1) % 2][1] < 0 ? dp[(i - 1) % 2][1] * nums[i] : nums[i];
            } else if (nums[i] == 0) {
                dp[i % 2][0] = 0;
                dp[i % 2][1] = 0;
            } else {
                dp[i % 2][0] = dp[(i - 1) % 2][1] < 0 ? dp[(i - 1) % 2][1] * nums[i] : nums[i];
                dp[i % 2][1] = dp[(i - 1) % 2][0] > 0 ? dp[(i - 1) % 2][0] * nums[i] : nums[i];
            }
            max = Math.max(max, dp[i % 2][0]); // dp[i][0] >= dp[i][1]
        }
        
        return max;
    }
}