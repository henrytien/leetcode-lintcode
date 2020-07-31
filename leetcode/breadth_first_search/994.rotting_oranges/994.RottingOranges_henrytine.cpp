// Source : https://leetcode.com/problems/rotting-oranges/
// Author : henrytine
// Date   : 2020-08-01

/***************************************************************************************************** 
 *
 * In a given grid, each cell can have one of three values:
 * 
 * 	the value 0 representing an empty cell;
 * 	the value 1 representing a fresh orange;
 * 	the value 2 representing a rotten orange.
 * 
 * Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.
 * 
 * Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is 
 * impossible, return -1 instead.
 * 
 * Example 1:
 * 
 * Input: [[2,1,1],[1,1,0],[0,1,1]]
 * Output: 4
 * 
 * Example 2:
 * 
 * Input: [[2,1,1],[0,1,1],[1,0,1]]
 * Output: -1
 * Explanation:  The orange in the bottom left corner (row 2, column 0) is never rotten, because 
 * rotting only happens 4-directionally.
 * 
 * Example 3:
 * 
 * Input: [[0,2]]
 * Output: 0
 * Explanation:  Since there are already no fresh oranges at minute 0, the answer is just 0.
 * 
 * Note:
 * 
 * 	1 <= grid.length <= 10
 * 	1 <= grid[0].length <= 10
 * 	grid[i][j] is only 0, 1, or 2.
 * 
 ******************************************************************************************************/

class Solution {
public:
    int orangesRotting(vector<vector<int>>& grid) {
        int fresh_cnt = 0, res = -1;
        queue<vector<int>> q;
        vector<vector<int>> dir = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
        for (int i = 0;i < grid.size();i++) {
            for (int j = 0;j < grid[0].size(); j++) {
                if (grid[i][j] > 0) {
                    fresh_cnt++;
                }
                if (grid[i][j] == 2) {
                    q.push({i, j});
                }
            }
        }
        while (!q.empty()) {
            res++;
            int size = q.size();
            for (int k = 0;k < size; k++) {
                vector<int> cur = q.front();
                fresh_cnt--;
                q.pop();
                for (int i = 0; i < 4; i++) {
                    int x = cur[0] + dir[i][0], y = cur[1] + dir[i][1];
                    if (x >= grid.size() || x < 0 || y >= grid[0].size() || y < 0 || grid[x][y] != 1) continue;
                    grid[x][y] = 2;
                    q.push({x, y});
                }
            }
        }
        if (fresh_cnt == 0) {
            return max(0, res);
        }
            
        return -1;
    }
};