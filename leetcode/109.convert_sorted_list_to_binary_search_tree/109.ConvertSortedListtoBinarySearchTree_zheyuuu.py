# Source : https://leetcode.com/problems/convert-sorted-list-to-binary-search-tree
# Author : zheyuuu
# Date   : 2020-08-06

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
        if not head:
            return None
        if not head.next:
            return TreeNode(head.val)
        # Find middle point
        fast = slow = head
        pre = None
        while(fast and fast.next):
            fast = fast.next.next
            pre = slow
            slow = slow.next
        if pre:
            pre.next = None
        node = TreeNode(slow.val)
        left = self.sortedListToBST(head)
        right = self.sortedListToBST(slow.next)
        node.left = left
        node.right = right
        return node
            
        