//https://leetcode.com/problems/two-sum/submissions/
#include"ac.h"
class Solution {
public:
   vector<int> twoSum(vector<int>& nums, int target) {
       vector<int> res;
       unordered_map<int, int> hash;
       for (int i = 0; i < nums.size(); i++) {
           int tmp = target - nums[i];
           if(hash.count(tmp)){
               res.push_back(i);
               res.push_back(hash[tmp]);
               return res;
           }
            hash[nums[i]] = i;
       }
       return res;
   }
};


int main(){
    Solution s;
//    vector<int> nums = {2,7,11,15};
//    int t = 9;
    
    vector<int> nums(3,3);
    int t = 6;
    
    vector<int> res =  s.twoSum(nums, t);
    for (auto num : res) {
        cout << num << endl;
    }
}