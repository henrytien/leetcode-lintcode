// Source : https://leetcode.com/problems/serialize-and-deserialize-binary-tree/
// Author : zhangsl
// Date   : 2020-08-18
package main

import "strconv"

/*****************************************************************************************************
 *
 * Serialization is the process of converting a data structure or object into a sequence of bits so
 * that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 *
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary tree can
 * be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * Example:
 *
 * You may serialize the following tree:
 *
 *     1
 *    / \
 *   2   3
 *      / \
 *     4   5
 *
 * as "[1,2,3,null,null,4,5]"
 *
 * Clarification: The above format is the same as how LeetCode serializes a binary tree. You do not
 * necessarily need to follow this format, so please be creative and come up with different approaches
 * yourself.
 *
 * Note: Do not use class member/global/static variables to store states. Your serialize and
 * deserialize algorithms should be stateless.
 ******************************************************************************************************/
//time:7 mem:5 todo@zhangsl need to optimize
// this solution just to test correctness of thought.
//* Definition for a binary tree node.
type TreeNode struct {
	Val   int
	Left  *TreeNode
	Right *TreeNode
}

type Codec struct {
	data []string
	s string
}

func Constructor() Codec {
	return Codec{}
}

// Serializes a tree to a single string.
func (this *Codec) serialize(root *TreeNode) string {
	if root == nil{
		this.s+="nil,"
		this.data = append(this.data, "nil")
	}else{
		this.s+=strconv.Itoa(root.Val)
		this.data = append(this.data,strconv.Itoa(root.Val))
		this.s = this.serialize(root.Left)
		this.s = this.serialize(root.Right)
	}
	return this.s
}

// Deserializes your encoded data to tree.
func (this *Codec) deserialize(data string) *TreeNode {
	if this.data[0]=="nil"{
		this.data = this.data[1:]
		return nil
	}
	val,_:=strconv.Atoi(this.data[0])
	root:=&TreeNode{Val: val}
	root.Left = this.deserialize(data)
	root.Right = this.deserialize(data)
	return root
}

/**
 * Your Codec object will be instantiated and called as such:
 * obj := Constructor();
 * data := obj.serialize(root);
 * ans := obj.deserialize(data);
 */
