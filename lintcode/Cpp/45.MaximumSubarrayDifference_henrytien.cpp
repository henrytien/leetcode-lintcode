// https://www.lintcode.com/problem/maximum-subarray-difference/solution
class Solution {
public:
    vector<int> getRightSum(vector<int> &nums){
        vector<int> rightSum(nums.size(),0);
        int curSum = 0, preSum = 0, maxSum = INT_MIN;
        for (int i = nums.size() - 1; i > 0; i--) {
            curSum += nums[i];
            maxSum = max(maxSum,curSum - preSum);
            rightSum[i] = maxSum;
            preSum = min(preSum,curSum);
        }
        return rightSum;
    }

    vector<int> getLeftSum(vector<int> &nums){
        vector<int> leftSum(nums.size(),0);
        int curSum = 0, preSum = 0, maxSum = INT_MIN;
        for (int i = 0; i < nums.size(); i++) {
            curSum += nums[i];
            maxSum = max(maxSum,curSum - preSum);
            leftSum[i] = maxSum;
            preSum = min(preSum,curSum);
        }
        return leftSum;
    }
    
    vector<int> getRightMinSum(vector<int> &nums){
        vector<int> rightMinSum(nums.size(),0);
        int curMinSum = 0, preMinSum = 0, maxMinSum = INT_MAX;
        for (int i = nums.size() - 1; i >= 0; i--) {
            curMinSum += nums[i];
            maxMinSum = min(maxMinSum,curMinSum - preMinSum);
            rightMinSum[i] = maxMinSum;
            preMinSum = max(preMinSum,curMinSum);
        }
        return rightMinSum;
    }


    vector<int> getLeftMinSum(vector<int> &nums){
        vector<int> leftMinSum(nums.size(),0);
        int curMinSum = 0, preMinSum = 0, maxMinSum = INT_MAX;
        for (int i = 0; i < nums.size(); i++) {
            curMinSum += nums[i];
            maxMinSum = min(maxMinSum,curMinSum - preMinSum);
            leftMinSum[i] = maxMinSum;
            preMinSum = max(curMinSum,preMinSum);
        }
        return leftMinSum;
    }


    /**
     * @param nums: A list of integers
     * @return: An integer indicate the value of maximum difference between two substrings
     */
    int maxDiffSubArrays(vector<int> &nums) {
        if(nums.size()  <= 1) return 0;
        vector<int> lMax = getLeftSum(nums);
        vector<int> rMax = getRightSum(nums);
        vector<int> lMin = getLeftMinSum(nums);
        vector<int> rMin = getRightMinSum(nums);
        
        int res = INT_MIN;
        for (int i = 0; i < nums.size() - 1; i++) {
            res = max(res,abs(lMax[i] - rMin[i+1]));
            res = max(res,abs(lMin[i] - rMax[i+1]));
        }
       return res;
    }
};