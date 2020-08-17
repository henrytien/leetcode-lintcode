// Source : https://leetcode.com/problems/3sum/
// Author : henrytine
// Date   : 2020-08-17

/***************************************************************************************************** 
 *
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0? Find 
 * all unique triplets in the array which gives the sum of zero.
 * 
 * Note:
 * 
 * The solution set must not contain duplicate triplets.
 * 
 * Example:
 * 
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * 
 * A solution set is:
 * [
 *   [-1, 0, 1],
 *   [-1, -1, 2]
 * ]
 * 
 ******************************************************************************************************/
class Solution {
public:
    vector<vector<int>> threeSum(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        vector<vector<int>> res;
        for (int i = 0; i < nums.size() && nums[i] <= 0; ++i) {
            if (i == 0 || nums[i - 1] != nums[i]) {
                twoSum(nums, i, res);
            }
        }
        return res;
    }
    
    void twoSum(vector<int>& nums, int i, vector<vector<int>> &res) {
        unordered_set<int> seen;
        for (int j = i + 1; j < nums.size(); ++j) {
            int complement = -nums[i] - nums[j];
            if (seen.count (complement)) {
                res.push_back({nums[i], complement, nums[j]});
                while (j + 1 < nums.size() && nums[j] == nums[j+1]) {
                    ++j;
                }
            }
            seen.insert(nums[j]);
        }
    }
};
