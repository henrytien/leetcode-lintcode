// Source : https://leetcode.com/problems/pacific-atlantic-water-flow/
// Author : Kris
// Date   : 2020-08-05

/***************************************************************************************************** 
 *
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a 
 * continent, the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic 
 * ocean" touches the right and bottom edges.
 * 
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with 
 * height equal or lower.
 * 
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * 
 * Note:
 * 
 * 	The order of returned grid coordinates does not matter.
 * 	Both m and n are less than 150.
 * 
 * Example:
 * 
 * Given the following 5x5 matrix:
 * 
 *   Pacific ~   ~   ~   ~   ~ 
 *        ~  1   2   2   3  (5) *
 *        ~  3   2   3  (4) (4) *
 *        ~  2   4  (5)  3   1  *
 *        ~ (6) (7)  1   4   5  *
 *        ~ (5)  1   1   2   4  *
 *           *   *   *   *   * Atlantic
 * 
 * Return:
 * 
 * [[0, 4], [1, 3], [1, 4], [2, 2], [3, 0], [3, 1], [4, 0]] (positions with parentheses in above 
 * matrix).
 * 
 ******************************************************************************************************/

class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] matrix) {
        var result = new ArrayList<List<Integer>>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return result;
        }
        
        var dx = new int[] {0, 0, 1, -1};
        var dy = new int[] {1, -1, 0, 0};
        var queue = new LinkedList<int[]>();
        
        var pacific = new boolean[matrix.length][matrix[0].length];
        for (var i = 0; i < matrix[0].length; i++) {
            queue.offer(new int[] {0, i});
            pacific[0][i] = true;
        }
        for (var i = 1; i < matrix.length; i++) {
            queue.offer(new int[] {i, 0});
            pacific[i][0] = true;
        }
        
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var cur = queue.poll();
                for (var j = 0; j < dx.length; j++) {
                    var x = cur[0] + dx[j];
                    var y = cur[1] + dy[j];
                    if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
                       && matrix[x][y] >= matrix[cur[0]][cur[1]] && !pacific[x][y]) {
                        queue.offer(new int[] {x, y});
                        pacific[x][y] = true;
                    }
                }
            }
        }
        
        var atlantic = new boolean[matrix.length][matrix[0].length];
        for (var i = 0; i < matrix[0].length; i++) {
            queue.offer(new int[] {matrix.length - 1, i});
            atlantic[matrix.length - 1][i] = true;
        }
        for (var i = 0; i < matrix.length - 1; i++) {
            queue.offer(new int[] {i, matrix[0].length - 1});
            atlantic[i][matrix[0].length - 1] = true;
        }
        
        while (!queue.isEmpty()) {
            var size = queue.size();
            for (var i = 0; i < size; i++) {
                var cur = queue.poll();
                for (var j = 0; j < dx.length; j++) {
                    var x = cur[0] + dx[j];
                    var y = cur[1] + dy[j];
                    if (x >= 0 && x < matrix.length && y >= 0 && y < matrix[0].length
                       && matrix[x][y] >= matrix[cur[0]][cur[1]] && !atlantic[x][y]) {
                        queue.offer(new int[] {x, y});
                        atlantic[x][y] = true;
                    }
                }
            }
        }
        
        for (var i = 0; i < matrix.length; i++) {
            for (var j = 0; j < matrix[0].length; j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(List.of(i, j));
                }
            }
        }
        
        return result;
    }
}