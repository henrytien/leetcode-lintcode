// Source : https://leetcode.com/problems/binary-tree-maximum-path-sum/
// Author : zhangsl
// Date   : 2020-08-06
package main

import "math"

/*****************************************************************************************************
 *
 * Given a non-empty binary tree, find the maximum path sum.
 *
 * For this problem, a path is defined as any sequence of nodes from some starting node to any node in
 * the tree along the parent-child connections. The path must contain at least one node and does not
 * need to go through the root.
 *
 * Example 1:
 *
 * Input: [1,2,3]
 *
 *        1
 *       / \
 *      2   3
 *
 * Output: 6
 *
 * Example 2:
 *
 * Input: [-10,9,20,null,null,15,7]
 *
 *    -10
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * Output: 42
 *
 ******************************************************************************************************/

//Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

var ans = 0

func maxPathSum(root *TreeNode) int {
	if root == nil {
		return 0
	}
	ans = math.MinInt32
	helper(root)
	return ans

}
func helper(root *TreeNode) int {
	if root == nil {
		return 0
	}
	left := max(helper(root.Left),0)
	right := max(helper(root.Right),0)
	lrMax := max(left, right)
	nowSum:=left+right+root.Val
	if nowSum > ans {
		ans = nowSum
	}
	return root.Val+lrMax
}
func max(a, b int) int {
	if a <= b {
		return b
	}
	return a
}
func main() {

}
