// Source : https://leetcode.com/problems/3sum-closest/
// Author : henrytine
// Date   : 2020-07-17

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
public:
    int threeSumClosest(vector<int>& nums, int target) {
        sort(nums.begin(),nums.end());
        int n = nums.size();
        if (n < 3) return 0;
        int mincut = nums[0] + nums[1] + nums[2];
        for (int i = 0; i < n-2; ++i) {
            int lo = i + 1, hi = n - 1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (abs(sum - target) < abs(mincut - target)) mincut = sum;
                if (sum == target) return target;
                else if(sum < target) lo++;
                else hi--;
            }
        }
        return mincut;
        
    }
};