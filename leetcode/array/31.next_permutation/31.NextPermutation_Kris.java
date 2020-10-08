// Source : https://leetcode.com/problems/next-permutation/
// Author : Kris
// Date   : 2020-10-08

/***************************************************************************************************** 
 *
 * Implement next permutation, which rearranges numbers into the lexicographically next greater 
 * permutation of numbers.
 * 
 * If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., 
 * sorted in ascending order).
 * 
 * The replacement must be in place and use only constant extra memory.
 * 
 * Example 1:
 * Input: nums = [1,2,3]
 * Output: [1,3,2]
 * Example 2:
 * Input: nums = [3,2,1]
 * Output: [1,2,3]
 * Example 3:
 * Input: nums = [1,1,5]
 * Output: [1,5,1]
 * Example 4:
 * Input: nums = [1]
 * Output: [1]
 * 
 * Constraints:
 * 
 * 	1 <= nums.length <= 100
 * 	0 <= nums[i] <= 100
 ******************************************************************************************************/

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length < 2) {
            return;
        }
        
        // 找到第 1 个递增的值
        var i = nums.length - 2;
        while (i >= 0 && nums[i] >= nums[i + 1]) {
            i--;
        }
        
        // 交换 该值 与 后面比他大的的最小值，由于后面都是递减的，可以反向查找
        if (i >= 0) {
            for (var j = nums.length - 1; j > i; j--) {
                if (nums[j] > nums[i]) {
                    swap(nums, i, j);
                    break;
                }
            }
        }
        
        // [3,2,1]: i = -1, convert to [1,2,3]
        Arrays.sort(nums, i + 1, nums.length);
    }
    
    void swap(int[] nums, int i, int j) {
        if (i != j) {
            nums[i] = nums[i] ^ nums[j];
            nums[j] = nums[i] ^ nums[j];
            nums[i] = nums[i] ^ nums[j];
        }
    }
}