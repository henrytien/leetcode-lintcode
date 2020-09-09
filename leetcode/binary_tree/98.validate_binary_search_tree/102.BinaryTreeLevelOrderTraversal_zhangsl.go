// Source : https://leetcode.com/problems/binary-tree-level-order-traversal/
// Author : zhangsl
// Date   : 2020-08-20
package main

/*****************************************************************************************************
 *
 * Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to
 * right, level by level).
 *
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *
 *     3
 *    / \
 *   9  20
 *     /  \
 *    15   7
 *
 * return its level order traversal as:
 *
 * [
 *   [3],
 *   [9,20],
 *   [15,7]
 * ]
 *
 ******************************************************************************************************/

//Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

// 思路: 修改版广度优先遍历
// 1. 初始化：根节点入队 Q1
// 2. 出队Q1中所有的元素，并记录在ans中，并在出队时，将子元素入队Q2
// 3. Q2变成Q1 进行步骤2
// time:100 mem:99
func levelOrder(root *TreeNode) [][]int {
	var (
		q1  = []*TreeNode{} //队列1
		q2  = []*TreeNode{} //队列2
		q3  = []int{}       //出队结果
		ans = [][]int{}     //最终结果
	)
	// 入参检查
	if root == nil {
		return nil
	}
	// 初始化
	q1 = append(q1, root)
	for i := 0; len(q1) > 0; i++ {
		q3 = []int{}
		for j := 0; j < len(q1); j++ {
			q3 = append(q3, q1[j].Val)
			if q1[j].Left!=nil{
				q2 = append(q2, q1[j].Left)
			}
			if q1[j].Right!=nil{
				q2 = append(q2, q1[j].Right)
			}

		}
		ans = append(ans, q3)
		q1 = q2
	}
	return ans
}
