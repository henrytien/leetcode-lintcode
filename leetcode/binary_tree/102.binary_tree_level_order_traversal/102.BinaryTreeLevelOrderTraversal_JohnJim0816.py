#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-20 08:25:45
@LastEditor: John
@LastEditTime: 2020-07-20 08:26:44
@Discription: 
@Environment: python 3.7.7
'''
# Source : https://leetcode.com/problems/binary-tree-level-order-traversal/
# Author : JohnJim0816
# Date   : 2020-07-20

##################################################################################################### 
#
# Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to 
# right, level by level).
# 
# For example:
# Given binary tree [3,9,20,null,null,15,7],
# 
#     3
#    / \
#   9  20
#     /  \
#    15   7
# 
# return its level order traversal as:
# 
# [
#   [3],
#   [9,20],
#   [15,7]
# ]
# 
#####################################################################################################

class Solution:
    def levelOrder(self, root):
        """广度优先搜索
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        queue = collections.deque() # 使用队列先进先出
        queue.append(root)
        res = []
        while queue:
            size = len(queue)
            level = [] # 对应深度的所有值
            for _ in range(size):
                cur = queue.popleft()
                if not cur:
                    continue
                level.append(cur.val)
                queue.append(cur.left)
                queue.append(cur.right)
            if level:
                res.append(level)
        return res