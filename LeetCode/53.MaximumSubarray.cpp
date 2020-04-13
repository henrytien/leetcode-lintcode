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
        vector<int> dp(nums.size()+1,0);
        int len = nums.size();
        dp[0] = nums[0];
        for (int i = 1; i < len; ++i) {
            if(dp[i-1] >= 0){
                dp[i] = dp[i-1] + nums[i];
            }
            else{
                dp[i] = nums[i];
            }
        }
        // find max value in the dp
        int res = dp[0];
        for(int i = 1; i < len; i++){
            res = max(dp[i],res);
        }
        return res;
    }
};

