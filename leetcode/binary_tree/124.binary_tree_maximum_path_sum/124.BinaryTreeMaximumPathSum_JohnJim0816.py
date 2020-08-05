#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-04 10:02:52
LastEditor: John
LastEditTime: 2020-08-04 10:03:03
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/binary-tree-maximum-path-sum/
# Author : JohnJim0816
# Date   : 2020-08-04

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
    def __init__(self):
        self.maxSum = float("-inf")

    def maxPathSum(self, root: TreeNode) -> int:
        def maxGain(node):
            if not node:
                return 0

            # 递归计算左右子节点的最大贡献值
            # 只有在最大贡献值大于 0 时，才会选取对应子节点
            leftGain = max(maxGain(node.left), 0)
            rightGain = max(maxGain(node.right), 0)
            
            # 节点的最大路径和取决于该节点的值与该节点的左右子节点的最大贡献值
            priceNewpath = node.val + leftGain + rightGain
            
            # 更新答案
            self.maxSum = max(self.maxSum, priceNewpath)
        
            # 返回节点的最大贡献值
            return node.val + max(leftGain, rightGain)
   
        maxGain(root)
        return self.maxSum