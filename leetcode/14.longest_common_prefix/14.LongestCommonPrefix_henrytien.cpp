// Source : https://leetcode.com/problems/longest-common-prefix/
// Author : henrytien
// Date   : 2022-01-05

/***************************************************************************************************** 
 *
 * Write a function to find the longest common prefix string amongst an array of strings.
 * 
 * If there is no common prefix, return an empty string "".
 * 
 * Example 1:
 * 
 * Input: strs = ["flower","flow","flight"]
 * Output: "fl"
 * 
 * Example 2:
 * 
 * Input: strs = ["dog","racecar","car"]
 * Output: ""
 * Explanation: There is no common prefix among the input strings.
 * 
 * Constraints:
 * 
 * 	1 <= strs.length <= 200
 * 	0 <= strs[i].length <= 200
 * 	strs[i] consists of only lower-case English letters.
 ******************************************************************************************************/

class Solution {
public:
    string longestCommonPrefix(vector<string>& strs) {
        string res = "";
		
		if (strs.size() == 0)
		{
			return res;
		}
		// Default first word
		for (int i = 0; i < strs[0].size(); i++)
		{
			char c = strs[0][i];
			cout << "c: " << c << endl;
			// Check every character for every word.
			for (int j = 1; j < strs.size();j++)
			{
				if (i >= strs[j].size() || strs[j][i] != c)
				{
					return res;
				}
			}
			res += c;
		}
        return res;
    }
};
