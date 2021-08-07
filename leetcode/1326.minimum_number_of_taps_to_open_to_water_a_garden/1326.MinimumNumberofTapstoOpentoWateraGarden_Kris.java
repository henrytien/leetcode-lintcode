// Source : https://leetcode.com/problems/minimum-number-of-taps-to-open-to-water-a-garden/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * There is a one-dimensional garden on the x-axis. The garden starts at the point 0 and ends at the 
 * point n. (i.e The length of the garden is n).
 * 
 * There are n + 1 taps located at points [0, 1, ..., n] in the garden.
 * 
 * Given an integer n and an integer array ranges of length n + 1 where ranges[i] (0-indexed) means 
 * the i-th tap can water the area [i - ranges[i], i + ranges[i]] if it was open.
 * 
 * Return the minimum number of taps that should be open to water the whole garden, If the garden 
 * cannot be watered return -1.
 * 
 * Example 1:
 * 
 * Input: n = 5, ranges = [3,4,1,1,0,0]
 * Output: 1
 * Explanation: The tap at point 0 can cover the interval [-3,3]
 * The tap at point 1 can cover the interval [-3,5]
 * The tap at point 2 can cover the interval [1,3]
 * The tap at point 3 can cover the interval [2,4]
 * The tap at point 4 can cover the interval [4,4]
 * The tap at point 5 can cover the interval [5,5]
 * Opening Only the second tap will water the whole garden [0,5]
 * 
 * Example 2:
 * 
 * Input: n = 3, ranges = [0,0,0,0]
 * Output: -1
 * Explanation: Even if you activate all the four taps you cannot water the whole garden.
 * 
 * Example 3:
 * 
 * Input: n = 7, ranges = [1,2,1,0,2,1,0,1]
 * Output: 3
 * 
 * Example 4:
 * 
 * Input: n = 8, ranges = [4,0,0,0,0,0,0,0,4]
 * Output: 2
 * 
 * Example 5:
 * 
 * Input: n = 8, ranges = [4,0,0,0,4,0,0,0,4]
 * Output: 1
 * 
 * Constraints:
 * 
 * 	1 <= n <= 10^4
 * 	ranges.length == n + 1
 * 	0 <= ranges[i] <= 100
 ******************************************************************************************************/

class Solution {
    // greedy O(n)
    public int minTaps(int n, int[] ranges) {
        if (n + 1 != ranges.length) {
            return -1;
        }

        // convert to Jump Game II, https://leetcode.com/problems/jump-game-ii/
        // Jump Game: the element in the array is the maximum step to jump with
        // Here: the element in the range array is already the maximum index after jump
        for (var i = 0; i < ranges.length; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = i + ranges[i];
            if (left < i) {
                ranges[left] = Math.max(right, ranges[left]);
            }
        }
 
        var curMax = 0;
        var nextMax = 0;
        var jump = 0;
        // 最后一个位置不用跳
        for (var i = 0; i < ranges.length - 1; i++) {
            nextMax = Math.max(nextMax, ranges[i]);
            
            if (i == curMax) {
                if (i == nextMax) {
                    break;
                }
                
                curMax = nextMax;
                jump++;
            }
        }

        return curMax >= n ? jump : -1;
    }
    
    // dp O(n^2)
    public int minTaps_dp(int n, int[] ranges) {
        if (n + 1 != ranges.length) {
            return -1;
        }

        for (var i = 0; i < ranges.length; i++) {
            int left = Math.max(0, i - ranges[i]);
            int right = i + ranges[i];
            if (left < i) {
                ranges[left] = Math.max(right, ranges[left]);
            }
        }
 
        var dp = new int[ranges.length];
        Arrays.fill(dp, -1);
        dp[0] = 0;

        for (var i = 1; i < ranges.length; i++) {
            for (var j = 0; j < i; j++) {
                if (dp[j] >= 0 && ranges[j] >= i) {
                    dp[i] = dp[i] == -1 ? dp[j] + 1 : Math.min(dp[i], dp[j] + 1);
                }
            }
        }

        return dp[ranges.length - 1];
    }
}