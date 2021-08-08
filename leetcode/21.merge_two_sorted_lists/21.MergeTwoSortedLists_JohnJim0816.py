#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-30 21:58:05
@LastEditor: John
@LastEditTime: 2020-07-30 21:58:15
@Discription: 
@Environment: 
'''
# Source : https://leetcode.com/problems/merge-two-sorted-lists/
# Author : JohnJim0816
# Date   : 2020-07-30

##################################################################################################### 
#
# Merge two sorted linked lists and return it as a new sorted list. The new list should be made by 
# splicing together the nodes of the first two lists.
# 
# Example:
# 
# Input: 1->2->4, 1->3->4
# Output: 1->1->2->3->4->4
#####################################################################################################

class Solution:
    def mergeTwoLists(self, l1: ListNode, l2: ListNode) -> ListNode:
        '''迭代
        '''
        prehead = ListNode(-1)
        prev = prehead # 指针
        while l1 and l2:
            if l1.val <= l2.val:
                prev.next = l1
                l1 = l1.next
            else:
                prev.next = l2
                l2 = l2.next
            prev = prev.next
        prev.next = l1 if l1 is not None else l2

        return prehead.next