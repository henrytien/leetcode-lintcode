# Source : https://leetcode.com/problems/number-of-good-leaf-nodes-pairs
# Author : zheyuuu
# Date   : 2020-08-02

##################################################################################################### 
#
# Given the root of a binary tree and an integer distance. A pair of two different leaf nodes of a 
# binary tree is said to be good if the length of the shortest path between them is less than or 
# equal to distance.
# 
# Return the number of good leaf node pairs in the tree.
# 
# Example 1:
# 
# Input: root = [1,2,3,null,4], distance = 3
# Output: 1
# Explanation: The leaf nodes of the tree are 3 and 4 and the length of the shortest path between 
# them is 3. This is the only good pair.
# 
# Example 2:
# 
# Input: root = [1,2,3,4,5,6,7], distance = 3
# Output: 2
# Explanation: The good pairs are [4,5] and [6,7] with shortest path = 2. The pair [4,6] is not good 
# because the length of ther shortest path between them is 4.
# 
# Example 3:
# 
# Input: root = [7,1,4,6,null,5,3,null,null,null,null,null,2], distance = 3
# Output: 1
# Explanation: The only good pair is [2,5].
# 
# Example 4:
# 
# Input: root = [100], distance = 1
# Output: 0
# 
# Example 5:
# 
# Input: root = [1,1,1], distance = 2
# Output: 1
# 
# Constraints:
# 
# 	The number of nodes in the tree is in the range [1, 2^10].
# 	Each node's value is between [1, 100].
# 	1 <= distance <= 10
#####################################################################################################

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def countPairs(self, root: TreeNode, distance: int) -> int:
        self.memo = {}
        self.ans = 0
        self.distance = distance
        self.dfs(root)
        return self.ans
    
    def dfs(self, node):
        if not node:
            return {}
        if not node.left and not node.right:
            return {1:1}
        left = self.dfs(node.left)
        right = self.dfs(node.right)
        now = collections.defaultdict(int)
        for lcnt,lv in left.items():
            for rcnt,rv in right.items():
                if lcnt+rcnt<=self.distance:
                    self.ans += lv*rv
        for lcnt, lv in left.items():
            if lcnt+1<self.distance:
                now[lcnt+1] += lv
        for rcnt, rv in right.items():
            if rcnt+1<self.distance:
                now[rcnt+1] += rv
        return now