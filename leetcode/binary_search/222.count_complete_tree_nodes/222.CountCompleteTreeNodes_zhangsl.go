// Source : https://leetcode.com/problems/count-complete-tree-nodes/
// Author : zhangsl
// Date   : 2020-07-27
package main

/*****************************************************************************************************
 *
 * Given a complete binary tree, count the number of nodes.
 *
 * Note:
 *
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all
 * nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive
 * at the last level h.
 *
 * Example:
 *
 * Input:
 *     1
 *    / \
 *   2   3
 *  / \  /
 * 4  5 6
 *
 * Output: 6
 ******************************************************************************************************/

/**
* Definition for a binary tree node.
* type TreeNode struct {
*     Val int
*     Left *TreeNode
*     Right *TreeNode
* }
 */

type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// 思路 利用完全二叉树的性质，除最后一层，其他层都是满层,最后一层按照从到右排列

//计算树的高度
func treeHeight(root *TreeNode) int{
	ans:=0
	for root!=nil{
		ans++
		root = root.Left
	}
	return ans
}
func countNodes(root *TreeNode) int {
//
	if root==nil{
		return 0
	}
	lHeight:=treeHeight(root.Left)
	rHeight:=treeHeight(root.Right)
	if lHeight==rHeight{// 左右等高,左边一定是满二叉树
		return (1<<lHeight)+countNodes(root.Right)
	}else if lHeight>rHeight{//右边是满二叉树
		return (1<<rHeight)+countNodes(root.Left)
	}
	return 0

}
//todo add bin_search solution @zhangshilin