// Source : https://leetcode.com/problems/jump-game-ii/
// Author : zhangshilin
// Date   : 2020-07-16
/*****************************************************************************************************
 *
 * Given an array of non-negative integers, you are initially positioned at the first index of the
 * array.
 *
 * Each element in the array represents your maximum jump length at that position.
 *
 * Your goal is to reach the last index in the minimum number of jumps.
 *
 * Example:
 *
 * Input: [2,3,1,1,4]
 * Output: 2
 * Explanation: The minimum number of jumps to reach the last index is 2.
 *     Jump 1 step from index 0 to 1, then 3 steps to the last index.
 *
 * Note:
 *
 * You can assume that you can always reach the last index.
 ******************************************************************************************************/
 package main
 // 解法1 time: O(N^2)
func jump(nums []int) int {
	step := 0
	//边界
	if nums == nil {
		return step
	}

	position := len(nums) - 1
	for position > 0 {
		for i := 0; i < position; i++ {
			if i+nums[i] > position {
				position = i
				step++
				break
			}
		}
	}
	return step
}

// 解法2 time O(N) space O(n)
func jump2(nums []int) int {
	length := len(nums)
	end := 0
	maxPosition := 0
	steps := 0
	for i := 0; i < length-1; i++ {
		maxPosition = max(maxPosition, i+nums[i])
		if i == end {
			if maxPosition >= length-1 {
				return steps + 1
			}
			end = maxPosition
			steps++

		}
	}
	return steps
}

func max(x, y int) int {
	if x > y {
		return x
	}
	return y
}
