#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-07-30 23:01:40
LastEditor: John
LastEditTime: 2020-08-03 10:13:24
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
# Author : JohnJim0816
# Date   : 2020-07-30

##################################################################################################### 
#
# Given a binary tree, find the lowest common ancestor (LCA) of two given nodes in the tree.
# 
# According to the definition of LCA on Wikipedia: "The lowest common ancestor is defined between two 
# nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node 
# to be a descendant of itself).&rdquo;
# 
# Given the following binary tree:  root = [3,5,1,6,2,0,8,null,null,7,4]
# 
# Example 1:
# 
# Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
# Output: 3
# Explanation: The LCA of nodes 5 and 1 is 3.
# 
# Example 2:
# 
# Input: root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
# Output: 5
# Explanation: The LCA of nodes 5 and 4 is 5, since a node can be a descendant of itself according to 
# the LCA definition.
# 
# Note:
# 
# 	All of the nodes' values will be unique.
# 	p and q are different and both values will exist in the binary tree.
# 
#####################################################################################################

class Solution:
    def lowestCommonAncestor(self, root: 'TreeNode', p: 'TreeNode', q: 'TreeNode') -> 'TreeNode':
        if not root or root == p or root == q: return root
        left = self.lowestCommonAncestor(root.left, p, q)
        right = self.lowestCommonAncestor(root.right, p, q)
        if not left and not right: return # 1.
        if not left: return right # 3.
        if not right: return left # 4.
        return root # 2. if left and right: