// Source : https://leetcode.com/problems/3sum/
// Author : Kris
// Date   : 2020-10-08

/***************************************************************************************************** 
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find 
 * all unique triplets in the array which gives the sum of zero.
 * 
 * Notice that the solution set must not contain duplicate triplets.
 * 
 * Example 1:
 * Input: nums = [-1,0,1,2,-1,-4]
 * Output: [[-1,-1,2],[-1,0,1]]
 * Example 2:
 * Input: nums = []
 * Output: []
 * Example 3:
 * Input: nums = [0]
 * Output: []
 * 
 * Constraints:
 * 
 * 	0 <= nums.length <= 3000
 * 	-105 <= nums[i] <= 105
 ******************************************************************************************************/

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        var result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        
        Arrays.sort(nums);
        
        var visit = new boolean[nums.length];
        for (var i = 0; i < nums.length - 2; i++) {
            if (i > 0 && nums[i] == nums[i - 1] && !visit[i - 1]) {
                continue;
            }
            visit[i] = true;
            
            var left = i + 1;
            var right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] == 0) {
                    result.add(List.of(nums[i], nums[left], nums[right]));
                    while (left < right && nums[left] == -nums[i] - nums[right]) {
                        left++;
                    }
                    // 跟上面一个 while 循环作用一样，都是用来排除重复
                    // while (left < right && nums[right] == -nums[i] - nums[left]) {
                    //     right--;
                    // }
                } else if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                } else {
                    right--;
                }
            }
            
            visit[i] = false;
        }
        
        return result;
    }
}