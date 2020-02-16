// https://www.lintcode.com/problem/linked-list-cycle-ii/description

// fast and slow pointer, after first meet, fast pointer from head and slow move step by step. when them meet.

/**
 * Definition of singly-linked-list:
 * class ListNode {
 * public:
 *     int val;
 *     ListNode *next;
 *     ListNode(int val) {
 *        this->val = val;
 *        this->next = NULL;
 *     }
 * }
 */

class Solution {
public:
    /**
     * @param head: The first node of linked list.
     * @return: The node where the cycle begins. if there is no cycle, return null
     */
    ListNode * detectCycle(ListNode * head) {
        ListNode *slow = head, *fast = head;
        
        while(true){
            if(fast == NULL || fast->next == NULL) return NULL;
            fast = fast->next->next;
            slow = slow->next;
            if(slow == fast) break;
        }
        
        fast = head;
        while(slow != fast){
            fast = fast->next;
            slow = slow->next;
        }
        return fast;
    }
};