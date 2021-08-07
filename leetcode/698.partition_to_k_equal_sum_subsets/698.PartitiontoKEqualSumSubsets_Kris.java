// Source : https://leetcode.com/problems/partition-to-k-equal-sum-subsets/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * Given an array of integers nums and a positive integer k, find whether it's possible to divide this 
 * array into k non-empty subsets whose sums are all equal.
 * 
 * Example 1:
 * 
 * Input: nums = [4, 3, 2, 3, 5, 2, 1], k = 4
 * Output: True
 * Explanation: It's possible to divide it into 4 subsets (5), (1, 4), (2,3), (2,3) with equal sums.
 * 
 * Note:
 * 
 * 	1 <= k <= len(nums) <= 16.
 * 	0 < nums[i] < 10000.
 * 
 ******************************************************************************************************/

class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        if (nums == null || nums.length < k || k <= 0) {
            return false;
        }
        
        var sum = Arrays.stream(nums).sum();
        if (sum % k != 0) {
            return false;
        }
        
        // 倒序排列，可以让 helper 中凑 target 速度更快
        Arrays.sort(nums); // Arrays.sort(nums, (a, b) -> b - a) 只能用于 Object 数组
        reverseArray(nums);
        if (nums[nums.length - 1] > sum / k) {
            return false;
        }
        
        var targets = new int[k];
        Arrays.fill(targets, sum / k);
        return helper(nums, 0, targets);
    }
    
    boolean helper(int[] nums, int index, int[] targets) {
        if (index == nums.length) {
            return Arrays.stream(targets).allMatch(x -> x == 0);
        }
        
        var result = false;
        for (var i = 0; i < targets.length; i++) {
            if (targets[i] >= nums[index]) {
                targets[i] -= nums[index];
                if (helper(nums, index + 1, targets)) {
                    result = true;
                    break;
                }
                targets[i] += nums[index];
            }
        }
        
        return result;
    }
    
    void reverseArray(int[] nums) {
        var i = 0;
        var j = nums.length - 1;
        while (i < j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
            i++;
            j--;
        }
    }
}