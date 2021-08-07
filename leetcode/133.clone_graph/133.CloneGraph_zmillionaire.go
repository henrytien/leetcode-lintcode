// Source : https://leetcode.com/problems/clone-graph/
// Author : zmillionaire
// Date   : 2020-07-30
package main

/*****************************************************************************************************
 *
 * Given a reference of a node in a connected undirected graph.
 *
 * Return a deep copy (clone) of the graph.
 *
 * Each node in the graph contains a val (int) and a list (List[Node]) of its neighbors.
 *
 * class Node {
 *     public int val;
 *     public List<Node> neighbors;
 * }
 *
 * Test case format:
 *
 * For simplicity sake, each node's value is the same as the node's index (1-indexed). For example,
 * the first node with val = 1, the second node with val = 2, and so on. The graph is represented in
 * the test case using an adjacency list.
 *
 * Adjacency list is a collection of unordered lists used to represent a finite graph. Each list
 * describes the set of neighbors of a node in the graph.
 *
 * The given node will always be the first node with val = 1. You must return the copy of the given
 * node as a reference to the cloned graph.
 *
 * Example 1:
 *
 * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
 * Output: [[2,4],[1,3],[2,4],[1,3]]
 * Explanation: There are 4 nodes in the graph.
 * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
 * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
 *
 * Example 2:
 *
 * Input: adjList = [[]]
 * Output: [[]]
 * Explanation: Note that the input contains one empty list. The graph consists of only one node with
 * val = 1 and it does not have any neighbors.
 *
 * Example 3:
 *
 * Input: adjList = []
 * Output: []
 * Explanation: This an empty graph, it does not have any nodes.
 *
 * Example 4:
 *
 * Input: adjList = [[2],[1]]
 * Output: [[2],[1]]
 *
 * Constraints:
 *
 * 	1 <= Node.val <= 100
 * 	Node.val is unique for each node.
 * 	Number of Nodes will not exceed 100.
 * 	There is no repeated edges and no self-loops in the graph.
 * 	The Graph is connected and all nodes can be visited starting from the given node.
 ******************************************************************************************************/

//Definition for a Node.
type Node struct {
	Val       int
	Neighbors []*Node
}
// 思路 就是图的遍历，由于是连通图，要加标记避免死循环
// time 100，对于图来说bfs遍历的优势是不需要函数栈(有可能爆栈)，但是写起来麻烦，
// 而dfs写起来简单，容易爆栈
//? todo @zhangshilin dfs solution
func cloneGraph(node *Node) *Node   {
//	边界检查
	if node==nil{
		return nil
	}
	vis:=make(map[*Node]*Node)
	que:=[]*Node{}
	que=append(que, node)
	vis[node] = &Node{
		Val:       node.Val,
		Neighbors: make([]*Node,0),
	}
	for len(que)!=0{
		now:=que[0]
		que = que[1:]
		for _,v:=range now.Neighbors{
			if _,ok:=vis[v];!ok{
				vis[v] = &Node{
					Val:       v.Val,
					Neighbors: make([]*Node,0),
				}
				que=append(que, v)
			}
			vis[now].Neighbors = append(vis[now].Neighbors, vis[v])
		}
	}
	return vis[node]
}
