#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-18 08:53:10
@LastEditor: John
@LastEditTime: 2020-07-18 08:54:33
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
    '''利用栈遍历
    '''
    def inorderTraversal(self, root: TreeNode) -> List[int]:
        stack,rst = [root],[]
        while stack:
            i = stack.pop()
            if isinstance(i,TreeNode):
                stack.extend([i.right,i.val,i.left])
                # stack.extend([i.right,i.left，i.val]) # 前序遍历
                # stack.extend([i.val,i.right,i.left]) # 后序遍历
            elif isinstance(i,int):
                rst.append(i)
        return rst