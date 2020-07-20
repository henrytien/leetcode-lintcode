
//https://www.lintcode.com/problem/last-position-of-target/description
class Solution {
public:
    /**
     * @param nums: An integer array sorted in ascending order
     * @param target: An integer
     * @return: An integer
     */
    int lastPosition(vector<int> &nums, int target) {
        // write your code here
        int n = nums.size();
        if(n == 0)
        {
            return -1;
        }
        if(nums[n-1] < target || nums[0] > target)
        {
            return -1;
        }
        
        int l = 0, r = n -1;
        int end = -1;
        while(l <= r)
        {
            int mid = (l + r)  >> 1;
            if(nums[mid] == target)
            {
                end = mid;
            }
            if(nums[mid] <= target)
            {
                l = mid + 1;
            }
            else{
                r = mid - 1;
            }
        }
        
        return end;
    }
};