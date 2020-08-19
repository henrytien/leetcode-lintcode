#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-18 11:30:12
LastEditor: John
LastEditTime: 2020-08-18 11:47:33
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
# Author : JohnJim0816
# Date   : 2020-08-18

##################################################################################################### 
#
# Given the head of a singly linked list where elements are sorted in ascending order, convert it to 
# a height balanced BST.
# 
# For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of 
# the two subtrees of every node never differ by more than 1.
# 
# Example 1:
# 
# Input: head = [-10,-3,0,5,9]
# Output: [0,-3,9,-10,null,5]
# Explanation: One possible answer is [0,-3,9,-10,null,5], which represents the shown height balanced 
# BST.
# 
# Example 2:
# 
# Input: head = []
# Output: []
# 
# Example 3:
# 
# Input: head = [0]
# Output: [0]
# 
# Example 4:
# 
# Input: head = [1,3]
# Output: [3,1]
# 
# Constraints:
# 
# 	The numner of nodes in head is in the range [0, 2 * 10^4].
# 	-10^5 <= Node.val <= 10^5
#####################################################################################################

class Solution:
    '''先转有序数组，再转成BST
    '''
    def arrayToBST(self, nums: List[int]) -> TreeNode:
        if not nums: return None
        mid = (len(nums) - 1) // 2
        root = TreeNode(nums[mid])
        root.left = self.arrayToBST(nums[:mid])
        root.right = self.arrayToBST(nums[mid + 1:])
        return root
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        arr = []
        while head:
            arr.append(head.val)
            head = head.next
        return self.arrayToBST(arr)

class Solution:
    ''' 分治+中序遍历优化
    '''
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        def getLength(head: ListNode) -> int:
            ret = 0
            while head:
                ret += 1
                head = head.next
            return ret
        
        def buildTree(left: int, right: int) -> TreeNode:
            if left > right:
                return None
            mid = (left + right + 1) // 2
            root = TreeNode()
            root.left = buildTree(left, mid - 1)
            nonlocal head
            root.val = head.val
            head = head.next
            root.right = buildTree(mid + 1, right)
            return root
        
        length = getLength(head)
        return buildTree(0, length - 1)

