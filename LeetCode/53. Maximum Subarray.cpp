// https://leetcode-cn.com/problems/maximum-subarray/
//timeout O(n^2)
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

