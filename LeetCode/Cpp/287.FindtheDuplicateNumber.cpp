// https://leetcode.com/problems/find-the-duplicate-number/

#include "ac.h"

/* Binary search */
/* Time:O(nlog(n) S:O(1) */
class Solution {
public:
    int findDuplicate(vector<int>& nums) {
        int left = 0, right = nums.size() - 1;
        
        while(left < right){
            int mid = left + (right - left) / 2;
            int cnt = 0;
            
            for(int num:nums){
                if(mid >= num){
                    ++cnt;
                }
            }
            
            // [left,mid]
            if(cnt > mid){
                right = mid;
            }else{
                left = mid + 1;
            }
        }
        return left;
    }
};

class Solution1 {
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


int main(){
    
    vector<int> nums = {1,2,3,4,3,4};
    Solution1 s;
    cout <<  s.findDuplicate(nums) << endl;
    cout << "hello" << endl;
    return 0;
}
