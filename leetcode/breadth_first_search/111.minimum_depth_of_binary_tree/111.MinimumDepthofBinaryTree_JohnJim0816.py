#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-21 09:44:10
LastEditor: John
LastEditTime: 2020-08-21 09:48:31
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/minimum-depth-of-binary-tree/
# Author : JohnJim0816
# Date   : 2020-08-21

##################################################################################################### 
#
# Given a binary tree, find its minimum depth.
# 
# The minimum depth is the number of nodes along the shortest path from the root node down to the 
# nearest leaf node.
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
# return its minimum depth = 2.
#####################################################################################################

class Solution:
    ''' DFS
    '''
    def minDepth(self, root: TreeNode) -> int:
        if not root: return 0
        if not root.left and not root.right: return 1
        left_depth = self.minDepth(root.left)
        right_depth = self.minDepth(root.right)
        if not root.left or not root.right: return left_depth+right_depth+1
        return min(left_depth,right_depth)
        
class Solution:
    ''' BFS
    '''
    def minDepth(self, root: TreeNode) -> int:
        if not root:
            return 0
        que = collections.deque([(root, 1)])
        while que:
            node, depth = que.popleft()
            if not node.left and not node.right:
                return depth
            if node.left:
                que.append((node.left, depth + 1))
            if node.right:
                que.append((node.right, depth + 1))