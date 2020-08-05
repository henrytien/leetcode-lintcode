#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-05 09:28:47
LastEditor: John
LastEditTime: 2020-08-05 09:32:13
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/insert-into-a-binary-search-tree/
# Author : JohnJim0816
# Date   : 2020-08-05

##################################################################################################### 
#
# Given the root node of a binary search tree (BST) and a value to be inserted into the tree, insert 
# the value into the BST. Return the root node of the BST after the insertion. It is guaranteed that 
# the new value does not exist in the original BST.
# 
# Note that there may exist multiple valid ways for the insertion, as long as the tree remains a BST 
# after insertion. You can return any of them.
# 
# For example, 
# 
# Given the tree:
#         4
#        / \
#       2   7
#      / \
#     1   3
# And the value to insert: 5
# 
# You can return this binary search tree:
# 
#          4
#        /   \
#       2     7
#      / \   /
#     1   3 5
# 
# This tree is also valid:
# 
#          5
#        /   \
#       2     7
#      / \   
#     1   3
#          \
#           4
# 
# Constraints:
# 
# 	The number of nodes in the given tree will be between 0 and 10^4.
# 	Each node will have a unique integer value from 0 to -10^8, inclusive.
# 	-10^8 <= val <= 10^8
# 	It's guaranteed that val does not exist in the original BST.
#####################################################################################################

class Solution:
    ''' 递归，时O(H)空O(H)
    '''
    def insertIntoBST(self, root: TreeNode, val: int) -> TreeNode:
        if not root:
            return TreeNode(val)
        if val > root.val:
            # 插入到右子树
            root.right = self.insertIntoBST(root.right,val)
        else:
            root.left = self.insertIntoBST(root.left,val)
        return root


class Solution:
    ''' 迭代，时O(H)空O(1)
    '''
    def insertIntoBST(self, root: TreeNode, val: int) -> TreeNode:
        node = root
        while node:
            # insert into the right subtree
            if val > node.val:
                # insert right now
                if not node.right:
                    node.right = TreeNode(val)
                    return root
                else:
                    node = node.right
            # insert into the left subtree
            else:
                # insert right now
                if not node.left:
                    node.left = TreeNode(val)
                    return root
                else:
                    node = node.left
        return TreeNode(val)

