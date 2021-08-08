// Source : https://leetcode.com/problems/merge-k-sorted-lists/
// Author : Kris
// Date   : 2020-10-08

/***************************************************************************************************** 
 *
 * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * Example 1:
 * 
 * Input: lists = [[1,4,5],[1,3,4],[2,6]]
 * Output: [1,1,2,3,4,4,5,6]
 * Explanation: The linked-lists are:
 * [
 *   1->4->5,
 *   1->3->4,
 *   2->6
 * ]
 * merging them into one sorted list:
 * 1->1->2->3->4->4->5->6
 * 
 * Example 2:
 * 
 * Input: lists = []
 * Output: []
 * 
 * Example 3:
 * 
 * Input: lists = [[]]
 * Output: []
 * 
 * Constraints:
 * 
 * 	k == lists.length
 * 	0 <= k <= 10^4
 * 	0 <= lists[i].length <= 500
 * 	-10^4 <= lists[i][j] <= 10^4
 * 	lists[i] is sorted in ascending order.
 * 	The sum of lists[i].length won't exceed 10^4.
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
    // O(Nlogk): devide and conquer (merge sort)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        return mergeSort(lists, 0, lists.length - 1);
    }
    
    ListNode mergeSort(ListNode[] lists, int start, int end) {
        if (start == end) {
            return lists[start];
        }
        
        var mid = (start + end) / 2;
        
        var left = mergeSort(lists, start, mid);
        var right = mergeSort(lists, mid + 1, end);
        return mergeTwoSortedList(left, right);
    }
    
    // O(Nlogk): merge every 2 lists
    public ListNode mergeKLists_mergeByTwo(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        var newList = new ArrayList<ListNode>();
        for (var node : lists) {
            if (node != null) {
                newList.add(node);
            }
        }
        
        while (newList.size() > 1) {
            var nextList = new ArrayList<ListNode>();
            for (var i = 0; i < newList.size() - 1; i += 2) {
                nextList.add(mergeTwoSortedList(newList.get(i), newList.get(i + 1)));
            }
            
            if (newList.size() % 2 == 1) {
                nextList.add(newList.get(newList.size() - 1));
            }
            
            newList = nextList;
        }
        
        // [[]]
        return newList.size() > 0 ? newList.get(0) : null;
    }
    
    ListNode mergeTwoSortedList(ListNode a, ListNode b) {
        var dummy = new ListNode();
        var tmp = dummy;
        
        while (a != null && b != null) {
            if (a.val < b.val) {
                tmp.next = a;
                tmp = tmp.next;
                a = a.next;
            } else {
                tmp.next = b;
                tmp = tmp.next;
                b = b.next;
            }
        }
        
        if (a != null) {
            tmp.next = a;
        }
        
        if (b != null) {
            tmp.next = b;
        }
        
        return dummy.next;
    }
    
    // O(Nlogk) 
    public ListNode mergeKLists_heap(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        
        var queue = new PriorityQueue<ListNode>(lists.length, (a, b) -> a.val - b.val);
        
        for (var node : lists) {
            if (node != null) {
                queue.offer(node);
            }
        }
        
        var dummy = new ListNode();
        var tmp = dummy;
        while (!queue.isEmpty()) {
            var cur = queue.poll();
            tmp.next = cur;
            tmp = tmp.next;
            
            if (cur.next != null) {
                queue.offer(cur.next);
            }
        }
        
        return dummy.next;
    }
}