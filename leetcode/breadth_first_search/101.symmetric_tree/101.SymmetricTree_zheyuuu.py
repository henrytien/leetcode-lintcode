# Source : https://leetcode.com/problems/symmetric-tree/
# Author : zheyuuu
# Date   : 2020-07-29

##################################################################################################### 
#
# Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
# 
# For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
# 
#     1
#    / \
#   2   2
#  / \ / \
# 3  4 4  3
# 
# But the following [1,2,2,null,3,null,3] is not:
# 
#     1
#    / \
#   2   2
#    \   \
#    3    3
# 
# Follow up: Solve it both recursively and iteratively.
#####################################################################################################

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right

class Solution:
    def isSymmetric(self, root: TreeNode) -> bool:
        if not root or (not root.left and not root.right):
            return True
        # return self.dfs(root.left, root.right)
        return self.bfs(root)
    
    def dfs(self, left, right):
        if not left and not right:
            return True
        if not left or not right:
            return False
        return left.val==right.val and self.dfs(left.left,right.right) and self.dfs(left.right,right.left)
    
    def bfs(self, root):
        q = [root.left, root.right]
        while(q):
            left = q.pop(0)
            right = q.pop(0)
            if not (left and right) or not left.val==right.val:
                return False
            if (left.left and not right.right) or (not left.left and right.right) or (left.right and not right.left) or (not left.right and right.left):
                return False
            if left.left:
                q.append(left.left)
                q.append(right.right)
            if left.right:
                q.append(left.right)
                q.append(right.left)
        return True