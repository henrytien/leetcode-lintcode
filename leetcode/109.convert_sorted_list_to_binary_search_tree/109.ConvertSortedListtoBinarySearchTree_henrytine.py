# Source : https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree/
# Author : henrytine
# Date   : 2020-08-08

#####################################################################################################
#
# Given a singly linked list where elements are sorted in ascending order, convert it to a height
# balanced BST.
#
# For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of
# the two subtrees of every node never differ by more than 1.
#
# Example:
#
# Given the sorted linked list: [-10,-3,0,5,9],
#
# One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:
#
#       0
#      / \
#    -3   9
#    /   /
#  -10  5
#
#####################################################################################################


# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def sortedListToBST(self, head: ListNode) -> TreeNode:
        if head is None:
            return None
        size = self.findSize(head)

        def helper(l, r):
            nonlocal head
            if l > r:
                return None

            mid = (l + r) // 2

            left = helper(l, mid - 1)
            node = TreeNode(head.val)
            node.left = left

            head = head.next

            node.right = helper(mid + 1, r)
            return node
        return helper(0, size - 1)

    def findSize(self, head):
        ptr = head
        c = 0
        while ptr:
            ptr = ptr.next
            c += 1
        return c
