# Source : https://leetcode.com/problems/course-schedule/
# Author : yhwhu
# Date   : 2020-07-31

##################################################################################################### 
#
# There are a total of numCourses courses you have to take, labeled from 0 to numCourses-1.
# 
# Some courses may have prerequisites, for example to take course 0 you have to first take course 1, 
# which is expressed as a pair: [0,1]
# 
# Given the total number of courses and a list of prerequisite pairs, is it possible for you to 
# finish all courses?
# 
# Example 1:
# 
# Input: numCourses = 2, prerequisites = [[1,0]]
# Output: true
# Explanation: There are a total of 2 courses to take. 
#              To take course 1 you should have finished course 0. So it is possible.
# 
# Example 2:
# 
# Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
# Output: false
# Explanation: There are a total of 2 courses to take. 
#              To take course 1 you should have finished course 0, and to take course 0 you should
#              also have finished course 1. So it is impossible.
# 
# Constraints:
# 
# 	The input prerequisites is a graph represented by a list of edges, not adjacency matrices. 
# Read more about how a graph is represented.
# 	You may assume that there are no duplicate edges in the input prerequisites.
# 	1 <= numCourses <= 10^5
#####################################################################################################


class Solution:
    def canFinish_bfs(self, numCourses: int, prerequisites: List[List[int]]) -> bool:
        in_degrees = [0 for _ in range(numCourses)]
        adjacency = [[] for _ in range(numCourses)]

        for cur, pre in prerequisites:
            in_degrees[cur] += 1
            adjacency[pre].append(cur)

        queue = []
        for i in range(numCourses):
            if not in_degrees[i]:
                queue.append(i)

        while queue:
            pre = queue.pop(0)
            numCourses -= 1
            for cur in adjacency[pre]:
                in_degrees[cur] -= 1
                if not in_degrees[cur]:
                    queue.append(cur)

        return not numCourses