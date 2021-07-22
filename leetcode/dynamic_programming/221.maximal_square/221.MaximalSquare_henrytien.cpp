// Source : https://leetcode.com/problems/maximal-square/
// Author : henrytien
// Date   : 2021-03-24

/***************************************************************************************************** 
 *
 * Given an m x n binary matrix filled with 0's and 1's, find the largest square containing only 1's 
 * and return its area.
 * 
 * Example 1:
 * 
 * Input: matrix = 
 * [["1","0","1","0","0"],["1","0","1","1","1"],["1","1","1","1","1"],["1","0","0","1","0"]]
 * Output: 4
 * 
 * Example 2:
 * 
 * Input: matrix = [["0","1"],["1","0"]]
 * Output: 1
 * 
 * Example 3:
 * 
 * Input: matrix = [["0"]]
 * Output: 0
 * 
 * Constraints:
 * 
 * 	m == matrix.length
 * 	n == matrix[i].length
 * 	1 <= m, n <= 300
 * 	matrix[i][j] is '0' or '1'.
 ******************************************************************************************************/

class Solution {
public:
    int maximalSquare(vector<vector<char>>& matrix) {
        if(matrix.size() == 0) return 0;
        
        int m = matrix.size(), n = matrix[0].size(), sz = 0;
        vector<int> cur(n,0), pre(n,0);
        
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(!i || !j || matrix[i][j] == '0') {
                    cur[j] = matrix[i][j] - '0';
                }else {
                    cur[j] = min(pre[j-1],min(pre[j],cur[j-1])) + 1;
                }
                sz = max(sz,cur[j]);
            }
            fill(pre.begin(),pre.end(),0);
            swap(pre,cur);
        }
        return sz*sz;
    }
};
