// Source : https://leetcode.com/problems/kth-largest-element-in-an-array/
// Author : henrytine
// Date   : 2020-07-13

/***************************************************************************************************** 
 *
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the 
 * sorted order, not the kth distinct element.
 * 
 * Example 1:
 * 
 * Input: [3,2,1,5,6,4] and k = 2
 * Output: 5
 * 
 * Example 2:
 * 
 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
 * Output: 4
 * 
 * Note: 
 * You may assume k is always valid, 1 &le; k &le; array's length.
 ******************************************************************************************************/
// min heap
class Solution {
public:
    int findKthLargest(vector<int>& nums, int k) {
        if (nums.size() == 0 || k == 0) return 0;
        priority_queue<int> q;
        int n = nums.size();
        for (auto e:nums) {
            q.push(e);
        }
        int cnt = 0;
        int node = 0;
        while (!q.empty()) {
            node = q.top();
            q.pop();
            ++cnt;
            if (cnt == k) return node;
        }
        return node;
    }
};