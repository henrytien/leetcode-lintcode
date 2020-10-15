// Source : https://leetcode.com/problems/odd-even-linked-list/
// Author : Kris
// Date   : 2020-10-15

/***************************************************************************************************** 
 *
 * Given a singly linked list, group all odd nodes together followed by the even nodes. Please note 
 * here we are talking about the node number and not the value in the nodes.
 * 
 * You should try to do it in place. The program should run in O(1) space complexity and O(nodes) time 
 * complexity.
 * 
 * Example 1:
 * 
 * Input: 1->2->3->4->5->NULL
 * Output: 1->3->5->2->4->NULL
 * 
 * Example 2:
 * 
 * Input: 2->1->3->5->6->4->7->NULL
 * Output: 2->3->6->7->1->5->4->NULL
 * 
 * Constraints:
 * 
 * 	The relative order inside both the even and odd groups should remain as it was in the input.
 * 	The first node is considered odd, the second node even and so on ...
 * 	The length of the linked list is between [0, 10^4].
 ******************************************************************************************************/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        var odd = new ListNode();
        var even = new ListNode();
        var oddCur = odd;
        var evenCur = even;
        
        var isOdd = true;
        while (head != null) {
            var next = head.next;
            head.next = null; // 将元素从链表上取下
            
            if (isOdd) {
                oddCur.next = head;
                oddCur = oddCur.next;
            } else {
                evenCur.next = head;
                evenCur = evenCur.next;
            }
            
            head = next;
            isOdd = !isOdd;
        }
        
        oddCur.next = even.next;
        
        return odd.next;
    }
}