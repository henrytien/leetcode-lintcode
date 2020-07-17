// https://leetcode-cn.com/problems/search-insert-position/
class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        if(nums.size() == 0){
            return 0;
        }
        
        for (int i = 0; i < nums.size(); i++) {
            if(nums[i] >= target){
                return i;
            }
        }
        return nums.size();
    }
};

// binary search
class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
         if(nums.size() == 0){
                return 0;
            }
            int start = 0, end = nums.size() - 1;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(nums[mid] == target){
                    return mid;
                }
                else if(nums[mid] < target){
                    start = mid + 1;
                    
                }else {
                    end = mid - 1;
                }  
            }
            return start;
    }
};