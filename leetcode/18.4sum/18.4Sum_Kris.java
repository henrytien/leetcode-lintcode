// Source : https://leetcode.com/problems/4sum/
// Author : Kris
// Date   : 2020-08-17

/***************************************************************************************************** 
 *
 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums 
 * such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of 
 * target.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate quadruplets.
 * 
 * Example:
 * 
 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
 * 
 * A solution set is:
 * [
 *   [-1,  0, 0, 1],
 *   [-2, -1, 1, 2],
 *   [-2,  0, 0, 2]
 * ]
 * 
 ******************************************************************************************************/

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        var result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length < 4) {
            return result;
        }
        
        Arrays.sort(nums);

        var visit = new boolean[nums.length];
        dfs(nums, 0, target, result, new ArrayList<Integer>(), visit);
        return result;
    }
    
    void dfs(int[] nums, int index, int target,
             List<List<Integer>> result, List<Integer> one,
             boolean[] visit) {
        if (index == nums.length || one.size() >= 4
           || nums[index] * (4 - one.size()) > target
           || nums[nums.length - 1] * (4 - one.size()) < target) {
            if (target == 0 && one.size() == 4) {
                result.add(new ArrayList<Integer>(one));
            }
            return;
        }
        
        if (one.size() < 4) {
            if (index > 0 && nums[index] == nums[index - 1] && !visit[index - 1]) {
                // skip
            } else {
                one.add(nums[index]);
                visit[index] = true;
                dfs(nums, index + 1, target - nums[index], result, one, visit);
                one.remove(one.size() - 1);
                visit[index] = false;
            }
        }
        
        dfs(nums, index + 1, target, result, one, visit);
    }
}