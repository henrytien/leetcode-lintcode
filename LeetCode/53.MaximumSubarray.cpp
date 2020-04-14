// https://leetcode-cn.com/problems/maximum-subarray/
//timeout O(n^2)
#include "ac.h"
class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        
        int size = static_cast<int>(nums.size());
        if(size == 0) return 0;
        int res = INT_MIN;
        
        for (int i = 0; i < size; i++) {
            int sum = 0;
            for (int j = i; j < size; j++) {
                
                sum += nums[j];
                
                res = max(res, sum);
                
            }
        }
        return res;
    }
};

// dp


class Solution {
public:
    int maxSubArray(vector<int>& nums) {

        int len = nums.size();
        vector<int> dp(len + 1,0);
        dp[0] = nums[0]; // init dp
        int res = dp[0];
        for (int i = 1; i < len; ++i) {
            
            dp[i] = dp[i-1] > 0 ? (dp[i-1] + nums[i]) : nums[i];
            res = max(res,dp[i]);
        }
        
        return res;
    }
};


