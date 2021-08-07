// Source : https://leetcode.com/problems/number-of-islands/
// Author : Kris
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
    public int numIslands(char[][] grid) {
        if (grid == null || grid.length == 0 || grid[0] == null || grid[0].length == 0) {
            return 0;
        }
        
        var visit = new boolean[grid.length][grid[0].length];
        var count = 0;
        
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1' && !visit[i][j]) {
                    bfs(grid, visit, i, j);
                    count++;
                }
            }
        }
        
        return count;
    }
    
    void bfs(char[][] grid, boolean[][] visit, int x, int y) {
        var dx = new int[] {1, -1, 0, 0};
        var dy = new int[] {0, 0, 1, -1};
        
        var queue = new LinkedList<int[]>();
        queue.offer(new int[] {x, y});
        visit[x][y] = true;
        
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var point = queue.poll();
                
                for (var j = 0; j < dx.length; j++) {
                    var x1 = point[0] + dx[j];
                    var y1 = point[1] + dy[j];
                    if (x1 >= 0 && x1 < grid.length && y1 >= 0 && y1 < grid[0].length
                        && !visit[x1][y1] && grid[x1][y1] == '1') {
                        queue.offer(new int[] {x1, y1});
                        visit[x1][y1] = true;
                    }
                }
            }
        }
    }
}