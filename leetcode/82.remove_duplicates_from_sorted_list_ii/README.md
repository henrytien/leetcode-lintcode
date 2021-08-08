# [82. Remove Duplicates from Sorted List II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/)

一个失败的解法如下，类似于双指针：

```python
class Solution:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        dummy_head = ListNode(None)
        dummy_head.next = ListNode(None)
        dummy_head.next.next=head
        p_pre = dummy_head
        pre = dummy_head.next
        cur = head
        repeat = False
        while cur:
            if  cur.val == pre.val:
                repeat = True
                pre.next = cur.next
                cur.next = None # 清除野指针
                cur = pre.next
                continue
            elif cur.val != pre.val and repeat == True:
                repeat = False
                pre = p_pre
                pre.next = cur.next
                cur.next = None # 清除野指针
                cur = pre.next
                continue
            
            p_pre = pre
            pre = cur
            cur = cur.next
        return dummy_head.next.next
```