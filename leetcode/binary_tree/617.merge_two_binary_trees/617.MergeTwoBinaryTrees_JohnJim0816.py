#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-30 09:56:11
LastEditor: John
LastEditTime: 2020-08-30 09:56:34
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/merge-two-binary-trees/
# Author : JohnJim0816
# Date   : 2020-08-30

##################################################################################################### 
#
# Given two binary trees and imagine that when you put one of them to cover the other, some nodes of 
# the two trees are overlapped while the others are not.
# 
# You need to merge them into a new binary tree. The merge rule is that if two nodes overlap, then 
# sum node values up as the new value of the merged node. Otherwise, the NOT null node will be used 
# as the node of new tree.
# 
# Example 1:
# 
# Input: 
# 	Tree 1                     Tree 2                  
#           1                         2                             
#          / \                       / \                            
#         3   2                     1   3                        
#        /                           \   \                      
#       5                             4   7                  
# Output: 
# Merged tree:
# 	     3
# 	    / \
# 	   4   5
# 	  / \   \ 
# 	 5   4   7
# 
# Note: The merging process must start from the root nodes of both trees.
#####################################################################################################

class Solution:
    '''dfs
    '''
    def mergeTrees(self, t1: TreeNode, t2: TreeNode) -> TreeNode:
        if not (t1 and t2): # 如果两者叶结点只要有一个是null
            return t1 if t1 else t2
        t1.val += t2.val
        t1.left = self.mergeTrees(t1.left,t2.left)
        t1.right = self.mergeTrees(t1.right,t2.right)
        return t1