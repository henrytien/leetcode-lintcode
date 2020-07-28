// Source : https://leetcode.com/problems/find-minimum-in-rotated-sorted-array/
// Author : zhangshilin
// Date   : 2020-07-23
package main

import "fmt"

/*****************************************************************************************************
 *
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
 *
 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
 *
 * Find the minimum element.
 *
 * You may assume no duplicate exists in the array.
 *
 * Example 1:
 *
 * Input: [3,4,5,1,2]
 * Output: 1
 *
 * Example 2:
 *
 * Input: [4,5,6,7,0,1,2]
 * Output: 0
 *
 ******************************************************************************************************/

// 找规律题，num todo@zhangshilin wait to redo
func findMin(nums []int) int {
	l,r,mid:=0,len(nums)-1,0
	for l<=r{
		mid = l+(r-l)/2
		if nums[mid]<nums[mid+1]{
			return nums[mid]
		}
		if nums[mid-1]>nums[mid]{
			return nums[mid]
		}
		if nums[l] <nums[mid]{
			l = mid+1
		}
		if nums[l]>nums[mid]{
			r=mid-1
		}
	}
	return -1
}
func findMin2 (nums []int) int {
	left, right := 0, len(nums)-1
	for left <= right { // 实际上是不会跳出循环，当 left==right 时直接返回
		if nums[left] <= nums[right] { // 如果 [left,right] 递增，直接返回
			return nums[left]
		}
		mid := left + (right-left)>>1
		if nums[left] <= nums[mid] { // [left,mid] 连续递增，则在 [mid+1,right] 查找
			left = mid + 1
		}else {
			right = mid // [left,mid] 不连续，在 [left,mid] 查找
		}
	}
	return -1
}
// 思路： 最小值一定是在右侧被旋转过去的那一块，每次取n[mid],以右侧边界进行比较，如果比右侧边界大，那一定是在左测递增序列中，直接移动左指针，如果n[mid]比
// 比右边界小的话说明已经在右侧区域了有可能是最小值，但是不一定，所以保留n[mid]边界，继续比较，最后选出最小值
// time 100%
func findMin3(nums []int)int{
	l,r,mid:=0,len(nums)-1,0
	for l<=r{
		if l==r{
			return nums[l]
		}
		mid = l+(r-l)>>1
		if nums[mid]>nums[r]{
			l = mid+1
		}else if nums[mid]<=nums[r]{ // 保留右边界
			r = mid
		}
	}
	return -1
}
func main() {
	arr:=[]int{3,1}
	fmt.Println(findMin2(arr))
}