// Source : https://leetcode.com/problems/search-in-rotated-sorted-array/
// Author : zhangshilin
// Date   : 2020-07-22
package main

import "fmt"

/*****************************************************************************************************
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
 *
 * You are given a target value to search. If found in the array return its index, otherwise return -1.
 *
 * You may assume no duplicate exists in the array.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 *
 * Example 1:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 0
 * Output: 4
 *
 * Example 2:
 *
 * Input: nums = [4,5,6,7,0,1,2], target = 3
 * Output: -1
 ******************************************************************************************************/
//todo 第一次边界条件没有处理好，对于或后面的条件需要再好好思考一下
func search(nums []int, target int) int {
	//
	var (
		l   = 0
		r   = len(nums) - 1
		mid = 0
	)
	for l <= r {
		//
		mid = l + (r-l)/2
		if nums[mid] == target {
			return mid
		}
		//left order
		if nums[mid] > nums[l] {
			if (target >= nums[l] && target < nums[mid]) || (target == nums[l]) {
				r = mid - 1
			} else {
				l = mid + 1
			}
		} else { //right order
			if (target > nums[mid] && target <= nums[r]) || (target == nums[r]) {
				l = mid + 1
			} else {
				r = mid - 1
			}
		}
	}
	return -1
}
//双100
func search2(nums []int, target int) int {
	l, r, mid := 0, len(nums)-1, 0

	for l <= r {
		mid = l + (r-l)/2
		if nums[mid] == target {
			return mid
		}
		if nums[l] <= nums[mid] { //左边有序
			if target > nums[mid] {
				l = mid + 1
			} else if target>=nums[l] {
				r = mid - 1
			}else{
				l=mid+1
			}
		} else { // 右侧有序
			if target < nums[mid] {
				r = mid - 1
			} else if target<=nums[r]{
				l = mid + 1
			}else{
				r=mid-1
			}
		}
	}
	return -1
}
func main() {
	arr := []int{
		3,1}
	fmt.Println(search2(arr, 1))
}
