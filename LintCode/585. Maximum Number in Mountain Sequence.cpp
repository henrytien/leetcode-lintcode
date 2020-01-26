
// https://www.lintcode.com/problem/maximum-number-in-mountain-sequence/description?_from=ladder&&fromId=1

#include<algorithm>
class Solution {
public:
    /**
     * @param nums: a mountain sequence which increase firstly and then decrease
     * @return: then mountain top
     */
    int mountainSequence(vector<int> &nums) {
        int left = 0, right = nums.size() -1;
        while(left + 1 < right)
        {
            int m1 = left + (right - left) / 2;
            int m2 = right - (right - m1) / 2;
           
            if(nums[m1] < nums[m2])
            {
                left = m1 + 1;
            }
            else if(nums[m1] > nums[m2])
            {
                right = m2 -1;
            }else
            {
                left = m1;
                right = m2;
            }
        }
        return nums[left] > nums[right] ? nums[left]:nums[right];
    }
};