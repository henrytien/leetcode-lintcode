// Source : https://leetcode.com/problems/triangle/
// Author : Kris
// Date   : 2020-09-25

/***************************************************************************************************** 
 *
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent 
 * numbers on the row below.
 * 
 * For example, given the following triangle
 * 
 * [
 *      [2],
 *     [3,4],
 *    [6,5,7],
 *   [4,1,8,3]
 * ]
 * 
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * 
 * Note:
 * 
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of 
 * rows in the triangle.
 ******************************************************************************************************/

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        if (triangle == null || triangle.size() < 1) {
            return 0;
        }
        
        var m = triangle.size();
        var n = triangle.get(m - 1).size();
        
        var dp = new int[2][n];
        dp[0][0] = triangle.get(0).get(0);
        
        for (var i = 1; i < m; i++) {
            for (var j = 0; j < triangle.get(i).size(); j++) {
                if (j == 0) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j] + triangle.get(i).get(j);
                } else if (j < triangle.get(i).size() - 1) {
                    dp[i % 2][j] = Math.min(dp[(i - 1) % 2][j - 1] + triangle.get(i).get(j),
                                       dp[(i - 1) % 2][j] + triangle.get(i).get(j));
                } else {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - 1] + triangle.get(i).get(j);
                }
            }
        }
        
        var min = Integer.MAX_VALUE;
        for (var j = 0; j < n; j++) {
            min = Math.min(min, dp[(m - 1) % 2][j]);
        }
        
        return min;
    }
}