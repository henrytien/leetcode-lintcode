// Source : https://leetcode.com/problems/reverse-linked-list/
// Author : henrytien
// Date   : 2022-02-10

/*****************************************************************************************************
 *
 * Given the head of a singly linked list, reverse the list, and return the reversed list.
 *
 * Example 1:
 *
 * Input: head = [1,2,3,4,5]
 * Output: [5,4,3,2,1]
 *
 * Example 2:
 *
 * Input: head = [1,2]
 * Output: [2,1]
 *
 * Example 3:
 *
 * Input: head = []
 * Output: []
 *
 * Constraints:
 *
 * 	The number of nodes in the list is the range [0, 5000].
 * 	-5000 <= Node.val <= 5000
 *
 * Follow up: A linked list can be reversed either iteratively or recursively. Could you implement
 * both?
 ******************************************************************************************************/

class Solution1
{
public:
    ListNode *reverseList(ListNode *head)
    {
        if (head == NULL)
        {
            return head;
        }

        ListNode *curr = head;
        ListNode *res = NULL;
        while (curr != NULL)
        {
            ListNode *temp = curr->next;
            curr->next = res;
            res = curr;
            curr = temp;
        }
        return res;
    }
};

class Solution {
public:
    ListNode* reverseList(ListNode* head) {
      if (head == NULL || head->next == NULL) return head;
      ListNode* p = reverseList(head->next);
      head->next->next = head;
      head->next = NULL;
      return p;
    }
};