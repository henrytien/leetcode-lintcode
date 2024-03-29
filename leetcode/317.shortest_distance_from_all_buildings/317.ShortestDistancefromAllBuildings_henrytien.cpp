// Source : https://leetcode.com/problems/shortest-distance-from-all-buildings/
// Author : henrytien
// Date   : 2022-02-05

/*****************************************************************************************************
 *
 * You are given an m x n grid grid of values 0, 1, or 2, where:

each 0 marks an empty land that you can pass by freely,
each 1 marks a building that you cannot pass through, and
each 2 marks an obstacle that you cannot pass through.
You want to build a house on an empty land that reaches all buildings in the shortest total travel
distance. You can only move up, down, left, and right.

Return the shortest travel distance for such a house. If it is not possible to build such a house
according to the above rules, return -1.

The total travel distance is the sum of the distances between the houses of the friends and the meeting point.

The distance is calculated using Manhattan Distance, where distance(p1, p2) = |p2.x - p1.x| + |p2.y - p1.y|.
 ******************************************************************************************************/

#include "../inc/ac.h"
class Solution
{
public:
    int shortestDistance(vector<vector<int>> &grid)
    {
        // Calculate every building point to landing point distance, and get the minm.
        int m = grid.size(), n = grid[0].size();
        vector<int> direction = {-1, 0, 1, 0, -1}; // left up right down
        vector<vector<int>> distance(m, vector<int>(n, 0));

        int min_dist = 0, walk = 0;
        for (int i = 0; i < m; i++)
        {
            for (int j = 0; j < n; j++)
            {
                if (grid[i][j] == 1)
                {
                    // Note this is initialized to -1, so when a building is not reachable it will be -1 at the end
                    min_dist = INT_MAX;
                    queue<pair<int, int>> que;

                    que.emplace(i, j);
                    int level = 1;
                    while (!que.empty())
                    {
                        int len = que.size();

                        for (int k = 0; k < len; k++)
                        {
                            auto curr = que.front();
                            que.pop();
                            for (int l = 0; l < 4; l++)
                            {
                                int x = curr.first + direction[l];
                                int y = curr.second + direction[l + 1];
                                if (x >= 0 && x < m && y >= 0 && y < n && walk == grid[x][y])
                                {
                                    grid[x][y]--;
                                    distance[x][y] += level;

                                    que.emplace(x, y);
                                    min_dist = min(min_dist, distance[x][y]);
                                }
                            }
                        }
                        level++;
                    }
                    walk--;
                    if (min_dist == INT_MAX)
                        return -1;
                }
            }
        }
        return min_dist;
    }
};

int main()
{

    vector<vector<int>> grid = {{1, 0, 2, 0, 1}, {0, 0, 0, 0, 0}, {0, 0, 1, 0, 0}};
    cout << Solution().shortestDistance(grid) << "\n";
    return 0;
}