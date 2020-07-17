# https://leetcode.com/problems/maximum-depth-of-binary-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def maxDepth(self, root: TreeNode) -> int:
        # left_depth, right_depth = 0,0
        # if root:
        #     left_depth = self.maxDepth(root.left) + 1
        #     right_depth = self.maxDepth(root.right) + 1
        # return max(left_depth, right_depth)
        return 1 + max(self.maxDepth(root.left), self.maxDepth(root.right)) if root else 0
