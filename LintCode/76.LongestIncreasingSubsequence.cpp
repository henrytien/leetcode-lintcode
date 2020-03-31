// https://www.lintcode.com/problem/longest-increasing-subsequence/description

class Solution {
public:
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    int longestIncreasingSubsequence(vector<int> &nums) {
        multiset<int> s;
        for(auto num : nums){
           s.insert(num);
           auto pos = s.lower_bound(num);
           if(++pos != s.end()) s.erase(pos);
        }
        return s.size();
    }
};

// dp version
class Solution {
public:
    /**
     * @param nums: An integer array
     * @return: The length of LIS (longest increasing subsequence)
     */
    int longestIncreasingSubsequence(vector<int> &nums) {
       
       vector<int> dp(nums.size(),0);
       int ans = 0;
       for(int i = 0; i < nums.size(); ++i){
           dp[i] = 1;
           for(int j = i - 1; j >= 0; j--){
               if(nums[j] < nums[i]) dp[i] = max(dp[i],dp[j] + 1);
           }
           ans = max(ans,dp[i]);
       }
       return ans;
    }
};