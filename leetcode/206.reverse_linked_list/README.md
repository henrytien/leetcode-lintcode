# [206. Reverse Linked List](https://leetcode.com/problems/reverse-linked-list/)

## Solution

The solution from [leetcode](https://leetcode.com/problems/reverse-linked-list/solution/).

------

#### Approach #1 (Iterative) [Accepted]

Assume that we have linked list `1 → 2 → 3 → Ø`, we would like to change it to `Ø ← 1 ← 2 ← 3`.

While you are traversing the list, change the current node's next pointer to point to its previous element. Since a node does not have reference to its previous node, you must store its previous element beforehand. You also need another pointer to store the next node before changing the reference. Do not forget to return the new head reference at the end!

```c++
class Solution
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
```

**Complexity analysis**

- Time complexity : O(n)*O*(*n*). Assume that n*n* is the list's length, the time complexity is O(n)*O*(*n*).
- Space complexity : O(1)*O*(1).

#### Approach #2 (Recursive) [Accepted]

The recursive version is slightly trickier and the key is to work backwards. Assume that the rest of the list had already been reversed, now how do I reverse the front part? Let's assume the list is: n1 → … → nk-1 → nk → nk+1 → … → nm → Ø

Assume from node nk+1 to nm had been reversed and you are at node nk.

n1 → … → nk-1 → **nk** → nk+1 ← … ← nm

We want nk+1’s next node to point to nk.

So,

nk.next.next = nk;

Be very careful that n1's next must point to Ø. If you forget about this, your linked list has a cycle in it. This bug could be caught if you test your code with a linked list of size 2.

```c++
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
```

**Complexity analysis**

- Time complexity : O(n)*O*(*n*). Assume that n*n* is the list's length, the time complexity is O(n)*O*(*n*).
- Space complexity : O(n)*O*(*n*). The extra space comes from implicit stack space due to recursion. The recursion could go up to n*n* levels deep.



> List: 1 --> 2 --> 3 --> 4 --> NULL
> 1st recursion: head = 1, p = ?
> 2nd recursion: head = 2, p = ?
> 3rd recursion: head = 3, p = ?
> 4th recursion:
> head = 4, since head->next == NULL, return head
>
> 
>
> Back to the 3rd recursion:
> head = 3, p = 4
>
> 
>
> head->next->next = head; we can understand it part by part,
>
> 
>
> head->next is 4
> head->next->next = head is like 4->next = 3, set value of 4 point to equal to 3, so 4 --> 3
> head->next = null; 4 --> 3 --> NULL
> return p;