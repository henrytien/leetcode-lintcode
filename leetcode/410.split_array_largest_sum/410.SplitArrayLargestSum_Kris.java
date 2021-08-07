// Source : https://leetcode.com/problems/split-array-largest-sum/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * Given an array nums which consists of non-negative integers and an integer m, you can split the 
 * array into m non-empty continuous subarrays.
 * 
 * Write an algorithm to minimize the largest sum among these m subarrays.
 * 
 * Example 1:
 * 
 * Input: nums = [7,2,5,10,8], m = 2
 * Output: 18
 * Explanation:
 * There are four ways to split nums into two subarrays.
 * The best way is to split it into [7,2,5] and [10,8],
 * where the largest sum among the two subarrays is only 18.
 * 
 * Example 2:
 * 
 * Input: nums = [1,2,3,4,5], m = 2
 * Output: 9
 * 
 * Example 3:
 * 
 * Input: nums = [1,4,4], m = 3
 * Output: 4
 * 
 * Constraints:
 * 
 * 	1 <= nums.length <= 1000
 * 	0 <= nums[i] <= 106
 * 	1 <= m <= min(50, nums.length)
 ******************************************************************************************************/

class Solution {
    // dp O(n^3)
    public int splitArray_dp(int[] nums, int m) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        var n = nums.length;
        m = Math.min(m, n);
        var dp = new int[m + 1][n + 1];
        for (var i = 0; i < dp.length; i++) {
            for (var j = 0; j <= n; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }
        for (var i = 0; i < dp.length; i++) {
            dp[i][0] = 0;
        }
        
        // j 个元素，分成 i 个 subarrays
        // f[i][j] = MIN{ MAX{f[i-1][k], nums[k] + ... + nums[j-1]} | k: 0 ~ j-1 }
        for (var i = 1; i <= m; i++) {
            for (var j = 1; j <= n; j++) {
                var sum = 0;
                for (var k = j - 1; k >= 0; k--) {
                    sum += nums[k]; // k + 1 - 1 = k
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[i - 1][k], sum));
                }
            }
        }
        
        return dp[m][n];
    }
    
    // binarySearch O(NlogN)
    public int splitArray(int[] nums, int m) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // 答案一定在最大值和sum之间
        long start = 0;
        long end = 0;
        for (int num : nums) {
            end += num;
            start = Math.max(start, num);
        }
        
        while (start < end - 1) {
            long mid = start + (end - start) / 2;
            int count = getCount(nums, mid);
            
            if (count < m) {
                end = mid;
            } else if (count > m) {
                start = mid;
            } else {
                end = mid; // 这里不能用 start = mid，因为必须往小了测试
            }
        }
        
        // System.out.println(start + ", " + end);
        
        // 特殊情况，[2,1,1,1,10], 3 -- 此时 start = 10, count == 2 < 3
        if (getCount(nums, start) <= m) {
            return (int) start;
        }
        
        return (int) end;
    }
    
    // 以mid为sub sum来划分，计算出会分出多少个子数组
    int getCount(int[] nums, long mid) {
        int count = 1;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > mid) {
                count++;
                sum = nums[i];
            }
        }
        return count;
    }
}