// Source : https://leetcode.com/problems/count-submatrices-with-all-ones/
// Author : henrytien
// Date   : 2022-02-04

/*****************************************************************************************************
 *
 * Given an m x n binary matrix mat, return the number of submatrices that have all ones.
 *
 * Example 1:
 *
 * Input: mat = [[1,0,1],[1,1,0],[1,1,0]]
 * Output: 13
 * Explanation:
 * There are 6 rectangles of side 1x1.
 * There are 2 rectangles of side 1x2.
 * There are 3 rectangles of side 2x1.
 * There is 1 rectangle of side 2x2.
 * There is 1 rectangle of side 3x1.
 * Total number of rectangles = 6 + 2 + 3 + 1 + 1 = 13.
 *
 * Example 2:
 *
 * Input: mat = [[0,1,1,0],[0,1,1,1],[1,1,1,0]]
 * Output: 24
 * Explanation:
 * There are 8 rectangles of side 1x1.
 * There are 5 rectangles of side 1x2.
 * There are 2 rectangles of side 1x3.
 * There are 4 rectangles of side 2x1.
 * There are 2 rectangles of side 2x2.
 * There are 2 rectangles of side 3x1.
 * There is 1 rectangle of side 3x2.
 * Total number of rectangles = 8 + 5 + 2 + 4 + 2 + 2 + 1 = 24.
 *
 * Constraints:
 *
 * 	1 <= m, n <= 150
 * 	mat[i][j] is either 0 or 1.
 ******************************************************************************************************/

#include "../inc/ac.h"
// DP 
// T: O(m^2*n)
class Solution
{
public:
    int numSubmat(vector<vector<int>> &mat)
    {
        if (mat.size() == 0)
        {
            return 0;
        }

        int m = mat.size(), n = mat[0].size();
        vector<vector<int>> dp(m, vector<int>(n, 0));
        int result = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (j == 0)
                    dp[i][j] = mat[i][j];
                else if (mat[i][j] == 1)
                {
                    dp[i][j] = dp[i][j - 1] + 1;
                }
            }
        }

        // From left to right
        for (int j = 0; j < n; j++)
        {
            // From top to bottom
            for (int i = 0; i < m; i++)
            {
                int minm = dp[i][j];
                // From i to top
                for (int k = i; k >= 0; k--)
                {
                    minm = min(minm, dp[k][j]);
                    if (minm == 0)
                        break;
                    result += minm;
                }
            }
        }
        return result;
    }
};

// DFS
// T:O(m^2 x n^2)
class Solution1
{
public:
    int numSubmat(vector<vector<int>> &mat)
    {

        int m = mat.size();
        int n = mat[0].size();
        int count = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                count += helper(mat, i, j);
            }
        }
        return count;
    }

private:
    int helper(vector<vector<int>> &mat, int a, int b)
    {
        int m = mat.size();
        int n = mat[0].size();
        int count = 0;
        for (int i = a; i < m; i++)
        {
            for (int j = b; j < n; j++)
            {
                if (mat[i][j])
                    ++count;
                else
                    n = j;
            }
        }
        return count;
    }
};

int main()
{
    vector<vector<int>> mat{{1, 0, 1}, {1, 1, 0}, {1, 1, 0}};
    cout << Solution().numSubmat(mat) << "\n";
    return 0;
}
