// Source : https://leetcode.com/problems/decode-ways/
// Author : henrytine
// Date   : 2020-08-31

/***************************************************************************************************** 
 *
 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
 * 
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 
 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
 * 
 * Example 1:
 * 
 * Input: "12"
 * Output: 2
 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
 * 
 * Example 2:
 * 
 * Input: "226"
 * Output: 3
 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
 ******************************************************************************************************/

class Solution {
public:
    int numDecodings(string s) {
        return s.empty() ? 0 : decodings(s);
    }
    
    int decodings(string &s) {
        int n = s.size();
        vector<int> dp(n+1,1);
        dp[n] = 1;
        
        for (int i = n-1; i >= 0; --i) {
            if (s[i] == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i+1];
                if (i < n-1 && (s[i] == '1' || (s[i] == '2' && s[i+1] < '7'))) {
                    dp[i] += dp[i+2];
                }
            }
        }
        
        return dp[0];
    }
};