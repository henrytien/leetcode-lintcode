# Source : https://leetcode.com/problems/binary-tree-right-side-view
# Author : zheyuuu
# Date   : 2020-07-29

##################################################################################################### 
#
# Given a binary tree, imagine yourself standing on the right side of it, return the values of the 
# nodes you can see ordered from top to bottom.
# 
# Example:
# 
# Input: [1,2,3,null,5,null,4]
# Output: [1, 3, 4]
# Explanation:
# 
#    1            <---
#  /   \
# 2     3         <---
#  \     \
#   5     4       <---
#####################################################################################################

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def rightSideView(self, root: TreeNode) -> List[int]:
        self.ans = []
        if not root:
            return self.ans
        self.bfs(root)
        return self.ans
        
    def bfs(self, node):
        q = [node]
        while(q):
            tmp = []
            self.ans.append(q[0].val)
            while(q):
                cur = q.pop(0)
                if cur.right:
                    tmp.append(cur.right)
                if cur.left:
                    tmp.append(cur.left)
            q = tmp
        
                
                    