// Source : https://leetcode.com/problems/regions-cut-by-slashes/
// Author : Kris
// Date   : 2020-10-31

/***************************************************************************************************** 
 *
 * In a N x N grid composed of 1 x 1 squares, each 1 x 1 square consists of a /, \, or blank space.  
 * These characters divide the square into contiguous regions.
 * 
 * (Note that backslash characters are escaped, so a \ is represented as "\\".)
 * 
 * Return the number of regions.
 * 
 * Example 1:
 * 
 * Input:
 * [
 *   " /",
 *   "/ "
 * ]
 * Output: 2
 * Explanation: The 2x2 grid is as follows:
 * 
 * Example 2:
 * 
 * Input:
 * [
 *   " /",
 *   "  "
 * ]
 * Output: 1
 * Explanation: The 2x2 grid is as follows:
 * 
 * Example 3:
 * 
 * Input:
 * [
 *   "\\/",
 *   "/\\"
 * ]
 * Output: 4
 * Explanation: (Recall that because \ characters are escaped, "\\/" refers to \/, and "/\\" refers to 
 * /\.)
 * The 2x2 grid is as follows:
 * 
 * Example 4:
 * 
 * Input:
 * [
 *   "/\\",
 *   "\\/"
 * ]
 * Output: 5
 * Explanation: (Recall that because \ characters are escaped, "/\\" refers to /\, and "\\/" refers to 
 * \/.)
 * The 2x2 grid is as follows:
 * 
 * Example 5:
 * 
 * Input:
 * [
 *   "//",
 *   "/ "
 * ]
 * Output: 3
 * Explanation: The 2x2 grid is as follows:
 * 
 * Note:
 * 
 * 	1 <= grid.length == grid[0].length <= 30
 * 	grid[i][j] is either '/', '\', or ' '.
 * 
 ******************************************************************************************************/

class Solution {
    public int regionsBySlashes(String[] grid) {
        var N = grid.length;
        var uf = new UnionFind(4 * N * N);
        
        for (var i = 0; i < N; i++) {
            for (var j = 0; j < N; j++) {
                var root = 4 * (i * N + j);
                var ch = grid[i].charAt(j);
                
                // 同一格子
                if (ch == '/') {
                    uf.union(root + 0, root + 1); // 上 & 左
                    uf.union(root + 2, root + 3); // 右 & 下
                } else if (ch == '\\') {
                    uf.union(root + 0, root + 2); // 上 & 右
                    uf.union(root + 1, root + 3); // 左 & 下
                } else {
                    uf.union(root + 0, root + 1);
                    uf.union(root + 0, root + 2);
                    uf.union(root + 0, root + 3);
                }

                // 相邻格子
                // 上 & 下
                if (i < N - 1) {
                    uf.union(root + 3, (root + 4 * N) + 0);
                }
                // 左 & 右
                if (j < N - 1) {
                    uf.union(root + 2, (root + 4) + 1);
                }
            }
        }
        
        return uf.count;
    }
    
    static class UnionFind {
        int[] parents;
        int[] size;
        int count;
        
        UnionFind(int n) {
            this.parents = new int[n];
            this.size = new int[n];
            this.count = n;
            
            for (var i = 0; i < parents.length; i++) {
                this.parents[i] = i;
                this.size[i] = 1;
            }
        }
        
        int find(int i) {
            while (i != parents[i]) {
                parents[i] = parents[parents[i]];
                i = parents[i];
            }
            
            return i;
        }
        
        void union(int i, int j) {
            var rootI = find(i);
            var rootJ = find(j);
            
            if (rootI == rootJ) {
                return;
            }
            
            if (size[rootI] >= size[rootJ]) {
                parents[rootJ] = rootI;
                size[rootI] += size[rootJ];
            } else {
                parents[rootI] = rootJ;
                size[rootJ] += size[rootI];
            }
            count--;
        }
    }
}