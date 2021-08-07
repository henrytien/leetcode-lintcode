// Source : https://leetcode.com/problems/median-of-two-sorted-arrays/
// Author : zhangsl
// Date   : 2020-07-27
package main

import (
	"fmt"
)

/*****************************************************************************************************
 *
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 *
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * You may assume nums1 and nums2 cannot be both empty.
 *
 * Example 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * The median is 2.0
 *
 * Example 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * The median is (2 + 3)/2 = 2.5
 *
 ******************************************************************************************************/
// 常规解法
// 归并排序 : 思想： 两个指针 移动小的一端，当有一个指针移动到尾部，推出循环
// 中位数 ，如果数组长度为奇数则 中位数为：arr[(len-1)/2]
//  		if the len of the array is even,(arr[(len-1)/2)]+arr[(len-1)/2+1])/2

func findMedianSortedArrays(nums1 []int, nums2 []int) float64 {
	// border justice
	if nums1 == nil || nums2 == nil {
		return 0
	}

	arr := make([]int, 0)
	p1, p2 := 0, 0
	for p1 < len(nums1) && p2 < len(nums2) {
		//	pick small
		if nums1[p1] <= nums2[p2] {
			arr = append(arr, nums1[p1])
			p1++
		} else {
			arr = append(arr, nums2[p2])
			p2++
		}
	}
	// 循环出来 肯定只剩下一个 没有遍历完的
	for p1 < len(nums1) {
		arr = append(arr, nums1[p1])
		p1++
	}

	for p2 < len(nums2) {
		arr = append(arr, nums2[p2])
		p2++
	}
	//	calc ans
	mid := (len(arr) - 1) / 2
	if len(arr)&1 == 0 { // odd
		return float64(arr[mid]+arr[mid+1]) / 2.0
	} else {
		return float64(arr[mid])
	}
}
//


func min(a,b int)int{
	if a<=b{
		return a
	}
	return  b
}
// 解法2： 不开辟额外的数组，因为已知两个数组长度，则中位数的下标位置已经确定，通过找到这个位置，并存储这个位置的数字
// todo wait to complete @zhanggshilin
func findMedianSortedArrays2(nums1 []int, nums2 []int) float64{

	targetPos:=(len(nums2)+len(nums1)-1)/2
	ans:=0
	var p1,p2,cnt int
	for {
		if p1+p2>targetPos+1{
			break
		}
		if p1+p2==targetPos || p1+p2==targetPos+1{
			ans+= min(nums1[p1],nums2[p2])
		}
		if nums1[p1] <= nums2[p2] {

			p1++
			cnt++

		} else {
			p2++
			cnt++
		}
	}
	// p1,p2 处理
	if p2 == len(nums2){
		p2-=1
		for p1<len(nums1){
			p1++
			if p1+p2==targetPos || p1+p2==targetPos+1{
				ans+= min(nums1[p1],nums2[p2])
			}
		}
	}
	if p1+p2<targetPos{

	}
	 return float64(ans)/2.0
}
// todo wait to complete @zhangshilin
// 解法3 ：二分
func main() {
	arr := []int{1, 2, 3}
	arr1 := []int{4, 5, 6}
	fmt.Println(findMedianSortedArrays(arr, arr1))
}
