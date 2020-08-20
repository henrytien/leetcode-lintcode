// Source : https://leetcode.com/problems/validate-binary-search-tree/
// Author : zhangsl
// Date   : 2020-08-19
package main

import "math"

/*****************************************************************************************************
 *
 * Given a binary tree, determine if it is a valid binary search tree (BST).
 *
 * Assume a BST is defined as follows:
 *
 * 	The left subtree of a node contains only nodes with keys less than the node's key.
 * 	The right subtree of a node contains only nodes with keys greater than the node's key.
 * 	Both the left and right subtrees must also be binary search trees.
 *
 * Example 1:
 *
 *     2
 *    / \
 *   1   3
 *
 * Input: [2,1,3]
 * Output: true
 *
 * Example 2:
 *
 *     5
 *    / \
 *   1   4
 *      / \
 *     3   6
 *
 * Input: [5,1,4,null,null,3,6]
 * Output: false
 * Explanation: The root node's value is 5 but its right child's value is 4.
 *
 ******************************************************************************************************/

//Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
// 思路 二叉搜索树： 根节点>左子树中所有的值 根节点<右子树中所有的值
// 区间在随着向下遍历而不断缩小
// time:76 mem:75
func isValidBST(root *TreeNode) bool {
	return helper(root,math.MinInt64,math.MaxInt64)
}
func helper(root *TreeNode,l ,r int64)bool{
	if root == nil{
		return true
	}
	// 如果当前节点合法
	if int64(root.Val)<r && int64(root.Val)>l{
		return helper(root.Left,l,int64(root.Val)) && helper(root.Right,int64(root.Val),r)
	}
	return false
}