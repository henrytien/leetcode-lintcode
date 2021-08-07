# Source : https://leetcode.com/problems/binary-tree-maximum-path-sum/
# Author : henrytine
# Date   : 2020-08-07

##################################################################################################### 
#
# Given a non-empty binary tree, find the maximum path sum.
# 
# For this problem, a path is defined as any sequence of nodes from some starting node to any node in 
# the tree along the parent-child connections. The path must contain at least one node and does not 
# need to go through the root.
# 
# Example 1:
# 
# Input: [1,2,3]
# 
#        1
#       / \
#      2   3
# 
# Output: 6
# 
# Example 2:
# 
# Input: [-10,9,20,null,null,15,7]
# 
#    -10
#    / \
#   9  20
#     /  \
#    15   7
# 
# Output: 42
# 
#####################################################################################################
## https://leetcode.com/problems/binary-tree-maximum-path-sum/discuss/603423/Python-Recursion-stack-thinking-process-diagram 

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        max_path = float("-inf")
        def get_max_path(node :TreeNode):
            nonlocal max_path
            if node is None:
                return 0
            
            current_max_left = max(get_max_path(node.left), 0)
            current_max_right = max(get_max_path(node.right), 0)
            
            current_max_path = node.val + current_max_left + current_max_right
            
            max_path = max(max_path, current_max_path)
            return node.val + max(current_max_left, current_max_right) 
            
            
        get_max_path(root)
        return max_path