#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-29 21:21:47
@LastEditor: John
@LastEditTime: 2020-07-29 21:22:09
@Discription: 
@Environment: 
'''
# Source : https://leetcode.com/problems/invert-binary-tree/
# Author : JohnJim0816
# Date   : 2020-07-29

##################################################################################################### 
#
# Invert a binary tree.
# 
# Example:
# 
# Input:
# 
#      4
#    /   \
#   2     7
#  / \   / \
# 1   3 6   9
# 
# Output:
# 
#      4
#    /   \
#   7     2
#  / \   / \
# 9   6 3   1
# 
# Trivia:
# This problem was inspired by this original tweet by Max Howell:
# 
# Google: 90% of our engineers use the software you wrote (Homebrew), but you can&rsquo;t invert a 
# binary tree on a whiteboard so f*** off.
#####################################################################################################

class Solution:
    ''' 递归
    '''
    def mirrorTree(self, root: TreeNode) -> TreeNode:
        if not root:
            return None
        root.left, root.right = self.mirrorTree(root.right), self.mirrorTree(root.left)
        return root