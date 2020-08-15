// Source : https://leetcode.com/problems/daily-temperatures/
// Author : henrytine
// Date   : 2020-08-15

/***************************************************************************************************** 
 *
 * 
 * Given a list of daily temperatures T, return a list such that, for each day in the input, tells you 
 * how many days you would have to wait until a warmer temperature.  If there is no future day for 
 * which this is possible, put 0 instead.
 * 
 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output 
 * should be [1, 1, 4, 2, 1, 1, 0, 0].
 * 
 * Note:
 * The length of temperatures will be in the range [1, 30000].
 * Each temperature will be an integer in the range [30, 100].
 ******************************************************************************************************/

class Solution {
public:
    vector<int> dailyTemperatures(vector<int>& T) {
        int n = T.size();
        if (n == 0) {
            return {};
        }
        
        stack<pair<int,int>> s;
        s.push({T.back(),0});
        
        vector<int> res(n,0);
        int cnt = 0;
        for (int i = n - 2; i >= 0; i--) {
            cnt = 1;
            while (!s.empty() && s.top().first <= T[i]) {
                cnt += s.top().second;
                s.pop();
            }
            
            if (s.empty()) {
                s.push(make_pair(T[i],0));
            } else {
                s.push(make_pair(T[i],cnt));
                res[i] = cnt;
            }
        }
        return res;
    }
};