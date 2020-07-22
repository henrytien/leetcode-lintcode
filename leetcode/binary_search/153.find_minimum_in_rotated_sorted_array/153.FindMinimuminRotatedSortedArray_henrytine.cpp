// Source : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Author : henrytine
// Date   : 2020-07-22

/***************************************************************************************************** 
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 * 
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 * 
 * Find the minimum element.
 * 
 * You may assume no duplicate exists in the array.
 * 
 * Example 1:
 * 
 * Input: [3,4,5,1,2] 
 * Output: 1
 * 
 * Example 2:
 * 
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 * 
 ******************************************************************************************************/

class Solution {
public:
    int findMin(vector<int>& nums) {
        int start = 0, end = nums.size() - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] < nums[end]) {
                end = mid;
            }
            else {
                start = mid + 1;
            }
        }
        return nums[start];
    }
};

