// Source : https://leetcode.com/problems/invert-binary-tree/
// Author : zhangsl
// Date   : 2020-08-24
package main

/*****************************************************************************************************
 *
 * Invert a binary tree.
 *
 * Example:
 *
 * Input:
 *
 *      4
 *    /   \
 *   2     7
 *  / \   / \
 * 1   3 6   9
 *
 * Output:
 *
 *      4
 *    /   \
 *   7     2
 *  / \   / \
 * 9   6 3   1
 *
 * Trivia:
 * This problem was inspired by this original tweet by Max Howell:
 *
 * Google: 90% of our engineers use the software you wrote (Homebrew), but you can&rsquo;t invert a
 * binary tree on a whiteboard so f*** off.
 ******************************************************************************************************/

//Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// 思路双指针，交换当前节点
func invertTree(root *TreeNode) *TreeNode {
	helper(root, root)
	return root
}
func helper(l, r *TreeNode) {
	if l == nil || r == nil {
		return
	}
	
}
