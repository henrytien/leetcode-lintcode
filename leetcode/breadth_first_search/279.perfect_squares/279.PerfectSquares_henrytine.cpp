// Source : https://leetcode.com/problems/perfect-squares/
// Author : henrytine
// Date   : 2020-07-29

/***************************************************************************************************** 
 *
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 
 * 16, ...) which sum to n.
 * 
 * Example 1:
 * 
 * Input: n = 12
 * Output: 3 
 * Explanation: 12 = 4 + 4 + 4.
 * 
 * Example 2:
 * 
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 ******************************************************************************************************/
// BFS
class Solution {
public:
    int numSquares(int n) {
        if (n <= 0) return 0;
        queue<int> q;
        q.push(n);
        int depth = 0;
        
        while (!q.empty()) {
            ++depth;
            int size = q.size();
            for (int i = 0; i < size; i++) {
               int cur = q.front();
               q.pop();
               for (int j = 1; j*j <= cur; ++j) {
                    int rest = cur - j*j;
                   if (rest == 0) {
                       return depth;
                   }else {
                       q.push(rest);
                   }
                } 
            }
        }
        return depth;
        
    }
};