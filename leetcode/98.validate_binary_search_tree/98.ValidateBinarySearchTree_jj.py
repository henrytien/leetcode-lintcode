#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-18 09:13:05
@LastEditor: John
@LastEditTime: 2020-07-18 09:14:00
@Discription: 
@Environment: python 3.7.7
'''

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    '''广度优先搜索
    '''
    def isValidBST(self, root):
        
        def BFS(root, left, right):
            if root is None:
                return True
            
            if left < root.val < right:
                return BFS(root.left, left, root.val) and BFS(root.right, root.val, right)
            else:
                return False

        return BFS(root, -float('inf'), float('inf'))