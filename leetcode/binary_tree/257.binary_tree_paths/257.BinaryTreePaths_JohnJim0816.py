#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-09-04 07:04:49
LastEditor: John
LastEditTime: 2020-09-04 07:07:48
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/binary-tree-paths/
# Author : JohnJim0816
# Date   : 2020-09-04

##################################################################################################### 
#
# Given a binary tree, return all root-to-leaf paths.
# 
# Note: A leaf is a node with no children.
# 
# Example:
# 
# Input:
# 
#    1
#  /   \
# 2     3
#  \
#   5
# 
# Output: ["1->2->5", "1->3"]
# 
# Explanation: All root-to-leaf paths are: 1->2->5, 1->3
#####################################################################################################

class Solution:
    def binaryTreePaths(self, root):
        """
        :type root: TreeNode
        :rtype: List[str]
        """
        def dfs(root, path):
            if root:                    #当前节点存在
                path += str(root.val)   #当前节点的值加入路径中
                if not root.left and not root.right:    #叶子节点，将路径加入返回值
                    res.append(path)
                else:
                    path += "->"        #非叶子节点，继续递归添加
                    dfs(root.left, path)
                    dfs(root.right, path)
        res = []
        dfs(root, "")
        return res

class Solution:
    '''BFS
    '''
    def binaryTreePaths(self, root: TreeNode) -> List[str]:
        paths = list()
        if not root: # 如果树为空
            return paths

        node_queue = collections.deque([root])
        path_queue = collections.deque([str(root.val)])

        while node_queue:
            node = node_queue.popleft()
            path = path_queue.popleft()

            if not node.left and not node.right:
                paths.append(path)
            else:
                if node.left:
                    node_queue.append(node.left)
                    path_queue.append(path + '->' + str(node.left.val))
                
                if node.right:
                    node_queue.append(node.right)
                    path_queue.append(path + '->' + str(node.right.val))
        return paths