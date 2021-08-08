#!/usr/bin/env python
# coding=utf-8
'''
Author: John
Email: johnjim0816@gmail.com
Date: 2020-08-05 09:55:43
LastEditor: John
LastEditTime: 2020-08-05 09:55:56
Discription: 
Environment: 
'''
# Source : https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
# Author : JohnJim0816
# Date   : 2020-08-05

##################################################################################################### 
#
# Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct 
# numbers from the original list.
# 
# Return the linked list sorted as well.
# 
# Example 1:
# 
# Input: 1->2->3->3->4->4->5
# Output: 1->2->5
# 
# Example 2:
# 
# Input: 1->1->1->2->3
# Output: 2->3
#####################################################################################################

class Solution(object):
    def deleteDuplicates(self, head):
        if not (head and head.next):
            return head
        dummy = ListNode(-1)
        dummy.next = head
        a = dummy
        b = head
        while b and b.next:
            # 初始化的时a指向的是哑结点，所以比较逻辑应该是a的下一个节点和b的下一个节点
            if a.next.val!=b.next.val:
                a = a.next
                b = b.next
            else:
                # 如果a、b指向的节点值相等，就不断移动b，直到a、b指向的值不相等 
                while b and b.next and a.next.val==b.next.val:
                    b = b.next
                a.next = b.next
                b = b.next
        return dummy.next