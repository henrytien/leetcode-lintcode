// Source : https://leetcode.com/problems/continuous-subarray-sum/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * Given a list of non-negative numbers and a target integer k, write a function to check if the array 
 * has a continuous subarray of size at least 2 that sums up to a multiple of k, that is, sums up to 
 * n*k where n is also an integer.
 * 
 * Example 1:
 * 
 * Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to 6.
 * 
 * Example 2:
 * 
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and sums up to 42.
 * 
 * Constraints:
 * 
 * 	The length of the array won't exceed 10,000.
 * 	You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 ******************************************************************************************************/

class Solution {
    // O(N)
    // 1. Running sum from first element to index i : sum_i. If we mod k, it will be some format like : sum_i = k * x + modk_1
    // 2. Running sum from first element to index j : sum_j. If we mod k, it will be some format like : sum_j = k * y + modk_2
    // If they have the same mod, which is modk_1 == modk_2, then diff should be a multiple of k (include 0)
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        
        var map = new HashMap<Integer, Integer>();
        map.put(0, -1);
        
        var sum = 0;
        for (var i = 0; i < nums.length; i++) {
            sum += nums[i];
            
            var left = 0;
            var index = i;
            if (k == 0) {
                left = sum;
                index = map.getOrDefault(left, index);
            } else {
                left = sum % k;
                index = map.getOrDefault(left, index);
            }

            if (i - index >= 2) {
                return true;
            }
            
            if (!map.containsKey(left)) {
                map.put(left, i);
            }
        }
        
        return false;
    }
    
    public boolean checkSubarraySum_NxN(int[] nums, int k) {
        if (nums == null || nums.length <= 1) {
            return false;
        }
        
        var sum = new int[nums.length + 1];
        sum[0] = 0;
        sum[1] = nums[0];
        
        for (var i = 2; i <= nums.length; i++) {
            sum[i] = sum[i - 1] + nums[i - 1];
            
            for (var j = 0; j <= i - 2; j++) {
                if (k == 0) {
                    if (sum[i] - sum[j] == 0) {
                        return true;
                    }
                } else if ((sum[i] - sum[j]) % k == 0) {
                    return true;
                }
            }
        }
        
        return false;
    }
}