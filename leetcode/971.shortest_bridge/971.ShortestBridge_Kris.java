// Source : https://leetcode.com/problems/shortest-bridge/
// Author : Kris
// Date   : 2020-08-05

/***************************************************************************************************** 
 *
 * In a given 2D binary array A, there are two islands.  (An island is a 4-directionally connected 
 * group of 1s not connected to any other 1s.)
 * 
 * Now, we may change 0s to 1s so as to connect the two islands together to form 1 island.
 * 
 * Return the smallest number of 0s that must be flipped.  (It is guaranteed that the answer is at 
 * least 1.)
 * 
 * Example 1:
 * Input: A = [[0,1],[1,0]]
 * Output: 1
 * Example 2:
 * Input: A = [[0,1,0],[0,0,0],[0,0,1]]
 * Output: 2
 * Example 3:
 * Input: A = [[1,1,1,1,1],[1,0,0,0,1],[1,0,1,0,1],[1,0,0,0,1],[1,1,1,1,1]]
 * Output: 1
 * 
 * Constraints:
 * 
 * 	2 <= A.length == A[0].length <= 100
 * 	A[i][j] == 0 or A[i][j] == 1
 ******************************************************************************************************/

class Solution {
    // 0 水
    // 1 另一个岛
    // 2 第一个岛 和 搜索过的 水
    public int shortestBridge(int[][] A) {
        if (A == null || A.length < 1 || A[0].length < 1) {
            return -1;
        }
        
        MarkOneIsland:
        for (var i = 0; i < A.length; i++) {
            for (var j = 0; j < A[0].length; j++) {
                if (A[i][j] == 1) {
                    dfs(A, i, j);
                    break MarkOneIsland;
                }
            }
        }
        
        return bfs(A);
    }
    
    void dfs(int[][] A, int i, int j) {
        if (i < 0 || i >= A.length || j < 0 || j >= A[0].length || A[i][j] == 0 || A[i][j] == 2) {
            return;
        }
        
        A[i][j] = 2;
        
        dfs(A, i + 1, j);
        dfs(A, i - 1, j);
        dfs(A, i, j + 1);
        dfs(A, i, j - 1);
    }
    
    int bfs(int[][] A) {
        var queue = new LinkedList<int[]>();
        var dx = new int[] {1, -1, 0, 0};
        var dy = new int[] {0, 0, 1, -1};
        
        for (var i = 0; i < A.length; i++) {
            for (var j = 0; j < A[0].length; j++) {
                if (A[i][j] == 2) {
                    queue.offer(new int[] {i, j});
                }
            }
        }
        
        var step = 0;
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var cur = queue.poll();
                for (var j = 0; j < dx.length; j++) {
                    var x = cur[0] + dx[j];
                    var y = cur[1] + dy[j];
                    
                    if (x < 0 || x >= A.length || y < 0 || y >= A[0].length
                        || A[x][y] == 2) { // 已搜索过的地方
                        continue;
                    } else if (A[x][y] == 1) { // 另一个小岛
                        return step;
                    } else if (A[x][y] == 0) { // 水
                        queue.offer(new int[] {x, y});
                        A[x][y] = 2;
                    }
                }
            }
            step++;
        }
        
        return -1;
    }
}