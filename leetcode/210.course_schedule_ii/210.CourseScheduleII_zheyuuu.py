# Source : https://leetcode.com/problems/course-schedule-ii
# Author : zheyuuu
# Date   : 2020-07-30

##################################################################################################### 
#
# There are a total of n courses you have to take, labeled from 0 to n-1.
# 
# Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
# which is expressed as a pair: [0,1]
# 
# Given the total number of courses and a list of prerequisite pairs, return the ordering of courses 
# you should take to finish all courses.
# 
# There may be multiple correct orders, you just need to return one of them. If it is impossible to 
# finish all courses, return an empty array.
# 
# Example 1:
# 
# Input: 2, [[1,0]] 
# Output: [0,1]
# Explanation: There are a total of 2 courses to take. To take course 1 you should have finished   
#              course 0. So the correct course order is [0,1] .
# 
# Example 2:
# 
# Input: 4, [[1,0],[2,0],[3,1],[3,2]]
# Output: [0,1,2,3] or [0,2,1,3]
# Explanation: There are a total of 4 courses to take. To take course 3 you should have finished both 
#     
#              courses 1 and 2. Both courses 1 and 2 should be taken after you finished course 0. 
#              So one correct course order is [0,1,2,3]. Another correct ordering is [0,2,1,3] .
# 
# Note:
# 
# 	The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
# Read more about how a graph is represented.
# 	You may assume that there are no duplicate edges in the input prerequisites.
# 
#####################################################################################################

class Solution:
    def findOrder(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        n = numCourses
        indegree = [0 for _ in range(n)]
        mat = collections.defaultdict(list)
        for u,v in prerequisites:
            indegree[u] +=1

            mat[v].append(u)
        q = [i for i,v in enumerate(indegree) if v==0]
        ans = []
        while(q):
            u = q.pop(0)
            ans.append(u)
            for v in mat[u]:
                indegree[v] -= 1
                if indegree[v]==0:
                    q.append(v)
        if len(ans)!=n:
            return []
        return ans
                
            
            
        