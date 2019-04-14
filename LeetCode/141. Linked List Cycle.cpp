#include"AllInclude.h"
//https://leetcode.com/problems/linked-list-cycle/
/**
* Definition for singly-linked list.
* struct ListNode {
*     int val;
*     ListNode *next;
*     ListNode(int x) : val(x), next(NULL) {}
* };
*/
class Solution {
public:
	bool hasCycle(ListNode *head) {
		if (head == NULL) return false;

		while (head->next)
		{
			if(!head->next->next)
				break;
			if (head->next == head->next->next)
				return true;
			head->next = head->next->next;
			head = head->next;
		}
		return false;
	}

	

};

void push(ListNode **head, int val) {
	ListNode *new_node = (ListNode*)malloc(sizeof(ListNode));
	new_node->val = val;
	new_node->next = *head;
	*head = new_node;
}

void print(ListNode *list)
{
	while (list != NULL)
	{
		printf("%d ", list->val);
		list = list->next;
	}
}

int main()
{
	vector<int> src = { 3,2,0,-4 };
	ListNode *list = NULL;
	for (auto &iter : src)
		push(&list, iter);
	print(list);

	cout << Solution().hasCycle(list);
	getchar();
	return 0;
}