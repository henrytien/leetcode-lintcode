// Source : https://leetcode.com/problems/copy-list-with-random-pointer/
// Author : zhangsl
// Date   : 2020-08-13
package main

/*****************************************************************************************************
 *
 * A linked list is given such that each node contains an additional random pointer which could point
 * to any node in the list or null.
 *
 * Return a deep copy of the list.
 *
 * The Linked List is represented in the input/output as a list of n nodes. Each node is represented
 * as a pair of [val, random_index] where:
 *
 * 	val: an integer representing Node.val
 * 	random_index: the index of the node (range from 0 to n-1) where random pointer points to,
 * or null if it does not point to any node.
 *
 * Example 1:
 *
 * Input: head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
 * Output: [[7,null],[13,0],[11,4],[10,2],[1,0]]
 *
 * Example 2:
 *
 * Input: head = [[1,1],[2,1]]
 * Output: [[1,1],[2,1]]
 *
 * Example 3:
 *
 * Input: head = [[3,null],[3,0],[3,null]]
 * Output: [[3,null],[3,0],[3,null]]
 *
 * Example 4:
 *
 * Input: head = []
 * Output: []
 * Explanation: Given linked list is empty (null pointer), so return null.
 *
 * Constraints:
 *
 * 	-10000 <= Node.val <= 10000
 * 	Node.random is null or pointing to a node in the linked list.
 * 	Number of Nodes will not exceed 1000.
 ******************************************************************************************************/

//Definition for a Node.
type Node struct {
	Val    int
	Next   *Node
	Random *Node
}
// 思路, 按照next指针遍历整个链表，对当前节点的next和random进行拷贝，并将被拷贝节点和新节点建立关联，如果在接下来的拷贝中出现了已经记录的节点，则直接使用，否则拷贝节点并建立映射关系
//time:100 mem:36.94
var mp =map[*Node]*Node{}
func copyRandomList(head *Node) *Node {
	if head==nil{
		return nil
	}
	mp = map[*Node]*Node{}
	mp[head] = &Node{head.Val,nil,nil}
	var (
		new *Node
		oldHead = head
	)
	for oldHead!=nil{
		new = mp[oldHead]
		(*new).Next = helper(oldHead.Next)
		(*new).Random = helper(oldHead.Random)
		oldHead = oldHead.Next
	}
	return mp[head]
}
func helper(node *Node)*Node{
	if node == nil{
		return nil
	}
	if v,ok:=mp[node];ok{
		return v
	}
	newNode:=&Node{node.Val,nil,nil}
	mp[node] = newNode
	return newNode
}
