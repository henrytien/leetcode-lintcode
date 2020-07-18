// Source : https://leetcode.com/problems/3sum-closest/submissions/
// Author : Ubique0305
// Date   : 2020-07-18

/***************************************************************************************************** 
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the 
 * sum is closest to target. Return the sum of the three integers. You may assume that each input 
 * would have exactly one solution.
 * 
 * Example 1:
 * 
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 * 
 * Constraints:
 * 
 * 	3 <= nums.length <= 10^3
 * 	-10^3 <= nums[i] <= 10^3
 * 	-10^4 <= target <= 10^4
 ******************************************************************************************************/

class Solution {
    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int ans = nums[0] + nums[1] + nums[2];
        for(int i = 0; i < nums.length - 2; i++){
            int l = i + 1;
            int r = nums.length - 1;
            while(l < r){
                int sum = nums[l] + nums[r] + nums[i];
                if(Math.abs(target - sum) < Math.abs(target - ans))
                    ans = sum;
                if(sum == target)
                    return ans;
                if(sum < target)
                    l++;
                if(sum > target)
                    r--;
            }
        }
        return ans;
    }
}
