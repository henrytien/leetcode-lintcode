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


// divide and Conquer

class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        return maxSubArrayDivideConqure(nums, 0, nums.size() - 1);
    }
    
private:
    int maxSubArrayDivideConqure(vector<int> &nums, int start, int end){
        int len = nums.size();
        // recursion over
        if(start == end){
            return nums[start];
        }
        
        int mid = start + (end - start) / 2;
        
        int leftMax = maxSubArrayDivideConqure(nums, start, mid);
        int rightMax = maxSubArrayDivideConqure(nums, mid+1, end);
        
        // mid area index of mid to mid+1
        int cross_max_left = INT_MIN;
        int left_sum = 0;
        for (int i = mid; i >= start; i--) {
            left_sum += nums[i];
            cross_max_left = max(left_sum,cross_max_left);
        }
        
        // max sum of right array
        int cross_max_right = nums[mid+1];
        int right_sum = 0;
        for (int i = mid + 1; i <= end; ++i) {
            right_sum += nums[i];
            cross_max_right = max(right_sum,cross_max_right);
        }
        
        int max_cross = cross_max_right + cross_max_left;
        return max(max_cross,max(leftMax,rightMax));
        
    }
};