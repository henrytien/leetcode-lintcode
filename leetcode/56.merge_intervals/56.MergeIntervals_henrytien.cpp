// Source : https://leetcode.com/problems/merge-intervals/
// Author : henrytine
// Date   : 2020-07-18

/***************************************************************************************************** 
 *
 * Given a collection of intervals, merge all overlapping intervals.
 * 
 * Example 1:
 * 
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * 
 * Example 2:
 * 
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * 
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to 
 * get new method signature.
 ******************************************************************************************************/

class Solution {
public:
    vector<vector<int>> merge(vector<vector<int>>& intervals) {
        int n = intervals.size();
        vector<vector<int>> res;
        if (n == 0) return res;
//         map<int,int> mp;
//         for (int i = 0; i < n; i++) {
//             mp.insert(pair<int,int>(intervals[i][0],intervals[i][1]));
//         }        
//         for (map<int,int>::iterator iter = mp.begin(); iter != mp.end(); ++iter) {
//             if ( iter->second >= (++iter)->first ) {
//                 int temp = max((iter->second),((++iter)->second));
                
//                 res.push_back({(iter->first),temp});
//             }
//             else {
//                 res.push_back({iter->first,iter->second});
//             }
//         }
        
        sort(intervals.begin(),intervals.end());
        res.emplace_back(intervals[0]);
        for (int i = 1; i < n; ++i) {
            if (res.back()[1] >= intervals[i][0]) res.back()[1] = max(res.back()[1],intervals[i][1]);
            else res.emplace_back(intervals[i]);
        }
        
        return res;
    }
};