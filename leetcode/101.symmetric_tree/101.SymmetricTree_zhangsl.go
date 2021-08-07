// Source : https://leetcode.com/problems/symmetric-tree/
// Author : zhangsl
// Date   : 2020-08-24
package main

/*****************************************************************************************************
 *
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 *
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *
 *     1
 *    / \
 *   2   2
 *  / \ / \
 * 3  4 4  3
 *
 * But the following [1,2,2,null,3,null,3] is not:
 *
 *     1
 *    / \
 *   2   2
 *    \   \
 *    3    3
 *
 * Follow up: Solve it both recursively and iteratively.
 ******************************************************************************************************/

//* Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// 思路 ，两个指针，往相反方向走就可以了，同nil true，其他false
func isSymmetric(root *TreeNode) bool {
	if root == nil {
		return true
	}
	return helper(root.Left, root.Right)
}
func helper(left *TreeNode, right *TreeNode) bool {
	if left == nil && right == nil {
		return true
	}
	if left == nil || right == nil {
		return false
	}
	if left.Val != right.Val {
		return false
	}
	return helper(left.Left, right.Right) && helper(left.Right, right.Left)

}
