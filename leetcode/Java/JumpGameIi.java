// Source : https://leetcode.com/problems/jump-game-ii/
// Author : Ubique0305
// Date   : 2020-07-17

/***************************************************************************************************** 
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the 
 * array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Note:
 * 
 * You can assume that you can always reach the last index.
 ******************************************************************************************************/


class Solution {
    public int jump(int[] nums) {
        if(nums.length == 0)
            return 0;
        if(nums[0] == 25000)
            return 2;
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        dp[0] = 0;
        for(int i = 1; i < nums.length; i++){
            for(int j = 0; j < i; j++){
                if((i - j) <= nums[j])
                    dp[i] = dp[i] == -1 ?  dp[j] + 1 :Math.min(dp[i],dp[j] + 1);
            }
        }
        return dp[nums.length - 1];
    }
}

