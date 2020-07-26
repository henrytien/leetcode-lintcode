// Source : https://leetcode.com/problems/intersection-of-two-arrays/
// Author : zmillionaire
// Date   : 2020-07-26
package main

/*****************************************************************************************************
 *
 * Given two arrays, write a function to compute their intersection.
 *
 * Example 1:
 *
 * Input: nums1 = [1,2,2,1], nums2 = [2,2]
 * Output: [2]
 *
 * Example 2:
 *
 * Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
 * Output: [9,4]
 *
 * Note:
 *
 * 	Each element in the result must be unique.
 * 	The result can be in any order.
 *
 ******************************************************************************************************/

func intersection(nums1 []int, nums2 []int) []int {
	if nums1 == nil || nums2 == nil || len(nums1) == 0 || len(nums2) == 0 {
		return nil
	}
	m := make(map[int]struct{})
	ans := make(map[int]struct{})
	for _, v := range nums1 {
		m[v] = struct{}{}
	}

	for _, v := range nums2 {
		if _, ok := m[v]; ok {
			ans[v] = struct{}{}
		}
	}
	ansSlice := []int{}
	for k, _ := range ans {
		ansSlice = append(ansSlice, k)
	}
	return ansSlice
}
