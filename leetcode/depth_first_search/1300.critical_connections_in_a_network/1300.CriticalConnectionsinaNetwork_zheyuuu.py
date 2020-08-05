# Source : https://leetcode.com/problems/critical-connections-in-a-network
# Author : zheyuuu
# Date   : 2020-08-05

##################################################################################################### 
#
# There are n servers numbered from 0 to n-1 connected by undirected server-to-server connections 
# forming a network where connections[i] = [a, b] represents a connection between servers a and b. 
# Any server can reach any other server directly or indirectly through the network.
# 
# A critical connection is a connection that, if removed, will make some server unable to reach some 
# other server.
# 
# Return all critical connections in the network in any order.
# 
# Example 1:
# 
# Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
# Output: [[1,3]]
# Explanation: [[3,1]] is also accepted.
# 
# Constraints:
# 
# 	1 <= n <= 10^5
# 	n-1 <= connections.length <= 10^5
# 	connections[i][0] != connections[i][1]
# 	There are no repeated connections.
#####################################################################################################

class Solution:
    def criticalConnections(self, n: int, connections: List[List[int]]) -> List[List[int]]:
        minRank = [-1 for _ in range(n)]
        ans = []
        g = collections.defaultdict(set)
        for u,v in connections:
            g[u].add(v)
            g[v].add(u)
        vis = [0 for i in range(n)]
        def dfs(cur, par, rank, g, vis, minRank):
            minRank[cur] = rank+1
            vis[cur] = 1
            for child in g[cur]:
                if child==par:
                    continue
                elif not vis[child]:
                    minRank[cur] = min(minRank[cur], dfs(child, cur, rank+1, g, vis, minRank))
                else:
                    minRank[cur] = min(minRank[cur], minRank[child])
            # 经过探索未修改当前深度，则说明(par, cur)是critical point
            if minRank[cur] ==rank+1 and cur!=0:
                ans.append([par, cur])
            return minRank[cur]
                    
        dfs(0, -1, 0, g, vis, minRank)
        return ans