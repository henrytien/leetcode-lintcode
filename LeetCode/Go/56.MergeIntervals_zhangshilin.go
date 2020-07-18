// Source : https://leetcode.com/problems/merge-intervals/
// Author : zhangshilin
// Date   : 2020-07-18
package main

import "sort"

/*****************************************************************************************************
 *
 * Given a collection of intervals, merge all overlapping intervals.
 *
 * Example 1:
 *
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 *
 * Example 2:
 *
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 *
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to
 * get new method signature.
 ******************************************************************************************************/
//思路 ：根据区间左端点排序，然后合并
func merge(intervals [][]int) [][]int {
	//边界检查
	if intervals == nil || len(intervals) < 1 {
		return nil
	}
	merged := [][]int{}
	//	排序
	sort.Slice(intervals, func(i, j int) bool {
		return intervals[i][0] < intervals[j][0]
	})
	//	初始化
	merged = append(merged, intervals[0])
	for i := 1; i < len(intervals); i++ {
		m := merged[len(merged)-1]
		it := intervals[i]
		// 不可以合并
		if it[0] > m[1] {
			merged = append(merged, it)
			continue
		}
		//可以合并
		if it[1] > m[1] {
			m[1] = it[1]
		}

	}
	return merged

}
