// Source : https://leetcode.com/problems/maximum-depth-of-binary-tree/
// Author : zhangsl
// Date   : 2020-08-24
package main

/*****************************************************************************************************
 *
 * Given a binary tree, find its maximum depth.
 *
 * The maximum depth is the number of nodes along the longest path from the root node down to the
 * farthest leaf node.
 *
 * Note: A leaf is a node with no children.
 *
 * Example:
 *
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its depth = 3.
 ******************************************************************************************************/

//Definition for a binary tree node.
// 思路1. DFS
// 思路2. BFS

//time 91 mem:87
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
var ans  = 0
func max(a,b int)int{
	if a>=b{
		return a
	}
	return b
}
func maxDepth(root *TreeNode) int {
	ans = 0
	helper(root,1)
	return ans
}
func helper(root *TreeNode,dep int){
	if root== nil{
		return
	}
	ans = max(ans,dep)
	helper(root.Left,dep+1)
	helper(root.Right,dep+1)
}
