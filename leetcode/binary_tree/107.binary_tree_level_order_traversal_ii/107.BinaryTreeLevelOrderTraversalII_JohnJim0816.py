#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-08-02 14:12:52
@LastEditor: John
@LastEditTime: 2020-08-02 14:13:02
@Discription: 
@Environment: 
'''
# Source : https://leetcode.com/problems/binary-tree-level-order-traversal-ii/
# Author : JohnJim0816
# Date   : 2020-08-02

##################################################################################################### 
#
# Given a binary tree, return the bottom-up level order traversal of its nodes' values. (ie, from 
# left to right, level by level from leaf to root).
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
# return its bottom-up level order traversal as:
# 
# [
#   [15,7],
#   [9,20],
#   [3]
# ]
# 
#####################################################################################################

class Solution:
    def levelOrderBottom(self, root: TreeNode) -> List[List[int]]:
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
                res.insert(0,level) # 与102题相比，就改了一下列表的插入方式
        return res
