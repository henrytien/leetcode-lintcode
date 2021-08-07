// Source : https://leetcode.com/problems/intersection-of-two-arrays/
// Author : henrytine
// Date   : 2020-07-25

/***************************************************************************************************** 
 *
 * Given two arrays, write a function to compute their intersection.
 * 
 * Example 1:
 * 
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 * 
 * Example 2:
 * 
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 * 
 * Note:
 * 
 * 	Each element in the result must be unique.
 * 	The result can be in any order.
 * 
 ******************************************************************************************************/

class Solution {
public:
    vector<int> intersection(vector<int>& nums1, vector<int>& nums2) {
        unordered_map<int, int> hash;
        for (auto n : nums1) {
            hash[n] = 1;
        }
        vector<int> res;
        for (int i = 0; i < nums2.size(); i++) {
            if (hash[nums2[i]]) {
                res.emplace_back(nums2[i]);
                hash.erase(nums2[i]);
            }
        }
        return res;
    }
};