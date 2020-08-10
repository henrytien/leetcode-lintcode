// Source : https://leetcode.com/problems/two-sum/
// Author : henrytine
// Date   : 2020-07-04

/***************************************************************************************************** 
 *
 * Given an array of integers, return indices of the two numbers such that they add up to a specific 
 * target.
 * 
 * You may assume that each input would have exactly one solution, and you may not use the same 
 * element twice.
 * 
 * Example:
 * 
 * Given nums = [2, 7, 11, 15], target = 9,
 * 
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * 
 ******************************************************************************************************/

#include "ac.h"
class Solution {
public:
    vector<int> twoSum(vector<int> &nums, int target) {
        vector<int> res;
        unordered_map<int, int> hash;
        for (int i = 0; i < nums.size(); i++) {
            int tmp = target - nums[i];
            if (hash.count(tmp)) {
                res.push_back(i);
                res.push_back(hash[tmp]);
                return res;
            }
            hash[nums[i]] = i;
        }
        return res;
    }
};

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        unordered_map<int,int> hash_map;
        int n = nums.size();
        for (int i = 0; i < n; ++i)
            hash_map[nums[i]] = i;
        
        vector<int> res;
        for (int i = 0; i < n; ++i) {
            int temp = target - nums[i];
            if (hash_map.count(temp) && hash_map[temp] != i) {
                res.emplace_back(i);
                res.emplace_back(hash_map[temp]);
                return res;
            }
        }
        return res;
        
    }
};

int main() {
    //    vector<int> nums = {2,7,11,15};
    //    int t = 9;

    vector<int> nums(3, 3);
    int t = 6;

    vector<int> res = Solution().twoSum(nums, t);
    for (auto num : res)
    {
        cout << num << endl;
    }
}