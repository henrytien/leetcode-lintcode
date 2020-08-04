#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-04 09:21:58
LastEditor: John
LastEditTime: 2020-08-04 09:22:14
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/balanced-binary-tree/
# Author : JohnJim0816
# Date   : 2020-08-04

##################################################################################################### 
#
# Given a binary tree, determine if it is height-balanced.
# 
# For this problem, a height-balanced binary tree is defined as:
# 
# a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
# 
# Example 1:
# 
# Given the following tree [3,9,20,null,null,15,7]:
# 
#     3
#    / \
#   9  20
#     /  \
#    15   7
# 
# Return true.
# 
# Example 2:
# 
# Given the following tree [1,2,2,3,3,null,null,4,4]:
# 
#        1
#       / \
#      2   2
#     / \
#    3   3
#   / \
#  4   4
# 
# Return false.
#####################################################################################################

class Solution:
    # Return whether or not the tree at root is balanced while also returning
    # the tree's height
    def isBalancedHelper(self, root: TreeNode) -> (bool, int):
        # An empty tree is balanced and has height -1
        if not root:
            return True, -1
        
        # Check subtrees to see if they are balanced. 
        leftIsBalanced, leftHeight = self.isBalancedHelper(root.left)
        if not leftIsBalanced:
            return False, 0
        rightIsBalanced, rightHeight = self.isBalancedHelper(root.right)
        if not rightIsBalanced:
            return False, 0
        
        # If the subtrees are balanced, check if the current tree is balanced
        # using their height
        return (abs(leftHeight - rightHeight) < 2), 1 + max(leftHeight, rightHeight)
        
    def isBalanced(self, root: TreeNode) -> bool:
        return self.isBalancedHelper(root)[0]