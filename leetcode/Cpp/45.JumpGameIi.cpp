// Source : https://leetcode.com/problems/jump-game-ii/
// Author : henrytine
// Date   : 2020-07-16

/***************************************************************************************************** 
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the 
 * array.
 * 
 * Each element in the array represents your maximum jump length at that position.
 * 
 * Your goal is to reach the last index in the minimum number of jumps.
 * 
 * Example:
 * 
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 * 
 * Note:
 * 
 * You can assume that you can always reach the last index.
 ******************************************************************************************************/
// From discuss https://leetcode.com/problems/jump-game-ii/discuss/18019/10-lines-C%2B%2B-(16ms)-Python-BFS-Solutions-with-Explanations
class Solution {
public:
    int jump(vector<int>& nums) {
        int n = nums.size();
        int start = 0, end = 0, step = 0, maxend = 0;
        int i = 0;
        while (end < n-1) {
            ++step;
            for (; i <= end; ++i) {
                maxend = max(maxend, i + nums[i]);
                if (maxend >= n-1) return step;
            }
            if (end == maxend) break;
            end = maxend;
        }
        return  n == 1 ? 0 : -1;
    }
};