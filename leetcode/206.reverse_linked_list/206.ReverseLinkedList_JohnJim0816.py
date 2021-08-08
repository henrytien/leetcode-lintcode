#!/usr/bin/env python
# coding=utf-8
'''
@Author: John
@Email: johnjim0816@gmail.com
@Date: 2020-07-30 21:54:57
@LastEditor: John
@LastEditTime: 2020-07-30 21:55:21
@Discription: 
@Environment: 
'''
# Source : https://leetcode.com/problems/reverse-linked-list/
# Author : JohnJim0816
# Date   : 2020-07-30

##################################################################################################### 
#
# Reverse a singly linked list.
# 
# Example:
# 
# Input: 1->2->3->4->5->NULL
# Output: 5->4->3->2->1->NULL
# 
# Follow up:
# 
# A linked list can be reversed either iteratively or recursively. Could you implement both?
#####################################################################################################

class Solution(object):
	def reverseList(self, head):
		"""
		:type head: ListNode
		:rtype: ListNode
		"""
		# 申请两个节点，pre和 cur，pre指向None
		pre = None
		cur = head
		# 遍历链表，while循环里面的内容其实可以写成一行
		# 这里只做演示，就不搞那么骚气的写法了
		while cur:
			# 记录当前节点的下一个节点
			tmp = cur.next
			# 然后将当前节点指向pre
			cur.next = pre
			# pre和cur节点都前进一位
			pre = cur
			cur = tmp
		return pre	