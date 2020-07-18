// Source : https://leetcode.com/problems/3sum-closest
// Author : zhangshilin
// Date   : 2020-07-17
package main

import "sort"

/*****************************************************************************************************
 *
 * Given an array nums of n integers and an integer target, find three integers in nums such that the
 * sum is closest to target. Return the sum of the three integers. You may assume that each input
 * would have exactly one solution.
 *
 * Example 1:
 *
 * Input: nums = [-1,2,1,-4], target = 1
 * Output: 2
 * Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
 *
 * Constraints:
 *
 * 	3 <= nums.length <= 10^3
 * 	-10^3 <= nums[i] <= 10^3
 * 	-10^4 <= target <= 10^4
 ******************************************************************************************************/
//暴力
func threeSumClosest(nums []int, target int) int {
	ans := 0
	sum := 0
	minDis := 10000
	disTance := 0
	for i := 0; i < len(nums); i++ {
		for j := i + 1; j < len(nums); j++ {
			for k := j + 1; k < len(nums); k++ {
				sum = nums[i] + nums[j] + nums[k]
				disTance = distance(sum, target)
				if disTance < minDis {
					minDis = disTance
					ans = sum
				}
			}
		}
	}
	return ans
}

//
func distance(i, j int) int {
	i = i - j
	if i < 0 {
		return -i
	}
	return i
}

//o(n^2)
func threeSumClosest2(nums []int, target int) int {
	distance := func(i, j int) int {
		i = i - j
		if i < 0 {
			return -i
		}
		return i
	}

	ans := 0
	minDistance := 10000
	sort.Ints(nums)
	l, r := 0, 0
	for i := 0; i < len(nums); i++ {
		l = i + 1
		r = len(nums) - 1
		for l < r {
			sum := nums[i] + nums[l] + nums[r]
			dis := distance(sum, target)
			if dis < minDistance {
				minDistance = dis
				ans = sum
			}
			if sum == target {
				return target
			} else if sum > target {
				r--
			} else {
				l++
			}
		}
	}
	return ans
}
