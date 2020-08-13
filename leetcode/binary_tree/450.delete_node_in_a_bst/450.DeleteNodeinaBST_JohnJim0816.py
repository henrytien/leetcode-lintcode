#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-13 10:31:34
LastEditor: John
LastEditTime: 2020-08-13 10:31:53
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/delete-node-in-a-bst/
# Author : JohnJim0816
# Date   : 2020-08-13

##################################################################################################### 
#
# Given a root node reference of a BST and a key, delete the node with the given key in the BST. 
# Return the root node reference (possibly updated) of the BST.
# 
# Basically, the deletion can be divided into two stages:
# 
# Search for a node to remove.
# If the node is found, delete the node.
# 
# Note: Time complexity should be O(height of tree).
# 
# Example:
# 
# root = [5,3,6,2,4,null,7]
# key = 3
# 
#     5
#    / \
#   3   6
#  / \   \
# 2   4   7
# 
# Given key to delete is 3. So we find the node with value 3 and delete it.
# 
# One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
# 
#     5
#    / \
#   4   6
#  /     \
# 2       7
# 
# Another valid answer is [5,2,6,null,4,null,7].
# 
#     5
#    / \
#   2   6
#    \   \
#     4   7
# 
#####################################################################################################

# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, x):
#         self.val = x
#         self.left = None
#         self.right = None

class Solution:
    def deleteNode(self, root: TreeNode, key: int) -> TreeNode:
        if not root:
            return None
        # 当前节点值比key小，则需要删除当前节点的左子树中key对应的值，并保证二叉搜索树的性质不变
        if key < root.val:
            root.left = self.deleteNode(root.left,key)
        # 当前节点值比key大，则需要删除当前节点的右子树中key对应的值，并保证二叉搜索树的性质不变
        elif key > root.val:
            root.right = self.deleteNode(root.right,key)
        # 当前节点等于key，则需要删除当前节点，并保证二叉搜索树的性质不变
        else:
            
            # 当前节点没有左子树
            if not root.left and root.right:
                return root.right
            # 当前节点没有右子树
            elif not root.right and root.left:
                return root.left
            # 当前节点既有左子树又有右子树
            elif root.left and root.right:
                right = root.right
                r = right
                while right.left:
                    right = right.left
                right.left = root.left
                return r
            else: 
                return None
        return root
