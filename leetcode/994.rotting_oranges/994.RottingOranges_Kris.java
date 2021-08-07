// Source : https://leetcode.com/problems/rotting-oranges/
// Author : Kris
// Date   : 2020-08-05

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
    public int orangesRotting(int[][] grid) {
        if (grid == null || grid.length < 1 || grid[0].length < 1) {
            return -1;
        }
        
        return bfs(grid);
    }
    
    int bfs(int[][] grid) {
        var visit = new boolean[grid.length][grid[0].length];
        var queue = new LinkedList<int[]>();
        var freshNum = 0;
        for (var i = 0; i < grid.length; i++) {
            for (var j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                    visit[i][j] = true;
                } else if (grid[i][j] == 1) {
                    freshNum++;
                }
            }
        }
        
        if (freshNum == 0) {
            return 0;
        }
        
        var step = 0;
        var dx = new int[] {0, 0, 1, -1};
        var dy = new int[] {1, -1, 0, 0};
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var point = queue.poll();
                
                for (var j = 0; j < dx.length; j++) {
                    var x = point[0] + dx[j];
                    var y = point[1] + dy[j];
                    if (x >= 0 && x < grid.length && y >= 0 && y < grid[0].length
                       && !visit[x][y] && grid[x][y] == 1) {
                        grid[x][y] = 2;
                        freshNum--;
                        visit[x][y] = true;
                        queue.offer(new int[] {x, y});
                    }
                }
            }
            
            step++;
            if (freshNum == 0) {
                return step;
            }
        }
        
        return freshNum == 0 ? 0 : -1;
    }
}