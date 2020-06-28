# https://leetcode.com/problems/minimum-depth-of-binary-tree/

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right


class Solution:
    def minDepth(self, root: TreeNode) -> int:
        left_depth, right_depth = 0, 0
        if not root:
            return 0
        left_depth, right_depth = sorted(
            map(self.minDepth, (root.left, root.right)))
        return 1 + (left_depth or right_depth)
