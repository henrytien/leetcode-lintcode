// Source : https://leetcode.com/problems/subarray-sum-equals-k/
// Author : Kris
// Date   : 2020-10-08

/***************************************************************************************************** 
 *
 * Given an array of integers and an integer k, you need to find the total number of continuous 
 * subarrays whose sum equals to k.
 * 
 * Example 1:
 * 
 * Input:nums = [1,1,1], k = 2
 * Output: 2
 * 
 * Constraints:
 * 
 * 	The length of the array is in range [1, 20,000].
 * 	The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 
 * 1e7].
 ******************************************************************************************************/

class Solution {
    // O(n)
    public int subarraySum(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        // sum, count
        var map = new HashMap<Integer, Integer>();
        map.put(0, 1);
        var sum = 0;
        var count = 0;
        for (var i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (map.containsKey(sum - k)) {
                count += map.get(sum - k);
            }
            
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        
        return count;
    }
    
    // O(n^2)
    public int subarraySum_NxN(int[] nums, int k) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        var sums = new int[nums.length + 1];
        for (var i = 0; i < nums.length; i++) {
            sums[i + 1] = sums[i] + nums[i];
        }
        
        var count = 0;
        for (var i = 0; i <= nums.length; i++) {
            for (var j = i + 1; j <= nums.length; j++) {
                if (sums[j] - sums[i] == k) {
                    count++;
                }
            }
        }
        return count;
    }
}