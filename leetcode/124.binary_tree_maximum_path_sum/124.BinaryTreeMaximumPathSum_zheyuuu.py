# Source : https://leetcode.com/problems/binary-tree-maximum-path-sum
# Author : zheyuuu
# Date   : 2020-08-05

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

class Solution:
    def maxPathSum(self, root: TreeNode) -> int:
        self.ans = float("-inf")
        self.helper(root)
        return self.ans
    
    def helper(self, node):
        if not node:
            return 0
        left = self.helper(node.left)
        right = self.helper(node.right)
        lval = left if left>=0 else 0
        rval = right if right>=0 else 0
        self.ans = max(node.val+lval+rval, self.ans)
        return max(node.val+lval, node.val+rval)