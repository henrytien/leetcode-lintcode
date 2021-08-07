// Source : https://leetcode.com/problems/burst-balloons/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * Given n balloons, indexed from 0 to n-1. Each balloon is painted with a number on it represented by 
 * array nums. You are asked to burst all the balloons. If the you burst balloon i you will get 
 * nums[left] * nums[i] * nums[right] coins. Here left and right are adjacent indices of i. After the 
 * burst, the left and right then becomes adjacent.
 * 
 * Find the maximum coins you can collect by bursting the balloons wisely.
 * 
 * Note:
 * 
 * 	You may imagine nums[-1] = nums[n] = 1. They are not real therefore you can not burst them.
 * 	0 &le; n &le; 500, 0 &le; nums[i] &le; 100
 * 
 * Example:
 * 
 * Input: [3,1,5,8]
 * Output: 167 
 * Explanation: nums = [3,1,5,8] --> [3,5,8] -->   [3,8]   -->  [8]  --> []
 *              coins =  3*1*5      +  3*5*8    +  1*3*8      + 1*8*1   = 167
 ******************************************************************************************************/

class Solution {
    public int maxCoins(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        cache = new int[nums.length][nums.length];
        for (var i = 0; i < cache.length; i++) {
            for (var j = 0; j < cache.length; j++) {
                cache[i][j] = -1;
            }
        }
        
        return helper(nums, 0, nums.length - 1);
    }
    
    int helper(int[] nums, int start, int end) {
        if (start > end) {
            return 0;
        }

        if (cache[start][end] != -1) {
            return cache[start][end];
        }

        var max = 0;
        for (var i = start; i <= end; i++) {
            var cur = nums[i];
            var left = start == 0 ? 1 : nums[start - 1];
            var right = end == nums.length - 1 ? 1 : nums[end + 1];

            // 在 [start, end] 区间里，扎爆 i 以外的气球，最后留下 i, start - 1 和 end + 1
            // 为什么会产生 [start, end] 这个区间呢？因为 start - 1 (9)，end + 1 (4) 是没有被扎爆的
            // [8,2,6,8,   9,   8(s),1,4,1,   5 (last),   3,0,7,7,0(e),   4,   2,2,5,5]
            max = Math.max(max, left * cur * right
                           + helper(nums, start, i - 1)
                           + helper(nums, i + 1, end));
        }

        cache[start][end] = max;
        return max;
    }

    int[][] cache;
}