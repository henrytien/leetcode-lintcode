#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-29 21:24:55
@LastEditor: John
@LastEditTime: 2020-07-29 21:25:23
@Discription: 
@Environment: 
'''
# Source : https://leetcode.com/problems/maximum-depth-of-binary-tree/
# Author : JohnJim0816
# Date   : 2020-07-29

##################################################################################################### 
#
# Given a binary tree, find its maximum depth.
# 
# The maximum depth is the number of nodes along the longest path from the root node down to the 
# farthest leaf node.
# 
# Note: A leaf is a node with no children.
# 
# Example:
# 
# Given binary tree [3,9,20,null,null,15,7],
# 
#     3
#    / \
#   9  20
#     /  \
#    15   7
# 
# return its depth = 3.
#####################################################################################################
class Solution:
    '''DFS
    '''
    def maxDepth(self, root: TreeNode) -> int:
        if not root: return 0
        return max(self.maxDepth(root.left), self.maxDepth(root.right)) + 1
