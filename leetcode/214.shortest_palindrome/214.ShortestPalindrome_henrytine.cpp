// Source : https://leetcode.com/problems/shortest-palindrome/
// Author : henrytine
// Date   : 2020-07-23

/***************************************************************************************************** 
 *
 * Given a string s, you are allowed to convert it to a palindrome by adding characters in front of 
 * it. Find and return the shortest palindrome you can find by performing this transformation.
 * 
 * Example 1:
 * 
 * Input: "aacecaaa"
 * Output: "aaacecaaa"
 * 
 * Example 2:
 * 
 * Input: "abcd"
 * Output: "dcbabcd"
 ******************************************************************************************************/
// Time Complexity: O(n)
// Space Complexity: O(1)
class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        sort(nums.begin(),nums.end());
        for (int i = 1; i < nums.size(); ++i) {
            if(nums[i] - nums[i-1] == 0){
                return nums[i];
            }
        }
        return -1;
    }
};