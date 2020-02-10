// https://www.lintcode.com/problem/maximum-subarray-ii/description
class Solution {
public:
    /*
     * @param nums: A list of integers
     * @return: An integer denotes the sum of max two non-overlapping subarrays
     */
    int maxTwoSubArrays(vector<int> &nums) {
        int n = nums.size();
        vector<int> left(n,0);
        int preSum = 0, curSum = 0, maxSum = INT_MIN;
        for (int i = 0; i < n; i++) {
            curSum += nums[i];
            maxSum = max(maxSum,curSum - preSum);
            left[i] = maxSum;
            preSum = min(curSum,preSum);
        }
        
        vector<int> right(nums.size(),0);
        preSum = 0, curSum = 0, maxSum = INT_MIN;
        for (int i = n - 1; i >= 0; i--) {
            curSum += nums[i];
            maxSum = max(maxSum,curSum - preSum);
            right[i] = maxSum;
            preSum = min(curSum, preSum);
        }
        int res = INT_MIN;
        
        for (int i = 0; i < left.size() -1; i++) {
            // std::cout << "left: " << left[i] << " right[i] " << right[i+1] << std::endl;
            res = max(res,left[i] + right[i+1]);
        }
        
        
        
        return res;
    
    }
};