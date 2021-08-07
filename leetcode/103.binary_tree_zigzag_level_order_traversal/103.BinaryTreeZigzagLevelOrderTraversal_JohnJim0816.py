#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-08-02 14:18:01
@LastEditor: John
@LastEditTime: 2020-08-02 14:18:41
@Discription: 
@Environment: 
'''
# Source : https://leetcode.com/problems/binary-tree-zigzag-level-order-traversal/
# Author : JohnJim0816
# Date   : 2020-08-02

##################################################################################################### 
#
# Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left 
# to right, then right to left for the next level and alternate between).
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
# return its zigzag level order traversal as:
# 
# [
#   [3],
#   [20,9],
#   [15,7]
# ]
# 
#####################################################################################################
class Solution:
    ''' 在102题的基础上，加上深度奇偶判断，
    '''
    def zigzagLevelOrder(self, root: TreeNode) -> List[List[int]]:
        """广度优先搜索
        :type root: TreeNode
        :rtype: List[List[int]]
        """
        queue = collections.deque() # 使用队列先进先出
        queue.append(root)
        res = []
        i=0
        while queue:
            size = len(queue)
            level = [] # 对应深度的所有值
            i+=1
            for _ in range(size):
                cur = queue.popleft()
                if not cur:
                    continue
                ## 加上深度奇偶判断
                if i%2==1:
                    level.append(cur.val)
                else:
                    level.insert(0,cur.val) # 也可以appendleft
                queue.append(cur.left)
                queue.append(cur.right)
            if level:
                res.append(level)
        return res
