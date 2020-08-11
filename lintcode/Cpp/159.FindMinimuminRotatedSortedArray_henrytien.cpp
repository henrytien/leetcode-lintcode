//https://www.lintcode.com/problem/find-minimum-in-rotated-sorted-array/description?_from=ladder&&fromId=1

class Solution {
public:
    /**
     * @param nums: a rotated sorted array
     * @return: the minimum number in the array
     */
    int findMin(vector<int> &nums) {
        // if(nums.size() == 0)
        //     return 0;
        // sort(nums.begin(),nums.end());
        // return nums[0];
        int len = nums.size();
        if(len == 0)
            return 0;
        if(len == 1)
            return nums[0];
        
        int left = 0,right = len - 1;
        while(nums[left] > nums[right]){
             int mid = left + (right - left) / 2;
             if(nums[mid] > nums[right])
                left = mid + 1;
            else 
                right = mid;
                
        }
        return nums[left];
    }
};