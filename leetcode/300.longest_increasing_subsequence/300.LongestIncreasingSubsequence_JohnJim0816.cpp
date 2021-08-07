/*
 * @Author: John
 * @Email: johnjim0816@gmail.com
 * @Date: 2020-07-28 16:38:02
 * @LastEditor: John
 * @LastEditTime: 2020-07-28 17:00:21
 * @Discription: 
 * @Environment: 
 */ 
// Source : https://leetcode.com/problems/longest-increasing-subsequence/
// Author : JohnJim0816
// Date   : 2020-07-28

/***************************************************************************************************** 
 *
 * Given an unsorted array of integers, find the length of longest increasing subsequence.
 * 
 * Example:
 * 
 * Input: [10,9,2,5,3,7,101,18]
 * Output: 4 
 * Explanation: The longest increasing subsequence is [2,3,7,101], therefore the length is 4. 
 * 
 * Note: 
 * 
 * 	There may be more than one LIS combination, it is only necessary for you to return the 
 * length.
 * 	Your algorithm should run in O(n2) complexity.
 * 
 * Follow up: Could you improve it to O(n log n) time complexity?
 ******************************************************************************************************/
#include <iterator>
#include <valarray>
class Solution { //动态规划，时O(n^2)空O(n)
public:
    int lengthOfLIS(vector<int>& nums) {
        int n = nums.size();
        if (n==0){ //数组为空
            return 0;
        } 
        int dp[n];
        for(int i = 0; i<n;i++){
            dp[i]=1;
            for(int j = 0;j<i;j++){
                if(nums[i]>nums[j]){
                    dp[i]=max(dp[i],dp[j]+1);
                }
            }
        }
        return *max_element(dp,dp+n);    
    }
};
