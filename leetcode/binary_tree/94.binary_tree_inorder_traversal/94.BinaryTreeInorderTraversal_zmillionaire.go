// Source : https://leetcode.com/problems/binary-tree-inorder-traversal/
// Author : zmillionaire
// Date   : 2020-08-24
package main

/*****************************************************************************************************
 *
 * Given a binary tree, return the inorder traversal of its nodes' values.
 *
 * Example:
 *
 * Input: [1,null,2,3]
 *    1
 *     \
 *      2
 *     /
 *    3
 *
 * Output: [1,3,2]
 *
 * Follow up: Recursive solution is trivial, could you do it iteratively?
 ******************************************************************************************************/
// time:100 mem:100
//Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}
var ans  = []int{}
func inorderTraversal(root *TreeNode) []int {
	ans = []int{}
	helper(root)
	return ans
}
func helper(root *TreeNode){
	if root==nil{
		return
	}
	helper(root.Left)
	ans = append(ans, root.Val)
	helper(root.Right)
}
