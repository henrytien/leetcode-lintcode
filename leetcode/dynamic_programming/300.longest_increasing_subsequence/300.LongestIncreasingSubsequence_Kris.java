// Source : https://leetcode.com/problems/longest-increasing-subsequence/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
 * Example:
 * 
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
 * 
 * Note: 
 * 
 * 	There may be more than one LIS combination, it is only necessary for you to return the 
 * length.
 * 	Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 ******************************************************************************************************/

class Solution {
    // use Arrays.BinarySearch, O(NlogN)
    public int lengthOfLIS(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // var dp = new int[nums.length]; no need to use anymore
        // b: when dp value is i, smallest value in nums (ending value)
        var b = new int[nums.length];
        b[0] = nums[0];
        
        var len = 1; // 存储 b 数组中实际用到的长度
        for (var i = 1; i < nums.length; i++) {
            // 找出数组 b 中，最后一个小于 nums[i] 的数
            // binarySearch toIndex 不包括 len
            // index: 0  1  2   3
            // value: 3  5 10 100

            // Input		Return	ConvertTo
            // 1		==> -1			(0)
            // 10		==>  2			(2)  能够搜索到的场景，其实不用写入，因为值 和 数组里的值 是一样的
            // 50		==> -4			(3)
            // 200		==> -5			(4)
            var j = Arrays.binarySearch(b, 0, len, nums[i]);
            if (j < 0) {
                j = -(j + 1);
                b[j] = nums[i];
                
                len = Math.max(len, j + 1);
            }
        }
        
        return len;
    }
    
    
    // O(NlogN)
    public int lengthOfLIS_NlogN(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // var dp = new int[nums.length]; no need to use anymore
        // b: when dp value is i, smallest value in nums (ending value)
        var b = new int[nums.length + 1];
        b[0] = Integer.MIN_VALUE;
        
        var top = 0;
        for (var i = 0; i < nums.length; i++) {
            // 找出数组 b 中，最后一个小于 nums[i] 的数
            var start = 0;
            var end = top;
            
            while (start < end - 1) {
                var mid = start + (end - start) / 2;
                if (b[mid] < nums[i]) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
            
            // We can always find a value, because b[0] == Integer.MIN_VALUE
            var j = b[end] < nums[i] ? end : start;
            // b[j] is the last value smaller than nums[i]
            // so b[j + 1] should be either no less than nums[i] or equals initial value 0
            // we can safely replace it
            b[j + 1] = nums[i];
            top = Math.max(j + 1, top);
            // dp[i] = j + 1;
        }
        
        // b[top] stores the smallest ending value for an Increasing Subsequence with length top
        return top;
    }
    
    public int lengthOfLIS_NxN(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        var dp = new int[nums.length];
        for (var i = 0; i < nums.length; i++) {
            dp[i] = 1;
        }
        
        var max = dp[0];
        for (var i = 1; i < nums.length; i++) {
            for (var j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                    max = Math.max(max, dp[i]);
                }
            }
        }
        
        return max;
    }
}