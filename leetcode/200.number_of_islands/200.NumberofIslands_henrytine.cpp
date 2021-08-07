// Source : https://leetcode.com/problems/number-of-islands/
// Author : henrytine
// Date   : 2020-07-28

/***************************************************************************************************** 
 *
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is 
 * surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may 
 * assume all four edges of the grid are all surrounded by water.
 * 
 * Example 1:
 * 
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 * 
 * Example 2:
 * 
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 ******************************************************************************************************/

class Solution {
public:
    int numIslands(vector<vector<char>>& grid) {
       int m = grid.size(), n = m ? grid[0].size() : 0, cnt = 0, offset[] = {0, 1, 0, -1, 0};
    
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                if (grid[i][j] == '1') {
                    ++cnt;
                    grid[i][j] = '0'; 
                    queue<pair<int,int>> q;
                    q.push({i,j});
                    while (!q.empty()) {
                        pair<int, int> pos = q.front();
                        q.pop();
                        for (int k = 0; k < 4; ++k) {
                            int r = pos.first + offset[k], c = pos.second + offset[k+1];
                            if (r < m && r >= 0 && c >= 0 && c < n && grid[r][c] == '1') {
                                grid[r][c] = '0';
                                q.push({r, c});
                            }
                        } 
                    }
                }
            }
        }
        return cnt;
    }
};