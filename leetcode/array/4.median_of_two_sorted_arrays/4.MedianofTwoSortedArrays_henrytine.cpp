// Source : https://leetcode.com/problems/median-of-two-sorted-arrays/
// Author : henrytine
// Date   : 2020-07-24

/***************************************************************************************************** 
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * 
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 * 
 * You may assume nums1 and nums2 cannot be both empty.
 * 
 * Example 1:
 * 
 * nums1 = [1, 3]
 * nums2 = [2]
 * 
 * The median is 2.0
 * 
 * Example 2:
 * 
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * 
 * The median is (2 + 3)/2 = 2.5
 * 
 ******************************************************************************************************/

class Solution {
public:
    double findMedianSortedArrays(vector<int>& nums1, vector<int>& nums2) {
        int m = nums1.size(), n = nums2.size();
        for (auto n : nums2) {
            nums1.emplace_back(n);
        }
        sort(nums1.begin(),nums1.end());
        if ((m + n) % 2 == 0) {
            double temp = nums1[(m+n)/2-1] + nums1[(m + n) / 2];
            
            return temp / 2;
        }
        else {
            return nums1[(m+n) / 2];
        }
    }
};



