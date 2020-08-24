// Source : https://leetcode.com/problems/flatten-binary-tree-to-linked-list/
// Author : zmillionaire
// Date   : 2020-08-24
package main

/*****************************************************************************************************
 *
 * Given a binary tree, flatten it to a linked list in-place.
 *
 * For example, given the following tree:
 *
 *     1
 *    / \
 *   2   5
 *  / \   \
 * 3   4   6
 *
 * The flattened tree should look like:
 *
 * 1
 *  \
 *   2
 *    \
 *     3
 *      \
 *       4
 *        \
 *         5
 *          \
 *           6
 *
 ******************************************************************************************************/

//Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
// 思路：通过观察 生成的链表顺序就是先序遍历的顺序
// 逻辑首相将右子树挪到左子树的最右边，然后左子树挪到右子树的位置
//time:64 mem:69
func flatten(root *TreeNode) {
	for root!=nil{
		if root.Left==nil{//左子树为空，继续搞右子树
			root = root.Right
		}else{//左子树不为空
			//走到左子树的最右端
			pre:=root.Left
			for pre.Right!=nil{
				pre = pre.Right
			}
			//  将右子树迁移到这个位置
			pre.Right = root.Right
			//	将左子树迁移到右子树
			root.Right = root.Left
			root.Left = nil
			//  继续下去
			root = root.Right
		}
	}
}
