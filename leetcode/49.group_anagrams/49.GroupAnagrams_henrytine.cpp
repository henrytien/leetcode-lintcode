// Source : https://leetcode.com/problems/group-anagrams/
// Author : henrytine
// Date   : 2020-08-12

/***************************************************************************************************** 
 *
 * Given an array of strings, group anagrams together.
 * 
 * Example:
 * 
 * Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
 * Output:
 * [
 *   ["ate","eat","tea"],
 *   ["nat","tan"],
 *   ["bat"]
 * ]
 * 
 * Note:
 * 
 * 	All inputs will be in lowercase.
 * 	The order of your output does not matter.
 * 
 ******************************************************************************************************/

class Solution {
public:
    vector<vector<string>> groupAnagrams(vector<string>& strs) {
        vector<vector<string>> res;
        
        int n = strs.size();
        if (n == 0) {
            return res;
        }
        unordered_map<string, vector<string>> dict;
        for (auto &w : strs) {
            string temp = w;
            sort(temp.begin(),temp.end());
            
            dict[temp].push_back(w);
        }
        
        for (auto &w : dict) {
            res.push_back(w.second);
        }
        return res;
    }
};